//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.11 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2019.01.11 时间 09:19:35 PM CST 
//


package com.dchealth.healthcard.soapclient.generate;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.dchealth.healthcard.soapclient.generate package. 
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

    private final static QName _RHCMessageServer_QNAME = new QName("http://webservice.ehc.cdxt.com/", "RHCMessageServer");
    private final static QName _RHCMessageServerResponse_QNAME = new QName("http://webservice.ehc.cdxt.com/", "RHCMessageServerResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.dchealth.healthcard.soapclient.generate
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RHCMessageServer }
     * 
     */
    public RHCMessageServer createRHCMessageServer() {
        return new RHCMessageServer();
    }

    /**
     * Create an instance of {@link RHCMessageServerResponse }
     * 
     */
    public RHCMessageServerResponse createRHCMessageServerResponse() {
        return new RHCMessageServerResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RHCMessageServer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.ehc.cdxt.com/", name = "RHCMessageServer")
    public JAXBElement<RHCMessageServer> createRHCMessageServer(RHCMessageServer value) {
        return new JAXBElement<RHCMessageServer>(_RHCMessageServer_QNAME, RHCMessageServer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RHCMessageServerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.ehc.cdxt.com/", name = "RHCMessageServerResponse")
    public JAXBElement<RHCMessageServerResponse> createRHCMessageServerResponse(RHCMessageServerResponse value) {
        return new JAXBElement<RHCMessageServerResponse>(_RHCMessageServerResponse_QNAME, RHCMessageServerResponse.class, null, value);
    }

}
