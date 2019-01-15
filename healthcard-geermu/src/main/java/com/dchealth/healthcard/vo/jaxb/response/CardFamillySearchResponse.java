package com.dchealth.healthcard.vo.jaxb.response;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "response")
public class CardFamillySearchResponse {
    private String resultCode;
    private String result;
    private String desc;
    private int total;//家庭成员总数|

    private List<CardFamillySearchPersonInfo> entitys ;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<CardFamillySearchPersonInfo> getEntitys() {
        return entitys;
    }

    public void setEntitys(List<CardFamillySearchPersonInfo> entitys) {
        this.entitys = entitys;
    }
}