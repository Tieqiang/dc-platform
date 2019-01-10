package com.dchealth.healthcard.soapclient;

import com.dchealth.healthcard.soapclient.generate.HelloWorld;
import com.dchealth.healthcard.soapclient.generate.HelloWorldResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webservices.client.WebServiceTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class SoapClient extends WebServiceGatewaySupport {
    private final WebServiceTemplate webServiceTemplate;

    @Autowired
    public SoapClient(WebServiceTemplateBuilder webServiceTemplateBuilder) {
        this.webServiceTemplate = webServiceTemplateBuilder.build();
    }

    public String HelloWorld() {
        HelloWorld request = new HelloWorld();
        HelloWorldResponse response = (HelloWorldResponse)getWebServiceTemplate().marshalSendAndReceive( request,new SoapActionCallback("http://tempuri.org/HelloWorld"));
        return response.getHelloWorldResult().toString();
    }
}
