package com.dchealth.entity;

import com.dchealth.handler.SysGrantedAuthority;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "user",schema = "")
public class SysUser extends BaseEntity implements UserDetails {


    @Column(unique = true)
    private String username ;
    @Column
    private String password ;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.MERGE},fetch = FetchType.EAGER)
    @JoinTable(name="role_vs_user",joinColumns = @JoinColumn(name="user_id",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id"))
    @Lazy(value = false)
    private List<Role> roles;


    @Column(columnDefinition = "tinyint default 1")
    private boolean accountNonExpired=true;

    @Column(columnDefinition = "tinyint default 1")
    private boolean accountNonLocked =true;
    @Column(columnDefinition = "tinyint default 1")
    private boolean credentialsNonExpired=true ;
    @Column(columnDefinition = "tinyint default 1")
    private boolean enabled =true;


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        SysGrantedAuthority sysGrantedAuthority = new SysGrantedAuthority(this.username);
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(sysGrantedAuthority);
        return grantedAuthorities;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUsername() {
        return this.username;
    }




    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
