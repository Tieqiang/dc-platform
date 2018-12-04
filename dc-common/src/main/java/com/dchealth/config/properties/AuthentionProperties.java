package com.dchealth.config.properties;

public class AuthentionProperties {

    private String name="Authorization" ;//授权名称
    private String prefix ="Bearer ";//授权的前缀

    private long expire = 60*60*24*1000;//过期时间

    private String sceret="dc-platform";

    private String mockUser="user" ;//用于测试的用户名


    public String getMockUser() {
        return mockUser;
    }

    public void setMockUser(String mockUser) {
        this.mockUser = mockUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public long getExpire() {
        return expire;
    }

    public void setExpire(long expire) {
        this.expire = expire;
    }

    public String getSceret() {
        return sceret;
    }

    public void setSceret(String sceret) {
        this.sceret = sceret;
    }
}
