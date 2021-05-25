package com.example.demo.controller;


import com.example.demo.bean.MongdbBeanUser;
import com.example.demo.service.MongdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MongDBController {

    @Autowired
    private MongdbService mongdbService;

    @GetMapping("/mongdbSave")
    public String save(String name){
        MongdbBeanUser mongdbBeanUser = new MongdbBeanUser();
        if (!StringUtils.isEmpty(name)){
            mongdbBeanUser.setAddress("定兴");
            mongdbBeanUser.setAge(18);
            mongdbBeanUser.setSchool("一中");
            mongdbBeanUser.setScore(100);
        }else {
            name="wuergou";
        }
        mongdbBeanUser.setName(name);
        mongdbService.saveBean(mongdbBeanUser);
        return "success";
    }

    @GetMapping("/findOne")
    public MongdbBeanUser findOne(String name){
       return mongdbService.findOne(name);
    }


    @GetMapping("/findAll")
    public List<MongdbBeanUser> findAll(){
        return mongdbService.findAll();
    }
}
