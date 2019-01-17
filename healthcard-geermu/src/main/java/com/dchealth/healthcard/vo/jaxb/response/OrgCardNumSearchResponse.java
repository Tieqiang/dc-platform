package com.dchealth.healthcard.vo.jaxb.response;

import com.dchealth.healthcard.vo.jaxb.BaseResponse;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class OrgCardNumSearchResponse extends BaseResponse {

    private int count ;

    public OrgCardNumSearchResponse() {
        super();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
