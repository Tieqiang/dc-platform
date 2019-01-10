package com.dchealth.healthcard.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "soap.configs")
public class SoapProperties {
    /**
     * webservice默认地址
     */
    private String defaultUri;

    public String getDefaultUri() {
        return defaultUri;
    }

    public void setDefaultUri(String defaultUri) {
        this.defaultUri = defaultUri;
    }
}
