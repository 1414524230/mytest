package com.elasticsearch.application;

import org.springframework.stereotype.Component;

@Component
public class User {

    public User(String name, int age, String msg) {
        this.name = name;
        this.age = age;
        this.msg = msg;
    }

    public User(String name, int age, String msg, String address) {
        this.name = name;
        this.age = age;
        this.msg = msg;
        this.address = address;
    }



    public User() {
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getmsg() {
        return msg;
    }

    public void setmsg(String msg) {
        this.msg = msg;
    }

    private int age;
    private String msg;
    private String address;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
