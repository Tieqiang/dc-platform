package com.dchealth;

import com.dchealth.config.SystemProperties;
import com.dchealth.healthcard.service.RHCMessageServerService;
import com.dchealth.healthcard.vo.*;
import com.dchealth.healthcard.vo.jaxb.ActionObject;
import com.dchealth.healthcard.vo.jaxb.BaseResponse;
import com.dchealth.healthcard.vo.jaxb.message.CardFamilySearchMessage;
import com.dchealth.healthcard.vo.jaxb.message.CardRegistMessage;
import com.dchealth.healthcard.vo.jaxb.message.GetNewBornMessage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping(path="/api/ws",produces = "application/json")
    @ResponseBody
    public ResponseInterface helloSoap() throws Exception {

        ResponseInterface responseInterface = rhcMessageServerService.RHCMessageServer(new ActionObject(BussinessCode.CARD_REGIST), new CardRegistMessage(),BaseResponse.class);
//        return (PersonInfo) responseInterface.getTObject(new PersonInfo());
        return responseInterface;
    }

    @GetMapping(path="/api/message/{message}",produces = "application/json")
    @ResponseBody
    public MessageInterface message(@PathVariable String message) throws Exception {
        if ("card".equalsIgnoreCase(message)) {
            return new CardRegistMessage();
        } else if ("new-born".equalsIgnoreCase(message)) {
            return new GetNewBornMessage();
        } else if ("card-family-search".equalsIgnoreCase(message)) {
            return new CardFamilySearchMessage();
        } else {
            return new CardRegistMessage();
        }
    }

}
