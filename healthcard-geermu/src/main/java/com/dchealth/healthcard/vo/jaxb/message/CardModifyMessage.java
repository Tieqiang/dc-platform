package com.dchealth.healthcard.vo.jaxb.message;


import com.dchealth.healthcard.vo.MessageInterface;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "request")
public class CardModifyMessage implements MessageInterface {
    private String ecardId;//电子健康卡ID|
    private String sex;//变更性别|参照4.3.1
    private String birthday;//出生日期|yyyy-MM-dd
    private String telephone;//联系电话|
    private String address;//地址|
    private String alterNo;//外部变更流水号|
    private String alterTime;//外部变更时间|yyyy-MM-dd hh:mi:ss

    public CardModifyMessage() {
    }

    public String getEcardId() {
        return ecardId;
    }

    public void setEcardId(String ecardId) {
        this.ecardId = ecardId;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAlterNo() {
        return alterNo;
    }

    public void setAlterNo(String alterNo) {
        this.alterNo = alterNo;
    }

    public String getAlterTime() {
        return alterTime;
    }

    public void setAlterTime(String alterTime) {
        this.alterTime = alterTime;
    }
}