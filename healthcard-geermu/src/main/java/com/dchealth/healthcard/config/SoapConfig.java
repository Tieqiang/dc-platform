package com.dchealth.healthcard.config;

import com.dchealth.healthcard.soapclient.SoapClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.webservices.client.WebServiceTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.cbor.MappingJackson2CborHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
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
        marshaller.setPackagesToScan("com.dchealth.healthcard.soapclient.generate");

//        marshaller.setContextPath();
        return marshaller;
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2CborHttpMessageConverter(){
        return new MappingJackson2HttpMessageConverter();
    }

    @Bean
    public WebServiceTemplateBuilder webServiceTemplateBuilder(Jaxb2Marshaller marshaller) {

        WebServiceTemplateBuilder builder = new WebServiceTemplateBuilder();
        builder.setDefaultUri(properties.getDefaultUri());
        builder.setMarshaller(marshaller);
        builder.setUnmarshaller(marshaller);
        return builder;
    }

//    @Bean(name = "xmlMapper")
//    public ObjectMapper xmlObjectMapper(){
//        return new XmlMapper();
//    }

    @Bean
    public SoapClient soapClient(Jaxb2Marshaller marshaller, WebServiceTemplateBuilder builder) {
        SoapClient client = new SoapClient(builder);
        client.setDefaultUri(properties.getDefaultUri());
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
