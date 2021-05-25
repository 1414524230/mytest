package com.example.demo.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.example.demo.bean.Car;
import com.example.demo.bean.CarFactory;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@Controller
public class PoiController {


    /**
     * 导出
     * @param response
     */
    @GetMapping("/testpoi")
    public void daochu(HttpServletResponse response) throws IOException {
        // 设置响应输出的头类型
        response.setHeader("content-Type",     "application/vnd.ms-excel");
        // 下载文件的默认名称
        response.setHeader("Content-Disposition",    "attachment;filename=test.xls");

        ArrayList<Car> objects = new ArrayList<>();
        objects.add(new Car(1,"雷克萨斯ES"));
        objects.add(new Car(2,"丰田普拉达"));
        objects.add(new Car(3,"丰田凯美瑞"));

        ArrayList<Car> objects1 = new ArrayList<>();
        objects1.add(new Car(1,"奥迪R8"));
        objects1.add(new Car(2,"奥迪A6L"));
        objects1.add(new Car(3,"奥迪A4L"));

        CarFactory carFactory = new CarFactory();
        carFactory.setCarList(objects);
        carFactory.setId("1");
        carFactory.setFactoryName("丰田");
        carFactory.setCountryName("日本");

        CarFactory carFactory1 = new CarFactory();
        carFactory1.setCarList(objects1);
        carFactory1.setId("2");
        carFactory1.setFactoryName("奥迪");
        carFactory1.setCountryName("德国");

        ArrayList<CarFactory> result = new ArrayList<>();
        result.add(carFactory);
        result.add(carFactory1);

        ExportParams exportParams = new ExportParams("测试excel","车");
        Workbook sheets = ExcelExportUtil.exportExcel(exportParams, CarFactory.class, result);
        sheets.write(response.getOutputStream());
        response.getOutputStream().close();
    }


}
