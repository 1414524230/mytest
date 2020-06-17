package com.cnbg.service.push;


import com.cnbg.service.sample.sample.intf.SampleEndpointImpl;
import com.cnbg.service.sample.sample.intf.SecondWebServiceImpl;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.xml.ws.Endpoint;


@Component
public class WebServicePush implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args){
        System.out.println("开始发布服务");
        SampleEndpointImpl webServiceDemo = new SampleEndpointImpl();
        SecondWebServiceImpl secondWebService = new SecondWebServiceImpl();
        //使用publish方法发布,指定需要发布的ip和port
        try {
            //通过Endpoint发布webservice服务
            EndpointImpl publish = (EndpointImpl)Endpoint.publish("http://172.25.37.9:8085/webServiceDemo", webServiceDemo);
            EndpointImpl publish1 = (EndpointImpl)Endpoint.publish("http://172.25.37.9:8085/secondService", secondWebService);
            //添加过滤器操作可对返回值作处理
//            publish.getOutInterceptors().add(new ArtifactOutInterceptor());
            //添加过滤器操作可对请求值作处理
//            publish.getInInterceptors().add(new ArtifactOutInterceptor());

        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("发布完成");
    }
}
