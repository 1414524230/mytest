
package com.example.webserviceclient.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ResponseHeadDTO complex type�� Java �ࡣ
 *
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 *
 * <pre>
 * &lt;complexType name="ResponseHeadDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="seqNo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="reqSeqNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="respSeqNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="esbCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="esbMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="appCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="appMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseHeadDTO", propOrder = {
        "seqNo",
        "reqSeqNo",
        "respSeqNo",
        "status",
        "esbCode",
        "esbMessage",
        "appCode",
        "appMessage"
})
public class ResponseHeadDTO {

    @XmlElement(required = true)
    protected String seqNo;
    protected String reqSeqNo;
    protected String respSeqNo;
    protected int status;
    protected String esbCode;
    protected String esbMessage;
    protected String appCode;
    protected String appMessage;

    /**
     * ��ȡseqNo���Ե�ֵ��
     *
     * @return possible object is
     * {@link String }
     */
    public String getSeqNo() {
        return seqNo;
    }

    /**
     * ����seqNo���Ե�ֵ��
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSeqNo(String value) {
        this.seqNo = value;
    }

    /**
     * ��ȡreqSeqNo���Ե�ֵ��
     *
     * @return possible object is
     * {@link String }
     */
    public String getReqSeqNo() {
        return reqSeqNo;
    }

    /**
     * ����reqSeqNo���Ե�ֵ��
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setReqSeqNo(String value) {
        this.reqSeqNo = value;
    }

    /**
     * ��ȡrespSeqNo���Ե�ֵ��
     *
     * @return possible object is
     * {@link String }
     */
    public String getRespSeqNo() {
        return respSeqNo;
    }

    /**
     * ����respSeqNo���Ե�ֵ��
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setRespSeqNo(String value) {
        this.respSeqNo = value;
    }

    /**
     * ��ȡstatus���Ե�ֵ��
     */
    public int getStatus() {
        return status;
    }

    /**
     * ����status���Ե�ֵ��
     */
    public void setStatus(int value) {
        this.status = value;
    }

    /**
     * ��ȡesbCode���Ե�ֵ��
     *
     * @return possible object is
     * {@link String }
     */
    public String getEsbCode() {
        return esbCode;
    }

    /**
     * ����esbCode���Ե�ֵ��
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setEsbCode(String value) {
        this.esbCode = value;
    }

    /**
     * ��ȡesbMessage���Ե�ֵ��
     *
     * @return possible object is
     * {@link String }
     */
    public String getEsbMessage() {
        return esbMessage;
    }

    /**
     * ����esbMessage���Ե�ֵ��
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setEsbMessage(String value) {
        this.esbMessage = value;
    }

    /**
     * ��ȡappCode���Ե�ֵ��
     *
     * @return possible object is
     * {@link String }
     */
    public String getAppCode() {
        return appCode;
    }

    /**
     * ����appCode���Ե�ֵ��
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAppCode(String value) {
        this.appCode = value;
    }

    /**
     * ��ȡappMessage���Ե�ֵ��
     *
     * @return possible object is
     * {@link String }
     */
    public String getAppMessage() {
        return appMessage;
    }

    /**
     * ����appMessage���Ե�ֵ��
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAppMessage(String value) {
        this.appMessage = value;
    }

}
