package com.dchealth.vo;

import me.chanjar.weixin.common.bean.WxJsapiSignature;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

import java.io.Serializable;


public class WxUserInfo implements Serializable {

    private WxMpUser wxMpUser ;
    private WxJsapiSignature wxJsapiSignature ;

    public WxUserInfo(WxMpUser wxMpUser, WxJsapiSignature wxJsapiSignature) {
        this.wxMpUser = wxMpUser;
        this.wxJsapiSignature = wxJsapiSignature;
    }

    public WxMpUser getWxMpUser() {
        return wxMpUser;
    }

    public void setWxMpUser(WxMpUser wxMpUser) {
        this.wxMpUser = wxMpUser;
    }

    public WxJsapiSignature getWxJsapiSignature() {
        return wxJsapiSignature;
    }

    public void setWxJsapiSignature(WxJsapiSignature wxJsapiSignature) {
        this.wxJsapiSignature = wxJsapiSignature;
    }
}
