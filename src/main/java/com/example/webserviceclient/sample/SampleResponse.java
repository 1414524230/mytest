
package com.example.webserviceclient.sample;


import com.example.webserviceclient.common.ResponseHeadDTO;

import javax.xml.bind.annotation.*;


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
 *         &lt;element ref="{http://service.cnbg.com/sample/sample/bean}responseHead"/&gt;
 *         &lt;element ref="{http://service.cnbg.com/sample/sample/bean}responseBody" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "responseHead",
    "responseBody"
})
@XmlRootElement(name = "SampleResponse")
public class SampleResponse {

    @XmlElement(required = true)
    protected ResponseHeadDTO responseHead;
    protected SampleResponseDTO responseBody;

    /**
     * 获取responseHead属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ResponseHeadDTO }
     *     
     */
    public ResponseHeadDTO getResponseHead() {
        return responseHead;
    }

    /**
     * 设置responseHead属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseHeadDTO }
     *     
     */
    public void setResponseHead(ResponseHeadDTO value) {
        this.responseHead = value;
    }

    /**
     * 获取responseBody属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SampleResponseDTO }
     *     
     */
    public SampleResponseDTO getResponseBody() {
        return responseBody;
    }

    /**
     * 设置responseBody属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SampleResponseDTO }
     *     
     */
    public void setResponseBody(SampleResponseDTO value) {
        this.responseBody = value;
    }

}
