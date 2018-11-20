package com.dchealth.handler;

import com.dchealth.vo.SimpleResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class FailHandler implements AuthenticationFailureHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private ObjectMapper objectMapper ;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        logger.info("登录失败");
        logger.info(exception.getMessage());
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        SimpleResponse simpleResponse = new SimpleResponse();
        response.setContentType("application/json");
        simpleResponse.setCode("-1");
        simpleResponse.setDescription(exception.getMessage());
        response.getWriter().write(objectMapper.writeValueAsString(simpleResponse));

    }
}
