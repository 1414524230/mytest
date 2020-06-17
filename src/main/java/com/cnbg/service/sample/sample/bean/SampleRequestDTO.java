
package com.cnbg.service.sample.sample.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;name xmlns="http://service.cnbg.com/sample/sample/bean" xmlns:bean="http://service.cnbg.com/sample/sample/bean" xmlns:head="http://service.cnbg.com/common/head" xmlns:intf="http://service.cnbg.com/sample/sample/intf" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/" xmlns:xs="http://www.w3.org/2001/XMLSchema"&gt;请求消息体&lt;/name&gt;
 * </pre>
 * 
 * 
 * <p>SampleRequestDTO complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="SampleRequestDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="input1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SampleRequestDTO", propOrder = {
    "input1"
})
public class SampleRequestDTO {

    protected String input1;

    /**
     * 获取input1属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInput1() {
        return input1;
    }

    /**
     * 设置input1属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInput1(String value) {
        this.input1 = value;
    }

}
