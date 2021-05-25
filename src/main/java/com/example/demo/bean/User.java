package com.example.demo.bean;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    private String name;

    private Integer age;

    private Date birthday;

    private Integer socre;

    private String address;

    public User(String name, Integer age, Date birthday, Integer socre, String address) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.socre = socre;
        this.address = address;
    }
}
