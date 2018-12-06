package com.dchealth.normal;

import com.dchealth.entity.WxUser;
import com.dchealth.utils.ClassUtils;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

public class TestUtils {

    @Test
    public void testObjectCopy() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        WxMpUser wxMpUser = new WxMpUser();
        wxMpUser.setOpenId("abcd");
        WxUser wxUser = new WxUser();
        ClassUtils.copyProperties(wxMpUser,wxUser);
        Assert.assertEquals("abcd",wxUser.getOpenId());
    }

}
