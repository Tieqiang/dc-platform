package com.dchealth;

import com.dchealth.healthcard.soapclient.ReqTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.util.LinkedHashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UtilsTest {

    @Test
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

}
