package com.dchealth.controller;

import com.dchealth.annotation.PriOperation;
import com.dchealth.annotation.PriResource;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@PriResource(resourceName = "登录控制",resourceCode = "login")
@Api(description = "登录相关")
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    private RequestCache requestCache = new HttpSessionRequestCache();

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @RequestMapping("/api/login")
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    @PriOperation(operationName = "登录操作",operationCode = "login")
    public void login(HttpServletRequest request, HttpServletResponse response ,String error) throws IOException {
        SavedRequest savedRequest = requestCache.getRequest(request, response);
        if(savedRequest!=null){
            String redirectUrl = savedRequest.getRedirectUrl();
            logger.info("跳转路径："+redirectUrl);
            redirectStrategy.sendRedirect(request,response,redirectUrl);
        }else{
            logger.info("没有授权。");
            redirectStrategy.sendRedirect(request,response,"/login.html");
        }
    }

}
