package com.example.webserviceclient.client;

import com.example.webserviceclient.common.RequestHeadDTO;
import com.example.webserviceclient.sample.SampleRequest;
import com.example.webserviceclient.sample.SampleRequestDTO;
import com.example.webserviceclient.sample.SampleResponse;
import com.example.webserviceclient.webservice.Sample;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import org.apache.cxf.interceptor.OutInterceptors;
import org.junit.Test;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import java.net.MalformedURLException;
import java.net.URL;

@OutInterceptors(interceptors = { "com.example.webserviceclient.apdter.ArtifactOutInterceptor" })
public class WebServiceClient {



    //此方式是通过wsdl生成服务端代码之后调用
    @Test
    public void invoke(){
        URL url = null;
        try {
//            url = new URL("http://172.25.36.244:8085/webServiceDemo?wsdl");
            url = new URL("http://172.25.37.9:8085/webServiceDemo?wsdl");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        //创建服务名称
        //1.namespaceURI - 命名空间地址
        //2.localPart - 服务视图名
        QName qname = new QName("http://service.cnbg.com/sample/sample/intf", "SampleService");
        javax.xml.ws.Service service = javax.xml.ws.Service.create(url, qname);
        Sample port = service.getPort(Sample.class);
//        Sample port = service.getPort(Sample.class);
        SampleRequest sampleRequest = new SampleRequest();
        RequestHeadDTO requestHeadDTO = new RequestHeadDTO();
        requestHeadDTO.setConsumerID("z");
        requestHeadDTO.setProviderID("s");
        requestHeadDTO.setReqSeqNo("w");
        sampleRequest.setRequestHead(requestHeadDTO);

        SampleRequestDTO sampleRequestDTO = new SampleRequestDTO();
        sampleRequestDTO.setInput1("4");
        sampleRequest.setRequestBody(sampleRequestDTO);

        SampleResponse sample = port.sample(sampleRequest);
        System.out.println(sample);
    }

    @Test
    public void invoke1(){
        try {
//            String url = "http://172.25.37.9:8085/webServiceDemo?wsdl";
            String url = "http://172.25.37.9:8085/secondService?wsdl";
            Service service = new Service();
            Call call = (Call) service.createCall();
            QName qn = new QName("http://service.cnbg.com/sample/sample/intf", "second");
            call.setTargetEndpointAddress(new URL(url));
//            call.setOperationName(new QName("http://service.cnbg.com/sample/sample/intf", "zf"));
            call.setOperationName(qn);
            //        call.setUseSOAPAction(true);
            //        call.setSOAPActionURI("http://com.soft.ws/my/authorization");
            call.addParameter("xml", XMLType.XSD_STRING, ParameterMode.IN);

            call.setReturnType(XMLType.XSD_STRING);
            String xml="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:bean=\"http://service.cnbg.com/sample/sample/bean\" xmlns:head=\"http://service.cnbg.com/common/head\">\n" +
                    "   <soapenv:Header/>\n" +
                    "   <soapenv:Body>\n" +
                    "      <bean:SampleRequest>\n" +
                    "         <bean:requestHead>\n" +
                    "            <!--Optional:-->\n" +
                    "            <head:reqSeqNo>?</head:reqSeqNo>\n" +
                    "            <!--Optional:-->\n" +
                    "            <head:serviceName>?</head:serviceName>\n" +
                    "            <!--Optional:-->\n" +
                    "            <head:version>?</head:version>\n" +
                    "            <head:consumerID>?</head:consumerID>\n" +
                    "            <head:providerID>?</head:providerID>\n" +
                    "            <!--Optional:-->\n" +
                    "            <head:sign>?</head:sign>\n" +
                    "         </bean:requestHead>\n" +
                    "         <bean:requestBody>\n" +
                    "            <!--Optional:-->\n" +
                    "            <bean:input1>?</bean:input1>\n" +
                    "         </bean:requestBody>\n" +
                    "      </bean:SampleRequest>\n" +
                    "   </soapenv:Body>\n" +
                    "</soapenv:Envelope>";
            Object result = call.invoke(new Object[]{xml});
            System.out.println(result.toString());
        }catch (Exception e){
            System.out.println(e+"  ");
        }
    }
}
