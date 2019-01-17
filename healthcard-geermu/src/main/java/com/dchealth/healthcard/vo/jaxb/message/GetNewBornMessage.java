package com.dchealth.healthcard.vo.jaxb.message;

import com.dchealth.healthcard.vo.MessageInterface;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "request")
public class GetNewBornMessage implements MessageInterface {

    private String mother_name;
    private String mother_id_type ;
    private String mother_id_number ;
    private String mother_ecard_id ;
    private String father_name ;
    private String father_id_type ;
    private String father_id_number ;
    private String father_ecard_id ;

    public GetNewBornMessage() {
    }

    public String getMother_name() {
        return mother_name;
    }

    public void setMother_name(String mother_name) {
        this.mother_name = mother_name;
    }

    public String getMother_id_type() {
        return mother_id_type;
    }

    public void setMother_id_type(String mother_id_type) {
        this.mother_id_type = mother_id_type;
    }

    public String getMother_id_number() {
        return mother_id_number;
    }

    public void setMother_id_number(String mother_id_number) {
        this.mother_id_number = mother_id_number;
    }

    public String getMother_ecard_id() {
        return mother_ecard_id;
    }

    public void setMother_ecard_id(String mother_ecard_id) {
        this.mother_ecard_id = mother_ecard_id;
    }

    public String getFather_name() {
        return father_name;
    }

    public void setFather_name(String father_name) {
        this.father_name = father_name;
    }

    public String getFather_id_type() {
        return father_id_type;
    }

    public void setFather_id_type(String father_id_type) {
        this.father_id_type = father_id_type;
    }

    public String getFather_id_number() {
        return father_id_number;
    }

    public void setFather_id_number(String father_id_number) {
        this.father_id_number = father_id_number;
    }

    public String getFather_ecard_id() {
        return father_ecard_id;
    }

    public void setFather_ecard_id(String father_ecard_id) {
        this.father_ecard_id = father_ecard_id;
    }
}
