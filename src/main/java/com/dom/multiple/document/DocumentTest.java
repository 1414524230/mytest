package com.dom.multiple.document;

import org.dom4j.*;
import org.junit.Test;

import java.util.List;

/**
 * 这是一个解析domcument 的java类.
 */
public class DocumentTest {

    public final String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<root>\n" +
            "\t<user editor=\"chenleixing\" date=\"1994-11-14\">\n" +
            "\t\t<name>张三</name>\n" +
            "\t\t<year>24</year>\n" +
            "\t\t<sex>男</sex>\n" +
            "\t</user>\n" +
            "\t<user editor=\"zhangxiaochao\" date=\"2015-02-15\">\n" +
            "\t\t<name>李四</name>\n" +
            "\t\t<year>24</year>\n" +
            "\t\t<sex>女</sex>\n" +
            "\t</user>\n" +
            "</root>\n";

    @Test
    public void jx() {
        try {
            Document document = DocumentHelper.parseText(xml);
            Element rootElement = document.getRootElement();

            Element name = rootElement.element("user");
            List<Attribute> attributes = name.attributes();
            for (Attribute attribute : attributes) {

                System.out.println(attribute.getValue());
            }
//            getNodes(rootElement);

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * 传入节点获取当前节点下的所有节点
     *
     * @param node
     */
    public void getNodes(Element node) {
        System.out.println("---------开始解析-----------");
        //当前节点的名称、文本内容和属性
        System.out.println("当前节点名称：" + node.getName());//当前节点名称
        System.out.println("当前节点的内容：" + node.getTextTrim());//当前节点名称
        List<Attribute> listAttr = node.attributes();//当前节点的所有属性的list
        for (Attribute attr : listAttr) {//遍历当前节点的所有属性
            String name = attr.getName();//属性名称
            String value = attr.getValue();//属性的值
            System.out.println("属性名称：" + name + "属性值：" + value);
        }
        //递归遍历当前节点所有的子节点
        List<Element> listElement = node.elements();//所有一级子节点的list
        for (Element e : listElement) {//遍历所有一级子节点
            this.getNodes(e);//递归
        }
    }
}
