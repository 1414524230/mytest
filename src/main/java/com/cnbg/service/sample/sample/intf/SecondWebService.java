package com.cnbg.service.sample.sample.intf;


import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "http://service.cnbg.com/sample/sample/intf", name = "test")
public interface SecondWebService {

    @WebMethod(action = "/second/second",operationName="second")
    public String test(@WebParam(name = "xml")
                                   String xml);

}
