package com.dchealth.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="sys_resource",uniqueConstraints = {
        @UniqueConstraint(columnNames = {"resourceName","operationName","operationCode"})
})
public class Resource extends BaseEntity {


    @Column
    private String resourceName ;
    @Column
    private String operationName ;
    @Column
    private String operationCode;
    @Column
    private String sysFlag ;


    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.MERGE },mappedBy = "resources",fetch = FetchType.LAZY)
    private List<Role> roles;




    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getOperationCode() {
        return operationCode;
    }

    public void setOperationCode(String operationCode) {
        this.operationCode = operationCode;
    }

    public String getSysFlag() {
        return sysFlag;
    }

    public void setSysFlag(String sysFlag) {
        this.sysFlag = sysFlag;
    }


    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
