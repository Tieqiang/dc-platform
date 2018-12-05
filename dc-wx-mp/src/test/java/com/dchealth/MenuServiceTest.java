package com.dchealth;


import com.dchealth.config.WxMpConfiguration;
import me.chanjar.weixin.common.bean.menu.WxMenu;
import me.chanjar.weixin.common.bean.menu.WxMenuButton;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class MenuServiceTest {


    private String appId ;

    private WxMpService wxMpService;

    @Before
    public void init(){
        this.appId = "wx42b8bf514df86fef";
        wxMpService = WxMpConfiguration.getMpServices().get(appId);
    }

    @Test
    public void whenCreateMenu() throws WxErrorException {
        WxMenu menu = new WxMenu();
        List<WxMenuButton> userInfoButtons = new ArrayList<>();

        WxMenuButton wxMenuButton = new WxMenuButton();
        userInfoButtons.add(wxMenuButton);

        wxMenuButton.setName("用户中心");
        wxMenuButton.setType("view");
        String url=this.wxMpService.oauth2buildAuthorizationUrl("http://myweixin.tunnel.qydev.com/user","snsapi_userinfo","");
        wxMenuButton.setUrl(url);
        menu.setButtons(userInfoButtons);
        String s = this.wxMpService.getMenuService().menuCreate(menu);
        Assert.assertTrue(s.contains("OK"));
    }

}
