package com.dchealth.healthcard.vo.jaxb.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "personinfo")
public class CardFamillySearchPersonInfo {
    private String name;//姓名|
    private String id_type;//证件类型|参照4.3  CV02_01_101
    private String id_number;//证件号码|
    private String id_card;//居民身份证号|
    private String relation;//家庭成员关系代码|参照4.3 GB_T_4761_1984
    private String ehc_card_status;//电子居民健康卡账户状态|RHC_VCARD_ZT

    public CardFamillySearchPersonInfo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId_type() {
        return id_type;
    }

    public void setId_type(String id_type) {
        this.id_type = id_type;
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getEhc_card_status() {
        return ehc_card_status;
    }

    public void setEhc_card_status(String ehc_card_status) {
        this.ehc_card_status = ehc_card_status;
    }
}
