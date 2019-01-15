package com.dchealth.healthcard.vo.jaxb.message;


import com.dchealth.healthcard.vo.MessageInterface;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "request")
public class CardUseRecordMessage implements MessageInterface {
    private String time;//用卡时间|yyyy-MM-dd HH:mm:ss
    private String atr;//ATR卡号|复位应答（4位芯片商代码+4位卡商代码+8位卡片序列号）
    private String hc_number;//健康卡卡号|
    private String sam;//SAM卡号|组织机构代码+4位科室代码
    private String use_citycode;//用卡城市代码|参照《中华人民共和国行政区划代码》（GB T2260-2013）
    private String use_cityname;//用卡城市名称|参照《中华人民共和国行政区划代码》（GB T2260-2013）
    private String name;//姓名|
    private String sex;//性别代码|参照4.3.1性别代码
    private String nation;//民族代码|参照4.3.2民族代码
    private String birthday;//出生日期|yyyyMMdd
    private String telephone;//联系方式|
    private String id_card;//身份证号|
    private String address;//户籍所在地|
    private String hospital_code;//医疗机构代码|全国组织机构代码
    private String hospital_name;//医疗机构名称|
    private String channel_code;//刷卡终端类型编号|参照4.3.7刷卡终端类型编码表
    private String channel_name;//刷卡终端类型名称|参照4.3.7刷卡终端类型编码表
    private String medstep_code;//诊疗环节代码|参照4.3.9诊疗环节编码表
    private String medstep_name;//诊疗环节名称|参照4.3.9诊疗环节编码表

    public CardUseRecordMessage() {
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAtr() {
        return atr;
    }

    public void setAtr(String atr) {
        this.atr = atr;
    }

    public String getHc_number() {
        return hc_number;
    }

    public void setHc_number(String hc_number) {
        this.hc_number = hc_number;
    }

    public String getSam() {
        return sam;
    }

    public void setSam(String sam) {
        this.sam = sam;
    }

    public String getUse_citycode() {
        return use_citycode;
    }

    public void setUse_citycode(String use_citycode) {
        this.use_citycode = use_citycode;
    }

    public String getUse_cityname() {
        return use_cityname;
    }

    public void setUse_cityname(String use_cityname) {
        this.use_cityname = use_cityname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHospital_code() {
        return hospital_code;
    }

    public void setHospital_code(String hospital_code) {
        this.hospital_code = hospital_code;
    }

    public String getHospital_name() {
        return hospital_name;
    }

    public void setHospital_name(String hospital_name) {
        this.hospital_name = hospital_name;
    }

    public String getChannel_code() {
        return channel_code;
    }

    public void setChannel_code(String channel_code) {
        this.channel_code = channel_code;
    }

    public String getChannel_name() {
        return channel_name;
    }

    public void setChannel_name(String channel_name) {
        this.channel_name = channel_name;
    }

    public String getMedstep_code() {
        return medstep_code;
    }

    public void setMedstep_code(String medstep_code) {
        this.medstep_code = medstep_code;
    }

    public String getMedstep_name() {
        return medstep_name;
    }

    public void setMedstep_name(String medstep_name) {
        this.medstep_name = medstep_name;
    }
}