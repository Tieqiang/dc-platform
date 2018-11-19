package com.dchealth.config;

import com.dchealth.config.properties.AuthentionProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "com.dchealth")
public class SystemProperties {

    private boolean debug ;

    private AuthentionProperties authention ;

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
}
