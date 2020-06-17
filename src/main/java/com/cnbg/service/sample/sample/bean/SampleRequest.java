
package com.cnbg.service.sample.sample.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.cnbg.service.common.head.RequestHeadDTO;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://service.cnbg.com/sample/sample/bean}requestHead"/&gt;
 *         &lt;element ref="{http://service.cnbg.com/sample/sample/bean}requestBody"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
//xmlaccessortype 注解是为了xml中标签的可按照变量顺序匹配
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "requestHead",
    "requestBody"
})
@XmlRootElement(name = "SampleRequest")
public class SampleRequest {

    @XmlElement(required = true)
    protected RequestHeadDTO requestHead;
    @XmlElement(required = true)
    protected SampleRequestDTO requestBody;

    /**
     * 获取requestHead属性的值。
     * 
     * @return
     *     possible object is
     *     {@link RequestHeadDTO }
     *     
     */
    public RequestHeadDTO getRequestHead() {
        return requestHead;
    }

    /**
     * 设置requestHead属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link RequestHeadDTO }
     *     
     */
    public void setRequestHead(RequestHeadDTO value) {
        this.requestHead = value;
    }

    /**
     * 获取requestBody属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SampleRequestDTO }
     *     
     */
    public SampleRequestDTO getRequestBody() {
        return requestBody;
    }

    /**
     * 设置requestBody属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SampleRequestDTO }
     *     
     */
    public void setRequestBody(SampleRequestDTO value) {
        this.requestBody = value;
    }

}
