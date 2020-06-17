package com.session.share.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class MyController {

    /**
     * 通过get请求 获取session之后将name 存入session 并存入redis
     * @param request
     * @param name
     * @return
     */
    @GetMapping(value = "/setname/{name}")
    public String setName(HttpServletRequest request,@PathVariable("name") String name){
        System.out.println("接收到的name="+" "+name);
        HttpSession session = request.getSession();
        session.setAttribute("name",name);
        return "success";
    }


    /**
     * 获取 name 值
     * @param request
     * @return
     */
    @GetMapping(value = "/getname")
    public String getName(HttpServletRequest request){
        HttpSession session = request.getSession();
        String name =(String) session.getAttribute("name");
        System.out.println(name);
        return name;
    }


}
