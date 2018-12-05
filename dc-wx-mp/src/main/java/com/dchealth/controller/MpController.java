package com.dchealth.controller;

import com.dchealth.service.MpUserService;
import com.dchealth.vo.WxUserInfo;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/wx/{appId}")
public class MpController {
    public MpController() {
        System.out.println("我被初始化了");
    }

    @Autowired
    private MpUserService mpUserService ;

    @PostMapping("get-user-info")
    public WxUserInfo getWxUserInfo(@RequestBody(required = false) String url,@PathVariable String appId) throws WxErrorException {
        return mpUserService.getWxUserInfo(url,appId);
    }

}
