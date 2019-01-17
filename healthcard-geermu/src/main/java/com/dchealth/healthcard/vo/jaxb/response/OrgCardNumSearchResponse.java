package com.dchealth.healthcard.vo.jaxb.response;

import com.dchealth.healthcard.vo.jaxb.BaseResponse;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class OrgCardNumSearchResponse extends BaseResponse {

    private String count ;

    public OrgCardNumSearchResponse() {
        super();
    }
    @XmlElement(name="count")
    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
