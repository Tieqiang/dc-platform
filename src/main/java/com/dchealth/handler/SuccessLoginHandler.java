package com.dchealth.handler;

import com.dchealth.config.SystemProperties;
import com.dchealth.entity.SysUser;
import com.dchealth.util.JwtUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;

@Component
public class SuccessLoginHandler implements AuthenticationSuccessHandler {

    private final Logger logger = LoggerFactory.getLogger(SuccessLoginHandler.class);


    @Autowired
    private SystemProperties systemProperties;

    @Autowired
    private JwtUtils jwtUtils ;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        logger.info("登录成功。。。。");
        SysUser sysUser = (SysUser) authentication.getPrincipal();
        Iterator<? extends GrantedAuthority> iterator = sysUser.getAuthorities().iterator();
        if(iterator.hasNext()){
            GrantedAuthority grantedAuthority = iterator.next();
            logger.info("拥有的权限："+grantedAuthority.getAuthority());
        }
        String token = jwtUtils.createToken(sysUser);
        logger.info("认证成功。获取认证信息："+sysUser+";并生成token="+token);
        response.setContentType("text/plain");
        response.getWriter().write(token);
        response.setHeader(systemProperties.getAuthention().getName(),systemProperties.getAuthention().getPrefix()+token);

    }
}
