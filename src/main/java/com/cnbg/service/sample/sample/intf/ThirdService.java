package com.cnbg.service.sample.sample.intf;


import com.cnbg.service.Mybean.Request;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "http://service.cnbg.com/sample/sample/intf")
public interface ThirdService {

    @WebMethod(action = "/second/second",operationName="second")
    public String test(@WebParam(name = "request")
                               Request request,@WebParam(name = "parm1")String parm1,@WebParam(name = "parm2")String parm2);

}
