package com.dchealth.dcplatform.common;

import com.dchealth.handler.ApplicationContextHandler;
import com.dchealth.service.sys.SysUserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ApplicationContextTest {


    @Test
    public void whenGetSysUserService(){
        SysUserService sysUserService = (SysUserService) ApplicationContextHandler.APPLICATION_CONTEXT.getBean("sysUserService");
        Assert.assertNotNull(sysUserService);
    }

}
