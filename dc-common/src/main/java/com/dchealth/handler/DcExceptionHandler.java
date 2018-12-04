package com.dchealth.handler;

import com.dchealth.exception.DcException;
import com.dchealth.vo.SimpleResponse;
import io.jsonwebtoken.ExpiredJwtException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class DcExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value=Exception.class)
    public SimpleResponse exceptionHandle(Exception ex) {
        SimpleResponse simpleResponse = this.sendResponse("-9", ex, "");
        return simpleResponse;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value=DcException.class)
    public SimpleResponse exceptionPlatException(DcException ex){
        SimpleResponse simpleResponse = this.sendResponse("-1", ex, "");
        return simpleResponse;
    }

    /**
     * 访问被拒绝的
     * @param ex
     * @return
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value=AccessDeniedException.class)
    public SimpleResponse accessDeniedException(AccessDeniedException ex){
        return this.sendResponse("403",ex,"没有权限访问接口，访问被拒绝");
    }

    /**
     * token失效
     * @param ex
     * @return
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value=ExpiredJwtException.class)
    public SimpleResponse expiredJwtException(ExpiredJwtException ex){
        return this.sendResponse("403",ex,"令牌已过期");
    }


    public SimpleResponse sendResponse(String code,Exception ex,String message){
        SimpleResponse response = new SimpleResponse();
        response.setCode(code);
        if(StringUtils.isNotEmpty(message)){
            response.setDescription(message);
        }else{
            response.setDescription( this.getExceptionMessage(ex));
        }

        return response;
    }

    private String getExceptionMessage(Throwable ex) {
        if (ex == null) {
            return "获取异常信息失败！";
        }
        if (StringUtils.isNotEmpty(ex.getMessage())) {
            return ex.getMessage();
        } else {
            return this.getExceptionMessage(ex.getCause());
        }
    }
}
