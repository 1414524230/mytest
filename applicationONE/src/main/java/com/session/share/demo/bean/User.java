package com.session.share.demo.bean;

import java.io.Serializable;


/**
 * 若需要想redis中存入对象需要对象的包名一致,并且需要实现序列号接口
 */
public class User implements Serializable {

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
