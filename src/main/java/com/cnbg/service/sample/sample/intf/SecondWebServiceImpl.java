package com.cnbg.service.sample.sample.intf;


import javax.jws.WebService;

@WebService(targetNamespace = "http://service.cnbg.com/sample/sample/intf")//指定webservice所实现的接口以及服务名称
public class SecondWebServiceImpl implements SecondWebService {


    @Override
    public String test(String xml) {
        System.out.println("接收到的值为uuid"+xml);
        return "success";
    }
}
