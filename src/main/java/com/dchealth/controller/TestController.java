package com.dchealth.controller;

import com.dchealth.annotation.PriOperation;
import com.dchealth.annotation.PriResource;
import com.dchealth.util.EncryptUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;


@RestController
@PriResource(resourceName = "测试资源",resourceCode = "test")
public class TestController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    private final String TOKEN = "sf123321";//微信公众平台中自定义的token

    @GetMapping(path = {"/api/hello","api/hello1"},produces = "application/json")
    @PriOperation(operationName = "打招呼",operationCode = "hello")
    @PreAuthorize("hasPermission('test','hello')")
    public String hello(){
        return "hello";
    }

    @GetMapping(path = {"/api/wx"}, produces = "application/json")
    @PriOperation(operationName = "微信连接测试", operationCode = "wx")
    @PreAuthorize("hasPermission('test','wx')")
    public String wxConnectTest(@RequestParam("signature") String signature,
                                @RequestParam("timestamp") String timestamp,
                                @RequestParam("nonce") String nonce,
                                @RequestParam("echostr") String echostr) {
        logger.info("signature:" + signature);
        logger.info("timestamp:" + timestamp);
        logger.info("nonce:" + nonce);
        logger.info("echostr:" + echostr);
        if (checkSignature(signature, timestamp, nonce)){
            return echostr;
        }
        return "";
    }

    private boolean checkSignature(String signature, String timestamp, String nonce){
        String [] arr = {TOKEN, timestamp, nonce};
        Arrays.sort(arr);
        StringBuffer sbf = new StringBuffer();
        for (String str : arr){
            sbf.append(str);
        }
        String getSignature = EncryptUtil.getSha1(sbf.toString());
        return signature.equals(getSignature);
    }



}
