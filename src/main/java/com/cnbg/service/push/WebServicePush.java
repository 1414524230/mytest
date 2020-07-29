package com.cnbg.service.push;


import com.cnbg.service.sample.sample.intf.SampleEndpointImpl;
import com.cnbg.service.sample.sample.intf.SecondWebServiceImpl;
import com.cnbg.service.sample.sample.intf.ThirdServiceImpl;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.xml.ws.Endpoint;
import java.net.InetAddress;
import java.net.UnknownHostException;


@Component
public class WebServicePush implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws UnknownHostException {
        System.out.println("开始发布服务");
        InetAddress ia=null;
        ia=ia.getLocalHost();
        String ip=ia.getHostAddress();
        System.out.println(ip);

        SampleEndpointImpl webServiceDemo = new SampleEndpointImpl();
        String url1="http://"+ip+":8085/firstService";

        SecondWebServiceImpl secondWebService = new SecondWebServiceImpl();
        String url2="http://"+ip+":8086/secondService";

        ThirdServiceImpl thirdService = new ThirdServiceImpl();
        String url3="http://"+ip+":8087/thirdService";
        //使用publish方法发布,指定需要发布的ip和port
        try {
            //通过Endpoint发布webservice服务
            EndpointImpl publish = (EndpointImpl)Endpoint.publish(url1, webServiceDemo);
            EndpointImpl publish1 = (EndpointImpl)Endpoint.publish(url2, secondWebService);
            EndpointImpl publish2 = (EndpointImpl)Endpoint.publish(url3, thirdService);
            //添加过滤器操作可对返回值作处理
//            publish.getOutInterceptors().add(new ArtifactOutInterceptor());
            //添加过滤器操作可对请求值作处理
//            publish.getInInterceptors().add(new ArtifactOutInterceptor());

        }catch (Exception e){
            System.out.println("出错了"+e);
        }
        System.out.println("发布完成地址= "+url1+"?wsdl");
        System.out.println("发布完成地址= "+url2+"?wsdl");
        System.out.println("发布完成地址= "+url3+"?wsdl");
    }
}
