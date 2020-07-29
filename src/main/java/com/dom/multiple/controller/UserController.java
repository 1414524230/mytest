package com.dom.multiple.controller;

import com.dom.multiple.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @Autowired
    UserService userService;

    @GetMapping("/user")
    public void insert(){
        userService.insert();
    }

    @GetMapping("/test")
    public String test(){
        return "hehe";
    }





}
