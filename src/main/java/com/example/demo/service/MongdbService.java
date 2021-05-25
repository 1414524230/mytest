package com.example.demo.service;

import com.example.demo.bean.MongdbBeanUser;

import java.util.List;

public interface MongdbService {

    void saveBean(MongdbBeanUser user);

    MongdbBeanUser findOne(String param);

    List<MongdbBeanUser> findAll();




}
