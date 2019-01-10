package com.dchealth.healthcard.service;

import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Service
public class SOAPConnector extends WebServiceGatewaySupport {
//    private final WebServiceTemplate webServiceTemplate;

//    @Autowired
//    public SOAPConnector(WebServiceTemplateBuilder webServiceTemplateBuilder) {
//        this.webServiceTemplate = webServiceTemplateBuilder.build();
//    }

    public Object callWebService(String url, Object request){

        return getWebServiceTemplate().marshalSendAndReceive(url, request,new SoapActionCallback("http://tempuri.org/GetServerDateTime"));
    }

}
