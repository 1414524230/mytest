package com.cnbg.service.sample.sample.intf;

import com.cnbg.service.Mybean.Request;

import javax.jws.WebService;

@WebService(targetNamespace = "http://service.cnbg.com/sample/sample/intf")//指定webservice所实现的接口以及服务名称
public class ThirdServiceImpl implements ThirdService {

    @Override
    public String test(Request request, String parm1, String parm2) {
        return null;
    }
}
