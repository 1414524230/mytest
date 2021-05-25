package com.example.demo.bean;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import lombok.Data;

import java.util.List;

@Data
public class CarFactory {

    //needMerge = true 用于纵向列合并
    @Excel(name = "id",isImportField = "true",orderNum = "1",needMerge = true)
    private String id;

    @Excel(name = "车企名称",orderNum = "2",needMerge = true)
    private String factoryName;

    @Excel(name = "国家",orderNum = "3",needMerge = true)
    private String countryName;

    @ExcelCollection(name = "车型",orderNum = "4")
    private List<Car> carList;

}
