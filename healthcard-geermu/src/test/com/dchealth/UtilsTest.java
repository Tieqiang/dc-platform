package com.dchealth;

import com.dchealth.healthcard.soapclient.ReqTest;
import com.dchealth.healthcard.vo.MessageInterface;
import com.dchealth.healthcard.vo.jaxb.message.CardRegistMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

public class UtilsTest {

    private ObjectMapper objectMapper=new ObjectMapper();


    public void contextLoads() throws Exception {
        ReqTest request = new ReqTest();
        Map<String, String> condition = new LinkedHashMap<>();
        for (int i=0; i<5; i++) {
            request.put("key_" + i, "value_" + i);
        }
//        request.setCondition(condition);

        JAXBContext jaxbContext = JAXBContext.newInstance(ReqTest.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(request, System.out);
    }

    public void generateMessage(MessageInterface message) {

    }


    @Test
    public void messageTest() throws IllegalAccessException, JsonProcessingException, InstantiationException, InvocationTargetException {
        System.out.println(this.getJsonString(CardRegistMessage.class));
    }

    public String getJsonString(Class c) throws IllegalAccessException, InstantiationException, JsonProcessingException, InvocationTargetException {
        Object o = c.newInstance();

        Method[] declaredMethods = c.getDeclaredMethods();

        for (Method method:declaredMethods){
            String name = method.getName();
            if(name.startsWith("set")){
                method.invoke(o,name.substring(3));
            }
        }
//        for(Field field:fields){
//            field.set(o,field.getName());
//        }

        return objectMapper.writeValueAsString(o);
    }


}
