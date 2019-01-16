package com.dchealth;


import com.dchealth.healthcard.vo.jaxb.message.CardFamilySearchMessage;
import com.dchealth.healthcard.vo.jaxb.message.CardModifyMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
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
    }


    @Test
    @WithMockUser
    public void whencardFamilySearchMessage() throws Exception {

        CardFamilySearchMessage cardFamilySearchMessage = new CardFamilySearchMessage();
        cardFamilySearchMessage.setSelf_id_number("12312312");
        cardFamilySearchMessage.setSelf_id_type("aaaa");
        String requestMessage = objectMapper.writeValueAsString(cardFamilySearchMessage);

        System.out.println(requestMessage);


        String contentAsString = this.mockMvc.perform(
                post("/api/geermu/card-family-search").contentType(MediaType.APPLICATION_JSON_VALUE).content(requestMessage))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.resultCode").value("0"))
                .andReturn().getResponse().getContentAsString();
        System.out.println(contentAsString);
    }


    @Test
    public void whencardModifyMessage() throws Exception {

        CardModifyMessage cardModifyMessage = new CardModifyMessage();
        String requestMessage = objectMapper.writeValueAsString(cardModifyMessage);

        System.out.println(requestMessage);


        String contentAsString = this.mockMvc.perform(
                post("/api/geermu/card-modify").contentType(MediaType.APPLICATION_JSON_VALUE).content(requestMessage))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.resultCode").value("0"))
                .andReturn().getResponse().getContentAsString();
        System.out.println(contentAsString);
    }


    @Test
    public void whencardRegistConfirmMessage() {
    }



    @Test
    public void whencardUnbindingForFamilyMessage() {
    }



    @Test
    public void whenCardUnregistMessage() {
    }



    @Test
    public void whenCardUseRecordMessage() {
    }



    @Test
    public void whenQcodeApplyMessage() {
    }



    @Test
    public void whenQcodeCheckMessage() {
    }



    @Test
    public void whenQcodeSearchMessage() {
    }



    @Test
    public void whenTempCardApplyMessage() {
    }



    @Test
    public void whenTempCardCheckMessage() {
    }



}
