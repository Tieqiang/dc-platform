package com.dchealth;

import com.dchealth.healthcard.vo.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class ActionObjectTest {

    private ObjectMapper objectMapper ;

    private ObjectMapper xmlMapper ;

    @Before
    public void before(){
        this.objectMapper = new ObjectMapper();
        this.xmlMapper = new XmlMapper();
    }

    @Test
    public void whenCreateActionObject() throws JsonProcessingException {
        ActionObject actionObject = new ActionObject(BussinessCode.CARD_REGIST);
        String asString = this.objectMapper.writeValueAsString(actionObject);

        String msgGuid = actionObject.getMsgGuid();
        System.out.println(asString);
        Assert.assertEquals(32,msgGuid.length());

    }


    @Test
    public void whenActionObjectToXML() throws JsonProcessingException {
        ActionObject actionObject = new ActionObject(BussinessCode.CARD_REGIST);
        String asString = this.xmlMapper.writeValueAsString(actionObject);

        String msgGuid = actionObject.getMsgGuid();
        System.out.println(asString);
        Assert.assertEquals(32,msgGuid.length());
    }

    @Test
    public void whenCreateMessage() throws JsonProcessingException {
        CardRegistMessage cardRegistMessage = new CardRegistMessage();
        String s = this.xmlMapper.writeValueAsString(cardRegistMessage);
        System.out.println(s);
    }

    @Test
    public void writeResponse() throws JsonProcessingException {
        PersonInfo personInfo = new PersonInfo();
        personInfo.setAddress("123123123");
        BaseResponse<PersonInfo> baseResponse = new BaseResponse<>(personInfo);
        JacksonXmlRootElement annotation = PersonInfo.class.getAnnotation(JacksonXmlRootElement.class);
        String s1 = annotation.localName();
        System.out.println(s1);
        String s = this.xmlMapper.writeValueAsString(baseResponse);
        s=s.replace("t_objectName",s1);
        System.out.println(s);
    }

    @Test
    public void readVaueTest() throws IOException, InstantiationException, IllegalAccessException, InvocationTargetException {

        String personInfo="<response><result/><desc/><t_objectName><name/><main_index/><ecardId/><telephone/><id_number/><id_type/><id_card/><nation/><sex/><birthday/><address>123123123</address><ech_card_status/></t_objectName></response>\n";
        BaseResponse baseResponse1 = xmlMapper.readValue(personInfo, BaseResponse.class);

        PersonInfo tObject = (PersonInfo) baseResponse1.getTObject(new PersonInfo());
        System.out.println(tObject.getAddress());

    }

}
