package com.dchealth;

import com.dchealth.healthcard.vo.*;
import com.dchealth.healthcard.vo.jaxb.ActionObject;
import com.dchealth.healthcard.vo.jaxb.BaseResponse;
import com.dchealth.healthcard.vo.jaxb.message.CardRegistMessage;
import com.dchealth.healthcard.vo.jaxb.response.PersonInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class ActionObjectTest {

    private ObjectMapper objectMapper;

    private ObjectMapper xmlMapper;



    @Test
    public void whenCreateActionObject() throws JsonProcessingException {
        ActionObject actionObject = new ActionObject(BussinessCode.CARD_REGIST);
        String asString = this.objectMapper.writeValueAsString(actionObject);

        String msgGuid = actionObject.getMsgGuid();
        System.out.println(asString);
        Assert.assertEquals(32, msgGuid.length());

    }


    @Test
    public void whenActionObjectToXML() throws JsonProcessingException {
        ActionObject actionObject = new ActionObject(BussinessCode.CARD_REGIST);
        String asString = this.xmlMapper.writeValueAsString(actionObject);

        String msgGuid = actionObject.getMsgGuid();
        System.out.println(asString);
        Assert.assertEquals(32, msgGuid.length());
    }

    @Test
    public void whenCreateMessage() throws JsonProcessingException {
        CardRegistMessage cardRegistMessage = new CardRegistMessage();
        String s = this.xmlMapper.writeValueAsString(cardRegistMessage);
        System.out.println(s);
    }

    @Test
    public void writeResponse() throws JsonProcessingException {
//        PersonInfo personInfo = new PersonInfo();
//        personInfo.setAddress("123123123");
//        BaseResponse<PersonInfo> baseResponse = new BaseResponse<>(personInfo);
//        JacksonXmlRootElement annotation = PersonInfo.class.getAnnotation(JacksonXmlRootElement.class);
//        String s1 = annotation.localName();
//        System.out.println(s1);
//        String s = this.xmlMapper.writeValueAsString(baseResponse);
//        s = s.replace("t_objectName", s1);
//        System.out.println(s);
    }

    @Test
    public void readVaueTest() throws IOException, InstantiationException, IllegalAccessException, InvocationTargetException {

        String personInfo = "<response><result/><desc/><personinfo><name/><main_index/><ecardId/><telephone/><id_number/><id_type/><id_card/><nation/><sex/><birthday/><address>123123123</address><ech_card_status/></personinfo></response>\n";
        BaseResponse baseResponse1 = xmlMapper.readValue(personInfo, BaseResponse.class);
        System.out.println(baseResponse1);
//        PersonInfo tObject = (PersonInfo) baseResponse1.getTObject(new PersonInfo());
//        System.out.println(tObject.getAddress());

    }

    @Test
    public void writeVaueTest1() throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(BaseResponse.class, PersonInfo.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        BaseResponse res = new BaseResponse();
        PersonInfo p = new PersonInfo();
        p.setAddress("测试地址");
//        res.setResEntity(p);
        List<Object> list = new ArrayList<>();
        list.add(p);
        res.setEntities(list);
        StringWriter writer = new StringWriter();
        marshaller.marshal(res, writer);
        String xml = writer.toString();
        System.out.println(xml);


        Object res1 = unmarshaller.unmarshal(new StringReader(xml));
        System.out.println(res1);

    }

}
