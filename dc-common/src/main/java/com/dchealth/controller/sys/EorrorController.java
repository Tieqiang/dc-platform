package com.dchealth.controller.sys;

import com.dchealth.vo.ErrorLogger;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/error")
public class EorrorController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ObjectMapper objectMapper ;
    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping
    public void collectError(@RequestBody  ErrorLogger errorLogger) throws JsonProcessingException {
        logger.error("发生系统错误："+objectMapper.writeValueAsString(errorLogger));
    }

}
