package com.dchealth.healthcard.vo.jaxb.message;


import com.dchealth.healthcard.vo.MessageInterface;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "request")
public class CardBindingForFamilyMessage implements MessageInterface {
    private String self_id_type;//本人证件类型|
    private String self_id_number;//本人证件号码|
    private String relation;//家庭成员关系代码|参照4.3 GB_T_4761_1984
    private String name;//家庭成员姓名|
    private String telephone;//家庭成员联系电话|
    private String id_number;//家庭成员证件号码|
    private String id_type;//家庭成员证件类型|参照4.3 CV02_01_101
    private String id_card;//家庭成员居民身份证号|
    private String nation;//家庭成员民族|参照4.3 GB_T_3304_1991
    private String sex;//家庭成员性别|参照4.3 GB_T_2261_1_2003
    private String birthday;//家庭成员出生日期|格式yyyyMMdd  如：19900917
    private String photo_front;//家庭成员身份证件照片正面|图片格式为png，大小在200kb以内，需要转base64字符串
    private String photo_reverse;//家庭成员身份证件照片背面|图片格式为png，大小在200kb以内，需要转base64字符串
    private String photo_face;//家庭成员本人正面头像|图片格式为png，大小在200kb以内，需要转base64字符串
    private String address;//家庭成员户籍地址|

    public CardBindingForFamilyMessage() {
    }

    public String getSelf_id_type() {
        return self_id_type;
    }

    public void setSelf_id_type(String self_id_type) {
        this.self_id_type = self_id_type;
    }

    public String getSelf_id_number() {
        return self_id_number;
    }

    public void setSelf_id_number(String self_id_number) {
        this.self_id_number = self_id_number;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPhoto_front() {
        return photo_front;
    }

    public void setPhoto_front(String photo_front) {
        this.photo_front = photo_front;
    }

    public String getPhoto_reverse() {
        return photo_reverse;
    }

    public void setPhoto_reverse(String photo_reverse) {
        this.photo_reverse = photo_reverse;
    }

    public String getPhoto_face() {
        return photo_face;
    }

    public void setPhoto_face(String photo_face) {
        this.photo_face = photo_face;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}