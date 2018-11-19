package com.dchealth.controller;

import com.dchealth.annotation.PriOperation;
import com.dchealth.annotation.PriResource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@PriResource(resourceName = "测试资源",resourceCode = "test")
public class TestController {

    @GetMapping(path = {"/api/hello","api/hello1"},produces = "application/json")
    @PriOperation(operationName = "打招呼",operationCode = "hello")
    @PreAuthorize("hasPermission('test','hello')")
    public String hello(){
        return "hello";
    }

}
