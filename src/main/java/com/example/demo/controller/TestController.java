package com.example.demo.controller;

import com.example.demo.redis.RedisTest;
import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    private RedisTest redisTest;

    @GetMapping("/test1")
    public String test1(String name){
        testService.sout(name);
        return "success";
    }

    @GetMapping("redisTest")
    public void redis(){
        redisTest.addAndGet();
    }

}
