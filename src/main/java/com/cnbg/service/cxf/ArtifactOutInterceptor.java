package com.cnbg.service.cxf;

import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.io.CachedOutputStream;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * cxf拦截器可对返回值进行操作,需要在发布时候add
 */
public class ArtifactOutInterceptor extends AbstractPhaseInterceptor<Message> {

    public ArtifactOutInterceptor() {
        //这儿使用pre_stream，意思为在流关闭之前
        super(Phase.PRE_STREAM);
    }

    @Override
    public void handleMessage(Message message) throws Fault {

        try {

            OutputStream os = message.getContent(OutputStream.class);

            CachedStream cs = new CachedStream();

            message.setContent(OutputStream.class, cs);

            message.getInterceptorChain().doIntercept(message);

            CachedOutputStream csnew = (CachedOutputStream) message.getContent(OutputStream.class);
            InputStream in = csnew.getInputStream();

            String xml = IOUtils.toString(in);


            //对xml做处理
            String newxml="";
            String buchong=" xmlns:bean=\"http://service.cnbg.com/sample/sample/bean\" xmlns:head=\"http://service.cnbg.com/common/head\"> <soapenv:Header/>";
            String replace = xml.replace("ns2", "bean");
            String replace1 = replace.replace("ns3", "head");
            String replace2 = replace1.replace("soap", "soapenv");
            String replace3 = replace2.replace("xmlns:soapenv=\"http://schemas.xmlsoapenv.org/soapenv/envelope/\"",
                    "xmlns:soapenv=\"http://schemas.xmlsoapenv.org/soap/envelope/\"");
            String start = replace3.substring(0,replace3.indexOf(">"));
            String end = replace3.substring(replace3.indexOf(">")+1);
            newxml=start+buchong+end;
            //---------------------------




            //这里对xml做处理，处理完后同理，写回流中
            IOUtils.copy(new ByteArrayInputStream(newxml.getBytes()), os);

            cs.close();
            os.flush();

            message.setContent(OutputStream.class, os);


        } catch (Exception e) {
            System.out.println(e+"ERROR");
        }
    }

    private class CachedStream extends CachedOutputStream {

        public CachedStream() {

            super();

        }

        protected void doFlush() throws IOException {

            currentStream.flush();

        }

        protected void doClose() throws IOException {

        }

        protected void onWrite() throws IOException {

        }

    }

}
