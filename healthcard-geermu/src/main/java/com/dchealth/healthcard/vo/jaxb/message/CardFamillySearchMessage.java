package com.dchealth.healthcard.vo.jaxb.message;

import com.dchealth.healthcard.vo.MessageInterface;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "request")
public class CardFamillySearchMessage implements MessageInterface {
    private String self_id_type;//本人证件类型|
    private String self_id_number;//本人证件号码|

    public CardFamillySearchMessage() {
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
}