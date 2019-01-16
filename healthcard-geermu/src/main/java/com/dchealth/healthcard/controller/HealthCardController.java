package com.dchealth.healthcard.controller;

import com.dchealth.healthcard.service.RHCMessageServerService;
import com.dchealth.healthcard.vo.BussinessCode;
import com.dchealth.healthcard.vo.ResponseInterface;
import com.dchealth.healthcard.vo.jaxb.ActionObject;
import com.dchealth.healthcard.vo.jaxb.message.CardRegistMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
@RequestMapping(path="/api/geermu")
public class HealthCardController {
    @Autowired
    private RHCMessageServerService rhcMessageServerService;

    @PostMapping(path="health-card",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseInterface healthCard(@RequestBody CardRegistMessage message) {
        return rhcMessageServerService.RHCMessageServer(new ActionObject(BussinessCode.CARD_REGIST), message);
    }
}
