package com.dchealth.healthcard.vo.jaxb.response;

import com.dchealth.healthcard.vo.jaxb.BaseResponse;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class NewBornResponse extends BaseResponse {


    public NewBornResponse() {
        super();
    }

    private List<PersonInfo> personinfos ;


    public List<PersonInfo> getPersoninfos() {
        return personinfos;
    }

    public void setPersoninfos(List<PersonInfo> personinfos) {
        this.personinfos = personinfos;
    }
}
