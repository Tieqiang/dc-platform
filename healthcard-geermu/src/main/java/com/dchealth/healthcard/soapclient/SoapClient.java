package com.dchealth.healthcard.soapclient;

import com.dchealth.healthcard.soapclient.generate.RHCMessageServer;
import com.dchealth.healthcard.soapclient.generate.RHCMessageServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webservices.client.WebServiceTemplateBuilder;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class SoapClient extends WebServiceGatewaySupport {
    private final WebServiceTemplate webServiceTemplate;

    @Autowired
    public SoapClient(WebServiceTemplateBuilder webServiceTemplateBuilder) {
        this.webServiceTemplate = webServiceTemplateBuilder.build();
    }

    public RHCMessageServerResponse RHCMessageServer(String action,String message){
        RHCMessageServer rhcMessageServer = new RHCMessageServer();
        rhcMessageServer.setArg0(action);
        rhcMessageServer.setArg1(message);
        String defaultUri = this.webServiceTemplate.getDefaultUri();
        System.out.println(defaultUri);
        RHCMessageServerResponse response = (RHCMessageServerResponse) getWebServiceTemplate().marshalSendAndReceive(rhcMessageServer,new SoapActionCallback(""));
        return response;
    }

}
