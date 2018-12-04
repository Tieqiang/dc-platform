package com.dchealth.controller;

import com.dchealth.annotation.PriOperation;
import com.dchealth.annotation.PriResource;
import com.dchealth.config.SystemProperties;
import com.dchealth.entity.SysUser;
import com.dchealth.service.sys.SysUserService;
import com.dchealth.util.JwtUtils;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@PriResource(resourceName = "用户管理",resourceCode = "user")
@RequestMapping("api/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private SysUserService sysUserService ;

    @Autowired
    private SystemProperties systemProperties ;

    @Autowired
    private JwtUtils jwtUtils ;


    @PriOperation(operationName = "用户注册",operationCode = "user:sign")
    @PostMapping(path = "/api/user",consumes = {"application/x-www-form-urlencoded"})
    public SysUser singup(@RequestBody SysUser sysUser){
        sysUser.setPassword(new BCryptPasswordEncoder().encode(sysUser.getPassword()));
        return sysUserService.merge(sysUser);
    }

    @GetMapping(path = "current-user")
    @ApiOperation("获取当前登录用户")
    public SysUser getCurrentUser(HttpServletRequest httpServletRequest){
        String header = httpServletRequest.getHeader(systemProperties.getAuthention().getName());
        String token = header.substring(systemProperties.getAuthention().getPrefix().length());
        if(logger.isDebugEnabled()){
            logger.info("从请求信息中，获取的token="+token);
        }
        String userName = jwtUtils.getUserName(token);
        return sysUserService.loadUserByUsername(userName);
    }


    @ApiOperation("获取某一个角色的所有用户")
    @GetMapping(path="user-by-role-id")
    public List<SysUser> getUserByRoleId(@RequestParam("roleId") String roleId){
        return sysUserService.getUserByRoleId(roleId);
    }

    @GetMapping(path="find-all")
    @ApiOperation("获取所有用户")
    @PriOperation(operationName = "获取所有用户",operationCode = "user:findAll")
    public List<SysUser> findAllUser(){
        return (List<SysUser>) sysUserService.findAll();
    }
}
