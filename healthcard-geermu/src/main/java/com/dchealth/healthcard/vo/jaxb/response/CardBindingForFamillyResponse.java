package com.dchealth.healthcard.vo.jaxb.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "personinfo")
public class CardBindingForFamillyResponse {
    private String name;//居民姓名|
    private String main_index;//居民主索引号|即健康档案号
    private String telephone;//联系电话|
    private String id_number;//证件号码|
    private String id_type;//证件类型|参照4.3 CV02_01_101
    private String id_card;//居民身份证号|
    private String nation;//民族|参照4.3 GB_T_3304_1991
    private String sex;//性别|参照4.3 GB_T_2261_1_2003
    private String birthday;//出生日期|格式yyyyMMdd 如：19900917
    private String address;//户籍地址|
    private String ehc_card_status;//电子居民健康卡账户状态|参照4.3 RHC_VCARD_ZT

    public CardBindingForFamillyResponse() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMain_index() {
        return main_index;
    }

    public void setMain_index(String main_index) {
        this.main_index = main_index;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    public String getId_type() {
        return id_type;
    }

    public void setId_type(String id_type) {
        this.id_type = id_type;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEhc_card_status() {
        return ehc_card_status;
    }

    public void setEhc_card_status(String ehc_card_status) {
        this.ehc_card_status = ehc_card_status;
    }
}