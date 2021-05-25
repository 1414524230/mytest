package com.example.demo.redis;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisTest {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;


    @Test
    public void addAndGet(){
        redisTemplate.opsForValue().set("wuergou","test");
        Object wuergou = redisTemplate.opsForValue().get("wuergou");
        System.out.println(wuergou);

    }


}
