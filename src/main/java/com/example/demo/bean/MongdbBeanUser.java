package com.example.demo.bean;


import lombok.Data;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("mongdbBeanUser")
@Data
public class MongdbBeanUser {

//    private String id;

    @Field("fieldName")
    private String name;

    @Field("address")
    private String address;

    //使用此注解可防止数据存入mongdb
    @Transient
    private String school;

    @Field
    private Integer age;

    @Field
    private Integer score;

}
