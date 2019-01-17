package com.dchealth;


import com.dchealth.healthcard.vo.MessageInterface;
import com.dchealth.healthcard.vo.jaxb.message.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@AutoConfigureMockMvc
@SpringBootTest(classes = HealthCardApplication.class)
@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class HealthCardControllerTest {


    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public MockMvc mockMvc ;

    @Test
    public void whenhealthCard() {



    }


    @Test
    public void whencardBindingForFamilyMessage() {
        System.out.println(this.performPost("card-binding-for-family",new CardBindingForFamilyMessage()));
    }


    @Test
    @WithMockUser
    public void whencardFamilySearchMessage() throws Exception {

        CardFamilySearchMessage cardFamilySearchMessage = new CardFamilySearchMessage();
        cardFamilySearchMessage.setSelf_id_number("12312312");
        cardFamilySearchMessage.setSelf_id_type("aaaa");
        String requestMessage = objectMapper.writeValueAsString(cardFamilySearchMessage);

        System.out.println(requestMessage);
        String contentAsString = this.performPost("card-family-search", cardFamilySearchMessage);
        System.out.println(contentAsString);
    }


    @Test
    public void whencardModifyMessage() throws Exception {

        CardModifyMessage cardModifyMessage = new CardModifyMessage();
        String requestMessage = objectMapper.writeValueAsString(cardModifyMessage);

        System.out.println(requestMessage);


        String contentAsString = this.performPost("card-modify", new CardModifyMessage());
        System.out.println(contentAsString);

    }

    private String performPost(String url,MessageInterface messageInterface) {
        String message = null;
        try {
            message = objectMapper.writeValueAsString(messageInterface);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        try {
            return this.mockMvc.perform(
                    post("/api/geermu/"+url).contentType(MediaType.APPLICATION_JSON_VALUE).content(message))
                    .andExpect(MockMvcResultMatchers.status().isOk())
    //                .andExpect(MockMvcResultMatchers.jsonPath("$.resultCode").value("0"))
                    .andReturn().getResponse().getContentAsString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }


    @Test
    public void whencardRegistConfirmMessage() {
        System.out.println(this.performPost("card-regist-confirm",new CardRegistConfirmMessage()));
    }



    @Test
    public void whencardUnbindingForFamilyMessage() {
        System.out.println(this.performPost("card-unbinding-for-family",new CardUnbindingForFamilyMessage()));
    }



    @Test
    public void whenCardUnregistMessage() {
        System.out.println(this.performPost("card-unregist",new CardUnregistMessage()));
    }



    @Test
    public void whenCardUseRecordMessage() {
        System.out.println(this.performPost("card-use-record",new CardUseRecordMessage()));
    }



    @Test
    public void whenQcodeApplyMessage() {
        System.out.println(this.performPost("qcode-apply",new QcodeApplyMessage()));
    }



    @Test
    public void whenQcodeCheckMessage() {
        System.out.println(this.performPost("qcode-check",new QcodeCheckMessage()));
    }



    @Test
    public void whenQcodeSearchMessage() {
        System.out.println(this.performPost("qcode-search",new QcodeSearchMessage()));
    }



    @Test
    public void whenTempCardApplyMessage() {
        System.out.println(this.performPost("temp-card-apply",new TempCardApplyMessage()));
    }



    @Test
    public void whenTempCardCheckMessage() {
        System.out.println(this.performPost("temp-card-check",new TempCardCheckMessage()));
    }
    @Test
    public void whenGetNewBornMessage() {
        System.out.println(this.performPost("get-new-born",new GetNewBornMessage()));
    }
    @Test
    public void whenCardRegistForNewbornMessage() {
        System.out.println(this.performPost("card-regist-for-newborn",new CardRegistForNewbornMessage()));
    }

    @Test
    public void whenOrgCardNumSearchMessage() {
        System.out.println(this.performPost("org-card-num-search",new OrgCardNumSearchMessage()));
    }
    @Test
    public void whenTempCardBindingMessage() {
        System.out.println(this.performPost("temp-card-binding",new TempCardBindingMessage()));
    }



}
