package com.dchealth.healthcard.service;

import com.dchealth.healthcard.soapclient.SoapClient;
import com.dchealth.healthcard.soapclient.generate.RHCMessageServerResponse;
import com.dchealth.healthcard.vo.ActionInterface;
import com.dchealth.healthcard.vo.ResponseInterface;
import com.dchealth.healthcard.vo.jaxb.BaseResponse;
import com.dchealth.healthcard.vo.MessageInterface;
import com.dchealth.healthcard.vo.jaxb.response.TempCardApplyResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.dom4j.io.XMLResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Date;


@Service
public class RHCMessageServerService {

    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());


    @Autowired
    private SoapClient soapClient ;

    public <T extends ResponseInterface>ResponseInterface RHCMessageServer(ActionInterface action, MessageInterface message,Class<T> clazz)  {

        StringWriter actionWriter = new StringWriter();
        XMLResult actionResult = new XMLResult(actionWriter);

        StringWriter messageWriter = new StringWriter();
        XMLResult messageResult = new XMLResult(messageWriter);
        JAXB.marshal(action,actionResult);
        String actionString = actionWriter.toString();
        JAXB.marshal(message, messageResult);
        String messageString = messageWriter.toString();

        logger.info("["+new Date().getTime()+"]调用请求开始:");
        logger.info("请求消息action："+actionString);
        logger.info("发送消息message："+messageString);
        RHCMessageServerResponse response = soapClient.RHCMessageServer(actionString, messageString);
        String aReturn = response.getReturn();
        logger.info("请求返回消息："+aReturn);

        Object o1=  JAXB.unmarshal(new StreamSource(new StringReader(aReturn)), clazz);
        System.out.println(o1.toString());

        return  JAXB.unmarshal(new StreamSource(new StringReader(aReturn)), clazz);

    }


}
