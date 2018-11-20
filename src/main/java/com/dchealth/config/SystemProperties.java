package com.dchealth.config;

import com.dchealth.config.properties.AuthentionProperties;
import com.dchealth.config.properties.CorsProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "com.dchealth")
public class SystemProperties {

    private boolean debug=false ;

    private String exceptUrls="";

    private AuthentionProperties authention ;

    //配置跨域访问
    private CorsProperties cors ;


    public CorsProperties getCors() {
        return cors;
    }

    public void setCors(CorsProperties cors) {
        this.cors = cors;
    }

    public AuthentionProperties getAuthention() {
        return authention;
    }

    public void setAuthention(AuthentionProperties authention) {
        this.authention = authention;
    }

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public String getExceptUrls() {
        return exceptUrls;
    }

    public void setExceptUrls(String exceptUrls) {
        this.exceptUrls = exceptUrls;
    }
}
