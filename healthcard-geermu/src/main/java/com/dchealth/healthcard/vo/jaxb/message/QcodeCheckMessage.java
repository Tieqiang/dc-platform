package com.dchealth.healthcard.vo.jaxb.message;


import com.dchealth.healthcard.vo.MessageInterface;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "request")
public class QcodeCheckMessage implements MessageInterface {
    private String qr_code;//二维码密文|
    private String time;//刷卡时间|yyyy-MM-dd HH:mm:ss
    private String sam;//扫描枪终端标识号|组织机构代码+4位科室代码
    private String use_citycode;//用卡城市代码|参见4.3.6
    private String use_cityname;//用卡城市名称|参见4.3.6
    private String hospital_code;//用卡机构代码|参见4.3.5
    private String hospital_name;//用卡机构名称|参见4.3.5
    private String channel_code;//刷卡终端类型|参见4.3.7
    private String channel_name;//刷卡终端名称|参见4.3.7
    private String medstep_code;//诊疗环节代码|参见4.3.9
    private String medstep_name;//诊疗环节名称|参见4.3.9

    public QcodeCheckMessage() {
    }

    public String getQr_code() {
        return qr_code;
    }

    public void setQr_code(String qr_code) {
        this.qr_code = qr_code;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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