package com.dchealth.healthcard.vo.jaxb.response;

import com.dchealth.healthcard.vo.jaxb.BaseResponse;
import com.dchealth.healthcard.vo.jaxb.EntitiesResponse;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
@XmlRootElement(name="response")
public class CardFamillySearchResponse extends EntitiesResponse {

    private String total;//家庭成员总数|


    public CardFamillySearchResponse() {
        super();
    }

    @XmlElement(name="total")
    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

}