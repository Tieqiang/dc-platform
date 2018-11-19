package com.dchealth.filter;

import com.dchealth.config.SystemProperties;
import com.dchealth.service.sys.SysUserService;
import com.dchealth.util.JwtUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    private final Logger logger = LoggerFactory.getLogger(JwtAuthorizationFilter.class);

    @Autowired
    private SystemProperties systemProperties;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //如果是MockUser用于测试的时候
        SecurityContext securityContext = (SecurityContext) request.getAttribute("org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors$SecurityContextRequestPostProcessorSupport$TestSecurityContextRepository.REPO");
        if(securityContext!=null){
            Authentication authentication = securityContext.getAuthentication();
            if (authentication.isAuthenticated()) {
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        String header = request.getHeader(systemProperties.getAuthention().getName());
        if (header != null && header.startsWith(systemProperties.getAuthention().getPrefix())) {
            String token = header.substring(systemProperties.getAuthention().getPrefix().length());
            logger.info("token信息为：" + token);

            String username = jwtUtils.getUserName(token);

            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = sysUserService.loadUserByUsername(username);
                if (jwtUtils.validToken(token, userDetails)) {
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(
                            request));
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }
            }
        }
        filterChain.doFilter(request, response);
    }
}
