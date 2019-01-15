package com.dchealth.healthcard.vo.jaxb.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ehc_cardinfo")
public class QcodeCheckResponse {
    private String qr_codetext;//二维码内容|二维码明文静态格式为《电子居民健康卡ID:二维类型》动态态格式为《电子居民健康卡ID:二维类型:有效时间》
    private String name;//居民姓名|
    private String main_index;//居民主索引号|即健康档案号
    private String ecardId;//电子健康卡ID|电子健康卡ID明文
    private String telephone;//联系电话|
    private String id_number;//证件号码|
    private String id_type;//证件类型|参照4.3 CV02_01_101
    private String id_card;//居民身份证号|
    private String nation;//民族|参照4.3 GB_T_3304_1991
    private String sex;//性别|参照4.3 GB_T_2261_1_2003
    private String birthday;//出生日期|格式yyyyMMdd  如：19900917
    private String address;//户籍地址|
    private String cellphone;//手机号码|
    private String unit;//工作单位|

    public QcodeCheckResponse() {
    }

    public String getQr_codetext() {
        return qr_codetext;
    }

    public void setQr_codetext(String qr_codetext) {
        this.qr_codetext = qr_codetext;
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

    public String getEcardId() {
        return ecardId;
    }

    public void setEcardId(String ecardId) {
        this.ecardId = ecardId;
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

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}