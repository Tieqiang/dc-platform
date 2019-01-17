package com.dchealth.healthcard.vo.jaxb.message;

import com.dchealth.healthcard.vo.MessageInterface;

import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name = "request")
public class TempCardBindingMessage implements MessageInterface {

    private String qr_code ;//正式卡二维码内容
    private String qr_code_temp;//临时卡二维码内容
    private String name ;//居民姓名
    private String id_type ;//证件类型
    private String id_number ;//证件号码
    private String sex ;//性别

    public TempCardBindingMessage() {
    }

    public String getQr_code() {
        return qr_code;
    }

    public void setQr_code(String qr_code) {
        this.qr_code = qr_code;
    }

    public String getQr_code_temp() {
        return qr_code_temp;
    }

    public void setQr_code_temp(String qr_code_temp) {
        this.qr_code_temp = qr_code_temp;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
