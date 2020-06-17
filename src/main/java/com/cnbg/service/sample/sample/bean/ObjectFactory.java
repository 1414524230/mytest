
package com.cnbg.service.sample.sample.bean;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import com.cnbg.service.common.head.RequestHeadDTO;
import com.cnbg.service.common.head.ResponseHeadDTO;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the com.cnbg.service.sample.sample.bean package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 *
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RequestHead_QNAME = new QName("http://service.cnbg.com/sample/sample/bean", "requestHead");
    private final static QName _RequestBody_QNAME = new QName("http://service.cnbg.com/sample/sample/bean", "requestBody");
    private final static QName _ResponseHead_QNAME = new QName("http://service.cnbg.com/sample/sample/bean", "responseHead");
    private final static QName _ResponseBody_QNAME = new QName("http://service.cnbg.com/sample/sample/bean", "responseBody");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.cnbg.service.sample.sample.bean
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SampleRequest }
     *
     */
    public SampleRequest createSampleRequest() {
        return new SampleRequest();
    }

    /**
     * Create an instance of {@link SampleRequestDTO }
     *
     */
    public SampleRequestDTO createSampleRequestDTO() {
        return new SampleRequestDTO();
    }

    /**
     * Create an instance of {@link SampleResponse }
     *
     */
    public SampleResponse createSampleResponse() {
        return new SampleResponse();
    }

    /**
     * Create an instance of {@link SampleResponseDTO }
     *
     */
    public SampleResponseDTO createSampleResponseDTO() {
        return new SampleResponseDTO();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestHeadDTO }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RequestHeadDTO }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.cnbg.com/sample/sample/bean", name = "requestHead")
    public JAXBElement<RequestHeadDTO> createRequestHead(RequestHeadDTO value) {
        return new JAXBElement<RequestHeadDTO>(_RequestHead_QNAME, RequestHeadDTO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SampleRequestDTO }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SampleRequestDTO }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.cnbg.com/sample/sample/bean", name = "requestBody")
    public JAXBElement<SampleRequestDTO> createRequestBody(SampleRequestDTO value) {
        return new JAXBElement<SampleRequestDTO>(_RequestBody_QNAME, SampleRequestDTO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResponseHeadDTO }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ResponseHeadDTO }{@code >}
     */
//    @XmlElementDecl(namespace = "http://service.cnbg.com/sample/sample/bean", name = "responseHead")
    @XmlElementDecl(namespace = "", name = "responseHead")
    public JAXBElement<ResponseHeadDTO> createResponseHead(ResponseHeadDTO value) {
        return new JAXBElement<ResponseHeadDTO>(_ResponseHead_QNAME, ResponseHeadDTO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SampleResponseDTO }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SampleResponseDTO }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "responseBody")
//    @XmlElementDecl(namespace = "http://service.cnbg.com/sample/sample/bean", name = "responseBody")
    public JAXBElement<SampleResponseDTO> createResponseBody(SampleResponseDTO value) {
        return new JAXBElement<SampleResponseDTO>(_ResponseBody_QNAME, SampleResponseDTO.class, null, value);
    }

}
