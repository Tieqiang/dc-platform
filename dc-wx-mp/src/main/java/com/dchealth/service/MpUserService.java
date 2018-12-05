package com.dchealth.service;

import com.dchealth.config.WxMpConfiguration;
import com.dchealth.vo.WxUserInfo;
import me.chanjar.weixin.common.bean.WxJsapiSignature;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class MpUserService {



    public WxUserInfo getWxUserInfo(String url, String appId) throws WxErrorException {
        if(StringUtils.isEmpty(url)||!url.contains("code")){
            return null ;
        }else{
            WxMpService wxMpService = WxMpConfiguration.getMpServices().get(appId);
            WxJsapiSignature jsapiSignature =
                    wxMpService.createJsapiSignature(url);
            String code= url.split("code")[1].split("=")[1].split("&")[0];
            WxMpOAuth2AccessToken accessToken=wxMpService.oauth2getAccessToken(code);
            WxMpUser wxMpUser = wxMpService.oauth2getUserInfo(accessToken, "");
            WxUserInfo wxUserInfo = new WxUserInfo(wxMpUser,jsapiSignature);
            return wxUserInfo;
        }
    }
}
