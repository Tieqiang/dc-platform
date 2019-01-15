package com.dchealth.healthcard.vo.jaxb.message;


import com.dchealth.healthcard.vo.MessageInterface;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "request")
public class CardUnbindingForFamillyMessage implements MessageInterface {
    private String self_id_type;//本人证件类型|
    private String self_id_number;//本人证件号码|
    private String id_type;//家庭成员证件类型|
    private String id_number;//家庭成员证件号码|

    public CardUnbindingForFamillyMessage() {
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
}