package com.dchealth.healthcard.vo.jaxb.response;

import com.dchealth.healthcard.vo.jaxb.BaseResponse;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class TempCardCheckResponse extends BaseResponse {

    private String name;//姓名|
    private String age;//年龄|
    private String sex;//性别|参照4.3.1
    private String clinicTime;//就诊时间|yyyy-MM-dd HH:mi:ss

    public TempCardCheckResponse() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getClinicTime() {
        return clinicTime;
    }

    public void setClinicTime(String clinicTime) {
        this.clinicTime = clinicTime;
    }
}