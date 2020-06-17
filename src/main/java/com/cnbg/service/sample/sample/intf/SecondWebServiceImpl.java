package com.cnbg.service.sample.sample.intf;


import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(endpointInterface= "com.cnbg.service.sample.sample.intf.SecondWebService",serviceName="secondWebService",  targetNamespace = "http://service.cnbg.com/sample/sample/intf")//指定webservice所实现的接口以及服务名称
public class SecondWebServiceImpl implements SecondWebService {


    @Override
    public String test(@WebParam(name = "xml")String xml) {
        System.out.println("接收到的值为uuid"+xml);
        return "success";
    }
}
