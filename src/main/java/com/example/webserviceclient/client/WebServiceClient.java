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
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@OutInterceptors(interceptors = { "com.example.webserviceclient.apdter.ArtifactOutInterceptor" })
public class WebServiceClient {



    //此方式是通过wsdl生成服务端代码之后调用
    @Test
    public void invoke(){
        URL url = null;
        try {
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

    /**
     * Axiscall 调用 接口方式
     */
    @Test
    public void invoke1(){
        try {
            String url = "http://172.25.37.9:8085/secondService?wsdl";
            Service service = new Service();
            Call call = (Call) service.createCall();
            QName qn = new QName("http://service.cnbg.com/sample/sample/intf", "second");
            call.setTargetEndpointAddress(new URL(url));
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

    /**
     * httpconnection 调用 本地webservice服务
     *
     */
    @Test
    public void http() throws Exception {
        //1：创建本地webservice服务地址
//        URL url = new URL("http://172.25.37.9:8085/webServiceDemo?wsdl");
        //创建ace服务地址
        URL url = new URL("http://localhost:7800/fenliu?wsdl");
        //2：打开到服务地址的一个连接
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        //3：设置连接参数
        //3.1设置发送方式：POST必须大写
        connection.setRequestMethod("POST");
        //3.2设置数据格式：Content-type
        connection.setRequestProperty("content-type", "text/xml;charset=utf-8");
        //3.3设置输入输出，新创建的connection默认是没有读写权限的，
        connection.setDoInput(true);
        connection.setDoOutput(true);
        //4：组织SOAP协议数据，发送给服务端
//        String soapXML = getXML("z","f","q","y","n","q","v");
        String soapXML = getAceXml("z","f","1","y","n","q","v");
        OutputStream os = connection.getOutputStream();
        os.write(soapXML.getBytes());
        //5：接收服务端的响应
        int responseCode = connection.getResponseCode();
        if(200 == responseCode){//表示服务端响应成功
            InputStream is = connection.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String temp = null;
            while(null != (temp = br.readLine())){
                sb.append(temp);
            }
            //打印服务端响应
            System.out.println(sb.toString());
            is.close();
            isr.close();
            br.close();
        }
        os.close();
    }

    /**
     * 调用本地发布的webservice服务需要的xml 报文格式
     * @param
     * @return
     */
    public static String getXML(String reqSeqNo,String serviceName,String version,String consumerID,String providerID,String sign,String input1){
        String soapXML="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:bean=\"http://service.cnbg.com/sample/sample/bean\" xmlns:head=\"http://service.cnbg.com/common/head\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <bean:SampleRequest>\n" +
                "         <bean:requestHead>\n" +
                "            <head:reqSeqNo>"+reqSeqNo+"</head:reqSeqNo>\n" +
                "            <head:serviceName>"+serviceName+"</head:serviceName>\n" +
                "            <head:version>"+version+"</head:version>\n" +
                "            <head:consumerID>"+consumerID+"</head:consumerID>\n" +
                "            <head:providerID>"+providerID+"</head:providerID>\n" +
                "            <head:sign>"+sign+"</head:sign>\n" +
                "         </bean:requestHead>\n" +
                "         <bean:requestBody>\n" +
                "            <bean:input1>"+input1+"</bean:input1>\n" +
                "         </bean:requestBody>\n" +
                "      </bean:SampleRequest>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";

        return soapXML;
    }

    /**
     * 调用ACE上发布的webservice服务 需要组织的xml格式
     * @param reqSeqNo
     * @param serviceName
     * @param version
     * @param consumerID
     * @param providerID
     * @param sign
     * @param input1
     * @return
     */
    public static String getAceXml(String reqSeqNo,String serviceName,String version,String consumerID,String providerID,String sign,String input1){
        String xml="<?xml version=\"1.0\" encoding=\"UTF-8\"?><tns0:Envelope xmlns:tns0=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tns1=\"http://fenliu\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "  <tns0:Header/>\n" +
                "  <tns0:Body>\n" +
                "    <tns1:service>\n" +
                "      <reqSeqNo>"+reqSeqNo+"</reqSeqNo>\n" +
                "      <serviceName>"+serviceName+"</serviceName>\n" +
                "      <version>"+version+"</version>\n" +
                "      <consumerID>"+consumerID+"</consumerID>\n" +
                "      <providerID>"+providerID+"</providerID>\n" +
                "      <sign>"+sign+"</sign>\n" +
                "      <input1>"+input1+"</input1>\n" +
                "    </tns1:service>\n" +
                "  </tns0:Body>\n" +
                "</tns0:Envelope>";
        return xml;
    }
}
