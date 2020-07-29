package com.cnbg.service.sample.sample.intf;


import javax.jws.WebService;

@WebService(targetNamespace = "http://service.cnbg.com/sample/sample/intf")//指定webservice所实现的接口以及服务名称
public class SecondWebServiceImpl implements SecondWebService {


    @Override
    public String test(String servicename, String methodname, String value) {
        try {
            int i = (int) (Math.random() * 10000);
            System.out.println("响应时间= "+i);
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("接收到的值= "+servicename+" "+methodname+" "+value);
        String response="{\n" +
                "    \"code\":\"200\",\n" +
                "    \"msg\":\"success\"\n" +
                "}";
        return response;
    }

}
