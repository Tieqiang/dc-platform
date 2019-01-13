package com.dchealth.healthcard.vo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;

@JacksonXmlRootElement(localName = "response")
public class BaseResponse<T> implements ResponseInterface {


    private String result;
    private String desc;

    private T t_objectName;

    public BaseResponse() {
    }

    public BaseResponse(T t) {
        this.t_objectName = t;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public T getT_objectName() {
        return t_objectName;
    }

    public void setT_objectName(T t_objectName) {
        this.t_objectName = t_objectName;
    }

    public <M> M getTObject(M c) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Method[] declaredMethods = c.getClass().getDeclaredMethods();
        for (Method method : declaredMethods) {
            String methodName = method.getName();
            if (methodName.startsWith("set")) {
                String paraName = methodName.substring(3);
                paraName = paraName.substring(0, 1).toLowerCase() + paraName.substring(1);
                if(this.t_objectName instanceof LinkedHashMap){
                    method.invoke(c,((LinkedHashMap) this.t_objectName).get(paraName));
                }
            }
        }
        return c ;
    }

}
