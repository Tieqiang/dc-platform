package com.dchealth.healthcard.controller;

import com.dchealth.healthcard.service.RHCMessageServerService;
import com.dchealth.healthcard.vo.BussinessCode;
import com.dchealth.healthcard.vo.ResponseInterface;
import com.dchealth.healthcard.vo.jaxb.ActionObject;
import com.dchealth.healthcard.vo.jaxb.BaseResponse;
import com.dchealth.healthcard.vo.jaxb.EntitiesResponse;
import com.dchealth.healthcard.vo.jaxb.message.*;
import com.dchealth.healthcard.vo.jaxb.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/api/geermu")
public class HealthCardController {
    @Autowired
    private RHCMessageServerService rhcMessageServerService;

    /**
     * 3.1	电子居民健康卡注册
     * @param message
     * @return
     */
    @PostMapping(path = "card-regist", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseInterface healthCard(@RequestBody CardRegistMessage message){
        return rhcMessageServerService.RHCMessageServer(new ActionObject(BussinessCode.CARD_REGIST), message, EntitiesResponse.class);
    }

    /**
     * 3.2	申请居民电子健康卡二维码
     * @param message
     * @return
     */
    @PostMapping(path = "qcode-apply", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseInterface QcodeApplyMessage(@RequestBody QcodeApplyMessage message){
        return rhcMessageServerService.RHCMessageServer(new ActionObject(BussinessCode.QCODE_APPLY), message,EntitiesResponse.class);
    }

    /**
     * 3.3	电子居民健康卡二维码验证
     * @param message
     * @return
     */
    @PostMapping(path = "qcode-check", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseInterface QcodeCheckMessage(@RequestBody QcodeCheckMessage message){
        return rhcMessageServerService.RHCMessageServer(new ActionObject(BussinessCode.QCODE_CHECK), message,EntitiesResponse.class);
    }

    /**
     * 3.4	电子居民健康卡注销
     * @param message
     * @return
     */
    @PostMapping(path = "card-unregist", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseInterface CardUnregistMessage(@RequestBody CardUnregistMessage message){
        return rhcMessageServerService.RHCMessageServer(new ActionObject(BussinessCode.CARD_UNREGIST), message,BaseResponse.class);
    }

    /***
     * 3.5	查询电子居民健康卡二维码
     * @param message
     * @return
     */
    @PostMapping(path = "qcode-search", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseInterface QcodeSearchMessage(@RequestBody QcodeSearchMessage message){
        return rhcMessageServerService.RHCMessageServer(new ActionObject(BussinessCode.QCODE_SEARCH), message, EntitiesResponse.class);
    }


    /**
     * 3.6	电子居民健康卡注册（现场认证）
     * @param message
     * @return
     */
    @PostMapping(path = "card-regist-confirm", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseInterface cardRegistConfirmMessage(@RequestBody CardRegistConfirmMessage message){
        return rhcMessageServerService.RHCMessageServer(new ActionObject(BussinessCode.CARD_REGIST_CONFIRM), message,EntitiesResponse.class);
    }


    /**
     * 3.7	家庭成员健康卡绑定(主要针对线上，线下系统可暂不做)
     * @param message
     * @return
     */
    @PostMapping(path = "card-binding-for-family", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseInterface cardBindingForFamilyMessage(@RequestBody CardBindingForFamilyMessage message) {
        return rhcMessageServerService.RHCMessageServer(new ActionObject(BussinessCode.CARD_BINDING_FOR_FAMILY), message,EntitiesResponse.class);
    }

    /**
     * 3.8	家庭成员健康卡解除绑定（主要针对线上，线下系统可暂不做）
     * @param message
     * @return
     */
    @PostMapping(path = "card-unbinding-for-family", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseInterface cardUnbindingForFamilyMessage(@RequestBody CardUnbindingForFamilyMessage message){
        return rhcMessageServerService.RHCMessageServer(new ActionObject(BussinessCode.CARD_UNBINDING_FOR_FAMILY), message,BaseResponse.class);
    }


    /**
     * 3.9	上传用卡记录(为实体卡作准备，电子健康卡可暂不做)
     * @param message
     * @return
     */
    @PostMapping(path = "card-use-record", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseInterface CardUseRecordMessage(@RequestBody CardUseRecordMessage message){
        return rhcMessageServerService.RHCMessageServer(new ActionObject(BussinessCode.CARD_USE_RECORD), message,BaseResponse.class);
    }

    /**
     * 3.10	查询家庭成员（主要针对线上，线下系统可暂不做）
     * @param message
     * @return
     */
    @PostMapping(path = "card-family-search", produces = "application/json", consumes = "application/json")
//    @ResponseBody
    public ResponseInterface cardFamilySearchMessage(@RequestBody CardFamilySearchMessage message){
        return rhcMessageServerService.RHCMessageServer(new ActionObject(BussinessCode.CARD_FAMILY_SEARCH), message, CardFamillySearchResponse.class);
    }


    /**
     * 3.11	修改电子健康卡信息
     * @param message
     * @return
     */
    @PostMapping(path = "card-modify", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseInterface cardModifyMessage(@RequestBody CardModifyMessage message){
        return rhcMessageServerService.RHCMessageServer(new ActionObject(BussinessCode.CARD_MODIFY), message,BaseResponse.class);
    }


    /**
     * 3.12	申请临时居民健康卡
     * @param message
     * @return
     */
    @PostMapping(path = "temp-card-apply", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseInterface TempCardApplyMessage(@RequestBody TempCardApplyMessage message){
        return rhcMessageServerService.RHCMessageServer(new ActionObject(BussinessCode.TEMP_CARD_APPLY), message, TempCardApplyResponse.class);
    }

    /**
     * 3.13	验证临时居民健康卡
     * @param message
     * @return
     */
    @PostMapping(path = "temp-card-check", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseInterface TempCardCheckMessage(@RequestBody TempCardCheckMessage message){
        return rhcMessageServerService.RHCMessageServer(new ActionObject(BussinessCode.TEMP_CARD_CHECK), message, TempCardCheckResponse.class);
    }



    /**
     * 3.14 电子健康卡绑定临时卡
     * @param message
     * @return
     */
    @PostMapping(path = "temp-card-binding", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseInterface TempCardCheckBindingMessage(@RequestBody TempCardBindingMessage message){
        return rhcMessageServerService.RHCMessageServer(new ActionObject(BussinessCode.TEMP_CARD_BINDING), message,BaseResponse.class);
    }

    /**
     * 3.15 获取新生儿信息
     * @param message
     * @return
     */
    @PostMapping(path = "get-new-born", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseInterface getNewBornMessage(@RequestBody GetNewBornMessage message){
        return rhcMessageServerService.RHCMessageServer(new ActionObject(BussinessCode.GET_NEWBORN), message, NewBornResponse.class);
    }

    /**
     * 3.16 新生儿健康卡注册
     * @param message
     * @return
     */
    @PostMapping(path = "card-regist-for-newborn", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseInterface CardRegistForNewborn(@RequestBody CardRegistForNewbornMessage message){
        return rhcMessageServerService.RHCMessageServer(new ActionObject(BussinessCode.CARD_REGIST_FOR_NEWBORN), message,EntitiesResponse.class);
    }

    /**
     * 3.17 查询机构建卡数量
     * @param message
     * @return
     */
    @PostMapping(path = "org-card-num-search", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseInterface OrgCardNumSearchMessage(@RequestBody OrgCardNumSearchMessage message){
        return rhcMessageServerService.RHCMessageServer(new ActionObject(BussinessCode.ORG_CARD_NUM_SEARCH), message, OrgCardNumSearchResponse.class);
    }


}
