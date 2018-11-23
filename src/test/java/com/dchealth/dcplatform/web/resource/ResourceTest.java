package com.dchealth.dcplatform.web.resource;

import com.dchealth.dcplatform.web.SupperTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

public class ResourceTest extends SupperTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser
    public void whenGetResourceByOperationCode() throws Exception {
        String urlTemplate = "/api/resource/find-one-by-operation-code?code=";
        String contentAsString = mockMvc.perform(get(urlTemplate)).andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();
        System.out.println(contentAsString);
    }

}
