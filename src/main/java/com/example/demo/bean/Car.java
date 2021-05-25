package com.example.demo.bean;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

@Data
public class Car {

    public Car(Integer num,String carName) {
        this.carName = carName;
        this.num = num;
    }

    @Excel(name = "车型",orderNum = "2")
    private String carName;

    @Excel(name = "编号",orderNum = "1")
    private Integer num;

}
