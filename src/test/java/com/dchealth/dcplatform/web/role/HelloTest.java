package com.dchealth.dcplatform.web.role;

import com.dchealth.dcplatform.web.SupperTest;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


public class HelloTest extends SupperTest {

    @Autowired
    private MockMvc mockMvc;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    @WithMockUser
    public void whenGetHello() throws Exception {

        String uri = "/api/hello";
        String contentAsString = mockMvc.perform(get(uri).contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();
        Assert.assertEquals("hello",contentAsString);
        logger.info("获取返回结果："+contentAsString);

    }

}
