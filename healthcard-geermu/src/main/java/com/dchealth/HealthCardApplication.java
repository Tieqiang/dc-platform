package com.dchealth;

import com.dchealth.config.SystemProperties;
import com.dchealth.healthcard.soapclient.SoapClient;
import com.dchealth.healthcard.soapclient.generate.RHCMessageServer;
import com.dchealth.healthcard.soapclient.generate.RHCMessageServerResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@SpringBootApplication
@EnableConfigurationProperties(value = SystemProperties.class)
@EnableSwagger2
@ComponentScan("com.dchealth")
public class HealthCardApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthCardApplication.class, args);
    }

    @Autowired
    private SoapClient soapClient ;


    @GetMapping("/api/ws")
    public RHCMessageServerResponse helloSoap(){
        return soapClient.RHCMessageServer("RHC_00001","xiaoxineirong");
    }

}
