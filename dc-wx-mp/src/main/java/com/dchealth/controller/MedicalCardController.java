package com.dchealth.controller;

import com.dchealth.controller.base.BaseController;
import com.dchealth.entity.MedicalCard;
import com.dchealth.service.MedicalCardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/wx/{appId}/medical-card")
public class MedicalCardController extends BaseController<MedicalCard,String,MedicalCardService> {
    public MedicalCardController() {
        super("健康卡管理");
    }

    @GetMapping("find-by-open-id")
    public List<MedicalCard> findMedicalCardByOpenId(@RequestParam(required = true) String openId){
        return this.getService().findMedicalCardsByOpenId(openId);
    }

}
