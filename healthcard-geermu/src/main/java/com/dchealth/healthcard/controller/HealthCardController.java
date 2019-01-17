package com.dchealth.healthcard.controller;

import com.dchealth.healthcard.service.RHCMessageServerService;
import com.dchealth.healthcard.vo.BussinessCode;
import com.dchealth.healthcard.vo.ResponseInterface;
import com.dchealth.healthcard.vo.jaxb.ActionObject;
import com.dchealth.healthcard.vo.jaxb.message.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/api/geermu")
public class HealthCardController {
    @Autowired
    private RHCMessageServerService rhcMessageServerService;

    @PostMapping(path = "card-regist", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseInterface healthCard(@RequestBody CardRegistMessage message) {
        return rhcMessageServerService.RHCMessageServer(new ActionObject(BussinessCode.CARD_REGIST), message);
    }


    @PostMapping(path = "card-binding-for-family", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseInterface cardBindingForFamilyMessage(@RequestBody CardBindingForFamilyMessage message) {
        return rhcMessageServerService.RHCMessageServer(new ActionObject(BussinessCode.CARD_BINDING_FOR_FAMILY), message);
    }


    @PostMapping(path = "card-family-search", produces = "application/json", consumes = "application/json")
    @ResponseBody
    public ResponseInterface cardFamilySearchMessage(@RequestBody CardFamilySearchMessage message) {
        return rhcMessageServerService.RHCMessageServer(new ActionObject(BussinessCode.CARD_FAMILY_SEARCH), message);
    }


    @PostMapping(path = "card-modify", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseInterface cardModifyMessage(@RequestBody CardModifyMessage message) {
        return rhcMessageServerService.RHCMessageServer(new ActionObject(BussinessCode.CARD_MODIFY), message);
    }


    @PostMapping(path = "card-regist-confirm", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseInterface cardRegistConfirmMessage(@RequestBody CardRegistConfirmMessage message) {
        return rhcMessageServerService.RHCMessageServer(new ActionObject(BussinessCode.CARD_REGIST_CONFIRM), message);
    }


    @PostMapping(path = "card-unbinding-for-family", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseInterface cardUnbindingForFamilyMessage(@RequestBody CardUnbindingForFamilyMessage message) {
        return rhcMessageServerService.RHCMessageServer(new ActionObject(BussinessCode.CARD_UNBINDING_FOR_FAMILY), message);
    }


    @PostMapping(path = "card-unregist", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseInterface CardUnregistMessage(@RequestBody CardUnregistMessage message) {
        return rhcMessageServerService.RHCMessageServer(new ActionObject(BussinessCode.CARD_UNREGIST), message);
    }


    @PostMapping(path = "card-use-record", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseInterface CardUseRecordMessage(@RequestBody CardUseRecordMessage message) {
        return rhcMessageServerService.RHCMessageServer(new ActionObject(BussinessCode.CARD_USE_RECORD), message);
    }


    @PostMapping(path = "qcode-apply", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseInterface QcodeApplyMessage(@RequestBody QcodeApplyMessage message) {
        return rhcMessageServerService.RHCMessageServer(new ActionObject(BussinessCode.QCODE_APPLY), message);
    }


    @PostMapping(path = "qcode-check", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseInterface QcodeCheckMessage(@RequestBody QcodeCheckMessage message) {
        return rhcMessageServerService.RHCMessageServer(new ActionObject(BussinessCode.QCODE_CHECK), message);
    }


    @PostMapping(path = "qcode-search", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseInterface QcodeSearchMessage(@RequestBody QcodeSearchMessage message) {
        return rhcMessageServerService.RHCMessageServer(new ActionObject(BussinessCode.QCODE_SEARCH), message);
    }


    @PostMapping(path = "temp-card-apply", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseInterface TempCardApplyMessage(@RequestBody TempCardApplyMessage message) {
        return rhcMessageServerService.RHCMessageServer(new ActionObject(BussinessCode.TEMP_CARD_APPLY), message);
    }


    @PostMapping(path = "temp-card-check", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseInterface TempCardCheckMessage(@RequestBody TempCardCheckMessage message) {
        return rhcMessageServerService.RHCMessageServer(new ActionObject(BussinessCode.TEMP_CARD_CHECK), message);
    }


    @PostMapping(path = "temp-card-binding", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseInterface TempCardCheckBindingMessage(@RequestBody TempCardBindingMessage message) {
        return rhcMessageServerService.RHCMessageServer(new ActionObject(BussinessCode.TEMP_CARD_BINDING), message);
    }


    @PostMapping(path = "get-new-born", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseInterface getNewBornMessage(@RequestBody GetNewBornMessage message) {
        return rhcMessageServerService.RHCMessageServer(new ActionObject(BussinessCode.GET_NEWBORN), message);
    }


    @PostMapping(path = "card-regist-for-newborn", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseInterface CardRegistForNewborn(@RequestBody CardRegistForNewborn message) {
        return rhcMessageServerService.RHCMessageServer(new ActionObject(BussinessCode.CARD_REGIST_FOR_NEWBORN), message);
    }

    @PostMapping(path = "org-card-num-search", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseInterface OrgCardNumSearchMessage(@RequestBody OrgCardNumSearchMessage message) {
        return rhcMessageServerService.RHCMessageServer(new ActionObject(BussinessCode.ORG_CARD_NUM_SEARCH), message);
    }


}
