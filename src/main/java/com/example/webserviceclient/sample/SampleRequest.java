
package com.example.webserviceclient.sample;


import com.example.webserviceclient.common.RequestHeadDTO;

import javax.xml.bind.annotation.*;


/**
 * <p>anonymous complex type�� Java �ࡣ
 *
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
 */
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
     * ��ȡrequestHead���Ե�ֵ��
     *
     * @return possible object is
     * {@link RequestHeadDTO }
     */
    public RequestHeadDTO getRequestHead() {
        return requestHead;
    }

    /**
     * ����requestHead���Ե�ֵ��
     *
     * @param value allowed object is
     *              {@link RequestHeadDTO }
     */
    public void setRequestHead(RequestHeadDTO value) {
        this.requestHead = value;
    }

    /**
     * ��ȡrequestBody���Ե�ֵ��
     *
     * @return possible object is
     * {@link SampleRequestDTO }
     */
    public SampleRequestDTO getRequestBody() {
        return requestBody;
    }

    /**
     * ����requestBody���Ե�ֵ��
     *
     * @param value allowed object is
     *              {@link SampleRequestDTO }
     */
    public void setRequestBody(SampleRequestDTO value) {
        this.requestBody = value;
    }

}
