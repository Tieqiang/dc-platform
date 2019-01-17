package com.dchealth.healthcard.vo.jaxb.response;

import com.dchealth.healthcard.vo.jaxb.BaseResponse;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
@XmlRootElement(name="response")
public class CardFamillySearchResponse extends BaseResponse{

    private int total;//家庭成员总数|


    public CardFamillySearchResponse() {
        super();
    }

    @XmlElement(name="total")
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

}