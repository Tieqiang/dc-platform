package com.dchealth.healthcard.vo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.Serializable;

/**
 * 居民姓名	name	String	32	Y
 联系电话	telephone	String	11	Y
 证件号码	id_number	String	18	Y
 证件类型	id_type	String	2	Y	参照4.3 CV02_01_101
 居民身份证号	id_card	String	18	Y
 民族	nation	String	2	Y	参照4.3 GB_T_3304_1991
 性别	sex	String	1	Y	参照4.3 GB_T_2261_1_2003
 出生日期	birthday	String	8	Y	格式yyyyMMdd  如：19900917
 居民身份证件照片正面	photo_front	String		Y	图片格式为png，大小在200kb以内，需要转base64字符串
 居民身份证件照片背面	photo_reverse	String		Y	图片格式为png，大小在200kb以内，需要转base64字符串
 居民本人正面头像	photo_face	String		Y	图片格式为png，大小在200kb以内，需要转base64字符串
 户籍地址	address	String	256	Y
 手机号码	cellphone	String	20
 工作单位	unit	String	100
 */
@JacksonXmlRootElement(localName = "request")
public class CardRegistMessage implements MessageInterface{

    private String name ;
    private String telephone ;
    private String id_number ;
    private String id_type ;
    private String id_card ;
    private String nation ;
    private String sex ;
    private String birthday ;
    private String photo_front;
    private String photo_reverse ;
    private String photo_face ;
    private String address ;
    private String cellphone ;
    private String unit ;

    public CardRegistMessage() {
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
