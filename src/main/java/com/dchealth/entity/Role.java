package com.dchealth.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sys_role")
public class Role extends BaseEntity {


    @Column
    private String roleName;

    @ManyToMany(cascade = {CascadeType.MERGE },fetch = FetchType.EAGER)
    @JoinTable(name = "role_vs_resource"
            , joinColumns = {
            @JoinColumn(name = "role_id", referencedColumnName = "id")
    }, inverseJoinColumns = @JoinColumn(name = "resource_id", referencedColumnName = "id"))
    private List<Resource> resources;


    @ManyToMany(cascade = {CascadeType.MERGE })
    @JoinTable(name = "role_vs_user", joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    private List<SysUser> users;


    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }
}
