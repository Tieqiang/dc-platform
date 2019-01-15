package com.dchealth.healthcard.vo.jaxb.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
public class TempCardApplyResponse {
    private String result;//返回值|成功与否 success成功 failure失败
    private String desc;//返回描述|返回消息描述，当发生错误或者警告时，该字段存放错误消息。如：注册XXXX服务成功或失败
    private String resultCode;//返回码|该返回码唯一区别一条返回消息，参考4.3.12
    private String qr_code;//二维码内容|
    private String qr_code_imgtext;//二维码图片编码|二维码图片base64位编码，可以解码成图片 ,图片大小像素200*200

    public TempCardApplyResponse() {
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getQr_code() {
        return qr_code;
    }

    public void setQr_code(String qr_code) {
        this.qr_code = qr_code;
    }

    public String getQr_code_imgtext() {
        return qr_code_imgtext;
    }

    public void setQr_code_imgtext(String qr_code_imgtext) {
        this.qr_code_imgtext = qr_code_imgtext;
    }
}