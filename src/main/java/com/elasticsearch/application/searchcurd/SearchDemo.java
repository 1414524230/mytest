package com.elasticsearch.application.searchcurd;

import com.elasticsearch.application.Application;
import com.elasticsearch.application.User;
import com.google.gson.JsonObject;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.*;
import io.searchbox.indices.CreateIndex;
import io.searchbox.indices.DeleteIndex;
import io.searchbox.indices.IndicesExists;
import io.searchbox.indices.mapping.GetMapping;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class SearchDemo  {


    @Autowired
    private JestClient jestClient;

    private final String indexName="qyn";

    private final String typeName="doc";


    /**
     * 判断是否有索引
     * @throws IOException
     */
    @Test
    public void exists() throws IOException {
        String indexName="ddd";
        boolean succeeded = jestClient.execute(new IndicesExists.Builder(indexName).build()).isSucceeded();
        System.out.println(succeeded);
    }

    /**
     * 创建索引
     */
    @Test
    public void createIndex() throws IOException {
        String indexName="qyn";
        JestResult jr = jestClient.execute(new CreateIndex.Builder(indexName).build());
        System.out.println(jr.isSucceeded());
    }


    @Test
    public void deleteIndex()throws Exception{
        String indexName="qq";
        JestResult jr = jestClient.execute(new DeleteIndex.Builder(indexName).build());
        boolean succeeded = jr.isSucceeded();
        System.out.println("删除索引结果 "+succeeded);
    }

    /**
     * 获取索引映射
     * @return Mapping映射
     */
    @Test
    public void getIndexMapping(){
        String indexName="qyn";
        GetMapping getMapping = new GetMapping.Builder().addIndex(indexName).build();
        JestResult jr = null;
        String string = "";
        try {
            jr = jestClient.execute(getMapping);
            string = jr.getJsonString();
            System.out.println(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 新增数据
     * @return
     * @throws Exception
     * id-------------------->  指定主键的值
     */
    @Test
    public void insert() {
        String indexName="qyn";
        String typeName="doc";
//        User user = new User("张三", 20, "张三是个Java开发工程师");
        User user = new User("乔伊娜", 25, "非贼磕死");
        Index index = new Index.Builder(user).index(indexName).type(typeName).id("qyn").build();
        try{
            JestResult jr = jestClient.execute(index);
            System.out.println(jr.isSucceeded());
        }catch(IOException e){
            System.out.println(e);
        }
    }



    /**
     * 向ElasticSearch中批量新增
     */
    @Test
    public void insertBatch(){
        List<User> objs = new ArrayList<User>();
        User user1 = new User("小智", 29, "你的鱼有没有隔离26天");
        User user2 = new User("小刚", 22, "你虾能放生吗15");
        User user3 = new User("小霞", 33, "阿公阿嬷");
        objs.add(user1);
        objs.add(user2);
        objs.add(user3);
        boolean result = false;
        try {
//            Bulk.Builder bulk = new Bulk.Builder().defaultIndex(indexName).defaultType(typeName);
            Bulk.Builder bulk = new Bulk.Builder().defaultIndex(indexName).defaultType(typeName);
            for (Object obj : objs) {
                Index index = new Index.Builder(obj).build();
                bulk.addAction(index);
            }
            BulkResult br = jestClient.execute(bulk.build());
            result = br.isSucceeded();
        } catch (Exception e) {
            System.out.println("错误信息:"+e);
        }
        System.out.println("批量新增:"+result);
    }

    /**
     * 分页带条件搜索
     * termQuery("key", obj) 完全匹配
     * termsQuery("key", obj1, obj2..)   一次匹配多个值
     * matchQuery("key", Obj) 单个匹配, field不支持通配符, 前缀具高级特性
     * multiMatchQuery("text", "field1", "field2"..);  匹配多个字段, field有通配符忒行,根据指定字段查询符合条件的数据
     * matchAllQuery();         匹配所有文件
     */
    @Test
    public void serach1() {
        String query ="33";
        try {
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            //根据字段查询
//            searchSourceBuilder.query(QueryBuilders.matchQuery("age","26"));
            //搜索全字段中符合条件的数据
            searchSourceBuilder.query(QueryBuilders.queryStringQuery(query));
            //根据指定字段查询符合条件的数据
//            searchSourceBuilder.query(QueryBuilders.multiMatchQuery("26","age","msg"));
            //分页设置
            searchSourceBuilder.from(0).size(4);
            System.out.println("全文搜索查询语句:"+searchSourceBuilder.toString());
            System.out.println("全文搜索返回结果:"+search(jestClient,indexName, typeName, searchSourceBuilder.toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String search(JestClient jestClient,String indexName, String typeName, String query) throws Exception {
        Search search = new Search.Builder(query).addIndex(indexName).addType(typeName).build();
        JestResult jr = jestClient.execute(search);
        JsonObject jsonObject = jr.getJsonObject();
        System.out.println(jsonObject);
        System.out.println("--++"+jr.getJsonString());
        return jr.getSourceAsString();
    }


    /**
     * 区间搜索
     * 根据某个字段区间查询
     */
    @Test
    public  void serach3() {
        String createtm="age";
        String from="20";
        String to="30";

        try {
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            searchSourceBuilder.query(QueryBuilders.rangeQuery(createtm).gte(from).lte(to));
            System.out.println("区间搜索语句:"+searchSourceBuilder.toString());
            System.out.println("区间搜索返回结果:"+search(jestClient,indexName, typeName, searchSourceBuilder.toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 删除单条数据,  这个id必须是主键才能被删除
     * @return
     * @throws Exception
     */
    @Test
    public void deleteData()throws Exception{
        String id = "qyn";
        DocumentResult dr = jestClient.execute(new Delete.Builder(id).index(indexName).type(typeName).build());
        System.out.println(dr.isSucceeded());
    }


}
