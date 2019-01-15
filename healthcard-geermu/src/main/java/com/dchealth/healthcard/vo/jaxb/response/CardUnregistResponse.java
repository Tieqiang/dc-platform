package com.dchealth.healthcard.vo.jaxb.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
public class CardUnregistResponse {
    private String result;//返回值|成功与否 success成功 failure失败
    private String desc;//返回描述|返回消息描述，当发生错误或者警告时，该字段存放错误消息。如：注册XXXX服务成功或失败
    private String resultCode;//返回码|该返回码唯一区别一条返回消息，参考4.3.12

    public CardUnregistResponse() {
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
}