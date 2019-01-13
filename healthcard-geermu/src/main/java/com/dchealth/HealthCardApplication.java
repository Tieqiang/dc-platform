package com.dchealth;

import com.dchealth.config.SystemProperties;
import com.dchealth.healthcard.service.RHCMessageServerService;
import com.dchealth.healthcard.soapclient.SoapClient;
import com.dchealth.healthcard.soapclient.generate.RHCMessageServer;
import com.dchealth.healthcard.soapclient.generate.RHCMessageServerResponse;
import com.dchealth.healthcard.vo.*;
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

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

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
    private RHCMessageServerService rhcMessageServerService;

    @GetMapping("/api/ws")
    public PersonInfo helloSoap() throws IOException, IllegalAccessException, InvocationTargetException, InstantiationException {

        BaseResponse responseInterface = rhcMessageServerService.RHCMessageServer(new ActionObject(BussinessCode.CARD_REGIST), new CardRegistMessage());
        return (PersonInfo) responseInterface.getTObject(new PersonInfo());
    }

}
