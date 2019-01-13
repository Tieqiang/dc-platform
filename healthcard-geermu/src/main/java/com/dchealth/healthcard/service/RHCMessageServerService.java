package com.dchealth.healthcard.service;

import com.dchealth.healthcard.soapclient.SoapClient;
import com.dchealth.healthcard.soapclient.generate.RHCMessageServerResponse;
import com.dchealth.healthcard.vo.ActionInterface;
import com.dchealth.healthcard.vo.BaseResponse;
import com.dchealth.healthcard.vo.MessageInterface;
import com.dchealth.healthcard.vo.ResponseInterface;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;


@Service
public class RHCMessageServerService {

    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    @Qualifier(value = "xmlMapper")
    private ObjectMapper objectMapper ;

    @Autowired
    private SoapClient soapClient ;

    public BaseResponse RHCMessageServer(ActionInterface action, MessageInterface message) throws IOException {
        String actionString = objectMapper.writeValueAsString(action);
        String messageString = objectMapper.writeValueAsString(message);
        logger.info("["+new Date().getTime()+"]调用请求开始:");
        logger.info("请求消息action："+actionString);
        logger.info("发送消息message："+messageString);
        RHCMessageServerResponse response = soapClient.RHCMessageServer(actionString, messageString);
        String aReturn = response.getReturn();
        logger.info("请求返回消息："+aReturn);
        return objectMapper.readValue(aReturn,BaseResponse.class);

    }


}
