package com.dchealth.dcplatform.web.user;

import com.dchealth.dcplatform.web.SupperTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserTest extends SupperTest {

    @Autowired
    public MockMvc mockMvc ;

    private String BASE_URL="/api/user";

    @Test
    @WithMockUser
    public void whenGetSysUsersByRoleId() throws Exception {
        String contentAsString = mockMvc.perform(get(this.BASE_URL + "/user-by-role-id?roleId=1")).andExpect(status().is5xxServerError()).andReturn().getResponse()
                .getContentAsString();
        System.out.println(contentAsString);
    }

}
