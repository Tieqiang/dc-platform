package com.dchealth.handler;

import com.dchealth.entity.Resource;
import com.dchealth.entity.Role;
import com.dchealth.entity.SysUser;
import com.dchealth.service.sys.SysUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.List;

public class SysGrantedAuthority implements GrantedAuthority {

    private SysUserService sysUserService;

    private String username;


    public SysGrantedAuthority(String username) {
        this.username = username;
        ApplicationContext applicationContext = ApplicationContextHandler.APPLICATION_CONTEXT;
        this.sysUserService = (SysUserService) applicationContext.getBean("sysUserService");
    }




    @Override
    public String getAuthority() {
        List<String> authorities=new ArrayList<>();
        if(StringUtils.isNotEmpty(username)){
            SysUser sysUser = sysUserService.loadUserByUsername(username);
            List<Role> roles = sysUser.getRoles();
            for(Role role:roles){
                List<Resource> resources = role.getResources();
                for(Resource resource:resources){
                    authorities.add(resource.getOperationCode());
                }
            }

        }
        return StringUtils.join(authorities,",") ;
    }


}
