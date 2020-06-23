package com.elasticsearch.application.searchcurd;


import com.alibaba.fastjson.JSON;
import com.elasticsearch.application.Application;
import com.elasticsearch.application.User;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class RestHighLevelClientDemo {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    private String index = "bilibili";

    private String type = "zbc";

    /**
     * 创建一个索引,并插入数据
     *
     * @throws IOException
     */
    @Test
    public void insertDate() throws IOException {

        User user = new User("王雷", 22, "卖鱼");
        String source = JSON.toJSONStringWithDateFormat(user, "");
        IndexRequest indexRequest = new IndexRequest(index, type);
        indexRequest.source(source, XContentType.JSON).id("3");
        //index方法第二个参数can not null
        restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
    }


    /**
     * 修改索引中的对象值
     */
    @Test
    public void updateTest() {
        String id = "1";
        UpdateRequest updateRequest = new UpdateRequest(index, type, id);
        Map<String, Object> map = new HashMap<>();
        map.put("name", "吴二狗");
        updateRequest.doc(map);
        try {
            restHighLevelClient.update(updateRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 根据条件查询
     */
    @Test
    public void queryTest() {
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        //设置分页查询
        sourceBuilder.from(0);
        sourceBuilder.size(10);
        //设置返回的数据中所需要的字段
//        sourceBuilder.fetchSource(new String[]{"age", "name"}, new String[]{});

        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("age", "22");
//        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", "吴二狗");
//
//        RangeQueryBuilder rangeQueryBuilder = QueryBuilders.rangeQuery("age");
//        rangeQueryBuilder.gte("20");
//        rangeQueryBuilder.lte("30");

        BoolQueryBuilder boolBuilder = QueryBuilders.boolQuery();
        boolBuilder.must(matchQueryBuilder);
//        boolBuilder.must(termQueryBuilder);
//        boolBuilder.must(rangeQueryBuilder);

        sourceBuilder.query(boolBuilder);
        SearchRequest searchRequest = new SearchRequest(index);
        searchRequest.types(type);
        searchRequest.source(sourceBuilder);
        try {
            SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            //处理返回值----------
            long value = response.getHits().getTotalHits().value;
            System.out.println("查询总数为= "+value);
            SearchHits hits = response.getHits();
            SearchHit[] hits1 = hits.getHits();
            for (SearchHit documentFields : hits1) {
                String sourceAsString = documentFields.getSourceAsString();
                System.out.println(sourceAsString);
            }
            //---------------------
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
