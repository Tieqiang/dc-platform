package com.dchealth.healthcard.vo.jaxb;


import com.dchealth.healthcard.vo.ActionInterface;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;

import javax.xml.bind.annotation.XmlRootElement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.UUID;

/**
 * 访问请求的Action类
 */
@XmlRootElement(name = "request")
public class ActionObject implements ActionInterface {

    //消息标识符号
    //32位消息流水号，消息唯一标识
    private String msgGuid ;
    //消息类别
    //标识消息的类别，
    //接口平台指定固定值为：1
    private String msgType;
    //消息编号
    //消息编号为调用接口的名称，如电子健康卡注册RHC_E0001
    private String bussinessCode ;

    //消息创建时间
    //消息创建时间为调用接口的当前时间，格式为YYYY-MM-DDHH:mm:ss
    private String msgCreateTime;
    //机构ID
    //医疗卫生机构的编号，以青海省卫计委提供的机构信息中的机构ID为标准,医疗卫生机构调用时此项必须输入，与6不能同时为空，此时appCode为空;(腾讯公众号平台5,6都要传)
    private String orgId ;

    //注册在青海省卡管中心平台的APP，APP调用时此项必须输入，与5不能同时为空，此时orgId为空。
    private String appCode ;
    private String userName;
    private String userPwd ;

    private String stdVerCode ;
    //该字段传1就对居民的敏感数据进行加密，不传则不加密
    private String encryption ;


    public ActionObject() {
    }

    public ActionObject(String bussinessCode) {

        YamlPropertiesFactoryBean ymal = new YamlPropertiesFactoryBean();
        ymal.setResources(new ClassPathResource("application.yml"));
        Properties properties = ymal.getObject();
        String orgId =properties.getProperty("soap.configs.orgId");
        String userName = properties.getProperty("soap.configs.userName");
        String password = properties.getProperty("soap.configs.password");
        this.orgId = orgId ;
        this.userName = userName;
        this.userPwd = password;
        String uuid = UUID.randomUUID().toString();
        this.msgGuid =uuid.replace("-","");
        this.msgType = "1";
        DateFormat df = new SimpleDateFormat("yyyy-MM-DDHH:mm:ss");
        Date date = new Date();
        this.msgCreateTime=df.format(date);
        this.bussinessCode = bussinessCode;
    }

    public String getMsgGuid() {
        return msgGuid;
    }

    public void setMsgGuid(String msgGuid) {
        this.msgGuid = msgGuid;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getBussinessCode() {
        return bussinessCode;
    }

    public void setBussinessCode(String bussinessCode) {
        this.bussinessCode = bussinessCode;
    }

    public String getMsgCreateTime() {
        return msgCreateTime;
    }

    public void setMsgCreateTime(String msgCreateTime) {
        this.msgCreateTime = msgCreateTime;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getStdVerCode() {
        return stdVerCode;
    }

    public void setStdVerCode(String stdVerCode) {
        this.stdVerCode = stdVerCode;
    }

    public String getEncryption() {
        return encryption;
    }

    public void setEncryption(String encryption) {
        this.encryption = encryption;
    }
}
