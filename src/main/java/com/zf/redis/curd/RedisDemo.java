package com.zf.redis.curd;

import com.zf.redis.RedisApplication;
import com.zf.redis.utils.RedisOperator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;
import java.util.Set;


@SpringBootTest(classes = RedisApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class RedisDemo {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private RedisOperator redisOperator;

    /**
     * string  一系列操作
     */
    @Test
    public void string() {
//        set string
        redisOperator.set("sb", "不是吴二狗么");
//        get string
        String string = redisTemplate.opsForValue().get("sb").toString();
        System.out.println(string);

        redisOperator.expire("sb", 30);

//        自增
        redisTemplate.opsForValue().set("num", "1");
        redisTemplate.opsForValue().increment("num");
        String num = redisTemplate.opsForValue().get("num");
        System.out.println(num);

//        查看剩余过期时间.若为-2则时间结束,若为-1则未设置时间
        long num1 = redisOperator.ttl("sb");
        System.out.println(num1);

    }

    /**
     * hash 的一系列操作
     */
    @Test
    public void hash() {
//        set
//        redisOperator.hset("sb","sb1=","李星星");
//        redisOperator.hset("sb","sb2=","大江江");
//        redisOperator.hset("sb","sb3=","吴二狗");
//        get
        Map<Object, Object> sb = redisOperator.hgetall("sb");
//        System.out.println(sb);
        Set<Object> objects = sb.keySet();
        for (Object object : objects) {
            Object o = sb.get(object);
            System.out.println(object + "" + o);
        }
    }

    /**
     *  set 的一系列操作
     */
    @Test
    public void set() {
//        redisOperator.jhset("er","吴二狗");
//        redisOperator.jhset("er","大星星");
//        redisOperator.jhset("er","狗圣圣");

        Set<String> er = redisOperator.jhget("er");
        for (String s : er) {
            System.out.println(s);
        }
    }



    @Test
    public void zset(){
//        redisOperator.zset("zset","1崽子",9);
//        redisOperator.zset("zset","3崽子",5);
//        redisOperator.zset("zset","2崽子",6);
//        redisOperator.zset("zset","4崽子",1);
//        Set<String> zset = redisOperator.zgetRange("zset", 0, 1);
//        Set<String> zset = redisOperator.zgetRangByScore("zset", 5, 6);
//
//        System.out.println(zset);
        Long zset1 = redisOperator.zsetLength("zset");
        System.out.println(zset1);


    }




}
