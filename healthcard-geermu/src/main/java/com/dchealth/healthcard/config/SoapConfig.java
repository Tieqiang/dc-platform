package com.dchealth.healthcard.config;

import com.dchealth.healthcard.soapclient.SoapClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.webservices.client.WebServiceTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
@EnableConfigurationProperties(SoapProperties.class)
public class SoapConfig {

    @Autowired
    private SoapProperties properties;

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this is the package name specified in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("com.dchealth.healthcard.soapclient.generate");
        return marshaller;
    }

    @Bean
    public WebServiceTemplateBuilder webServiceTemplateBuilder(Jaxb2Marshaller marshaller) {

        WebServiceTemplateBuilder builder = new WebServiceTemplateBuilder();
        builder.setDefaultUri(properties.getDefaultUri());
        builder.setMarshaller(marshaller);
        builder.setUnmarshaller(marshaller);
        return builder;
    }
}
