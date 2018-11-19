package com.dchealth.handler;

import com.dchealth.annotation.PriResource;
import com.dchealth.config.SystemProperties;
import com.dchealth.entity.SysUser;
import com.dchealth.handler.custom.CustomPermissionEvaluator;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * 自定义Object
 */
@Component
public class AuthPremissionEvaluator implements CustomPermissionEvaluator {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SystemProperties systemProperties ;

    public boolean hasPermission(Authentication authentication, Object permission) {
        return this.hasPermission(authentication, null, permission);
    }

    public boolean hasPermission(Authentication authentication,Object invokeTarget,Object targetDomainObject,Object permission){
        String name = "";

        Object principal = authentication.getPrincipal();
        if(principal instanceof User){
            if("user".equals(((User) principal).getUsername())&&"password".equals(((User) principal).getPassword())&&systemProperties.isDebug()){
                return true ;
            }
        }

        PriResource annotation = invokeTarget.getClass().getAnnotation(PriResource.class);
        String resourceCode = annotation.resourceCode();

        if(StringUtils.isEmpty(resourceCode)){
            name = invokeTarget.getClass().getName();
        }else{
            name= resourceCode;
        }

        logger.info("访问的资源类为："+name);
        String userName = ((SysUser) authentication.getPrincipal()).getUsername();
        if(StringUtils.equals(userName,systemProperties.getAuthention().getMockUser())){
            //如果是单元测试用户则直接执行
            return true ;
        }
        SysUser sysUser = null;
        Set<String> permissions = new HashSet<>();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (GrantedAuthority grantedAuthority : authorities) {
            String auths = grantedAuthority.getAuthority();
            String[] split = StringUtils.split(auths,",");
            for (String str : split) {
                permissions.add(str);
            }
        }
        if (permissions.contains(name+":"+permission)) {
            return true;
        }
        return false;
    }



    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object
            permission) {
        return false;
    }
}
