package com.dchealth.controller;

import com.dchealth.annotation.PriOperation;
import com.dchealth.annotation.PriResource;
import com.dchealth.entity.SysUser;
import com.dchealth.service.sys.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PriResource(resourceName = "用户管理",resourceCode = "user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private SysUserService sysUserService ;


    @PriOperation(operationName = "用户注册",operationCode = "user:sign")
    @PostMapping(path = "/api/user",consumes = {"application/x-www-form-urlencoded"})
    public SysUser singup(SysUser sysUser){
        sysUser.setPassword(new BCryptPasswordEncoder().encode(sysUser.getPassword()));
        return sysUserService.merge(sysUser);
    }


    @GetMapping(path = "/api/find-all-by-page")
    @PriOperation(operationName = "查询用户",operationCode = "user:search")
    @PreAuthorize("hasPermission('','user:search')")
    public Page<SysUser> findALL(Pageable page){
        return sysUserService.findAllByPage(page);
    }

}
