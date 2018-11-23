package com.dchealth.handler;

import com.dchealth.exception.DcException;
import com.dchealth.exception.framework.NullResourceException;
import com.dchealth.vo.SimpleResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class DcExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value=Exception.class)
    public SimpleResponse exceptionHandle(Exception ex) {
        SimpleResponse response = new SimpleResponse();
        Map<String, String> map = new HashMap<>();
        if (ex instanceof DcException) {
            logger.error("平台异常！", ex);
            response.setCode("-1");
            response.setDescription(ex.getMessage());
        } else {
            logger.error("系统异常！",ex);
            response.setCode("-9");
            response.setDescription(this.getExceptionMessage(ex));
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
