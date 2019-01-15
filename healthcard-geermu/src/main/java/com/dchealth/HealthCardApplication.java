package com.dchealth;

import com.dchealth.config.SystemProperties;
import com.dchealth.healthcard.service.RHCMessageServerService;
import com.dchealth.healthcard.vo.*;
import com.dchealth.healthcard.vo.jaxb.ActionObject;
import com.dchealth.healthcard.vo.jaxb.BaseResponse;
import com.dchealth.healthcard.vo.jaxb.message.CardRegistMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
    private RHCMessageServerService rhcMessageServerService;

    @PostMapping(path="/api/ws",produces = "application/json")
    @ResponseBody
    public BaseResponse helloSoap() throws Exception {

        BaseResponse responseInterface = rhcMessageServerService.RHCMessageServer(new ActionObject(BussinessCode.CARD_REGIST), new CardRegistMessage());
//        return (PersonInfo) responseInterface.getTObject(new PersonInfo());
        return responseInterface;
    }

}
