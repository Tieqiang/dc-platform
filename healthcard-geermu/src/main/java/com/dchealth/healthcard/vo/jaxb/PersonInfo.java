package com.dchealth.healthcard.vo.jaxb;


import javax.xml.bind.annotation.XmlRootElement;

/**
 * 1	返回值	result	String	10	成功与否 success成功 failure失败
 2	返回描述	desc	String	100	返回消息描述，当发生错误或者警告时，该字段存放错误消息。如：注册XXXX服务成功或失败
 3	返回码	resultCode	String	5	该返回码唯一区别一条返回消息，参考4.3.12
 4	居民姓名	name	String 	32
 5	居民主索引号	main_index	String	32	即健康档案号
 6	电子健康卡ID	ecardId	String	64
 7	联系电话	telephone	String	11
 8	证件号码	id_number	String 	18
 9	证件类型	id_type	String	2	参照4.3 CV02_01_101
 10	居民身份证号	id_card	String 	18
 11	民族	nation	String	2	参照4.3 GB_T_3304_1991
 12	性别	sex	String 	1	参照4.3 GB_T_2261_1_2003
 13	出生日期	birthday	String	8	格式yyyyMMdd 如：19900917
 14	户籍地址	address	String	256
 15	电子居民健康卡账户状态	ehc_card_status	String	1	参照4.3 RHC_VCARD_ZT

 */
@XmlRootElement(name="personinfo")
public class PersonInfo {

    private String name ;
    private String main_index;
    private String ecardId ;
    private String telephone ;
    private String id_number ;
    private String id_type ;
    private String id_card ;
    private String nation ;
    private String sex ;
    private String birthday ;
    private String address ;
    private String ech_card_status ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMain_index() {
        return main_index;
    }

    public void setMain_index(String main_index) {
        this.main_index = main_index;
    }

    public String getEcardId() {
        return ecardId;
    }

    public void setEcardId(String ecardId) {
        this.ecardId = ecardId;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    public String getId_type() {
        return id_type;
    }

    public void setId_type(String id_type) {
        this.id_type = id_type;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEch_card_status() {
        return ech_card_status;
    }

    public void setEch_card_status(String ech_card_status) {
        this.ech_card_status = ech_card_status;
    }
}
