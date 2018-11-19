package com.dchealth.controller.sys;

import com.dchealth.controller.base.BaseController;
import com.dchealth.entity.Role;
import com.dchealth.service.sys.RoleService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/role")
@Api(description = "角色管理相关接口")
public class RoleController extends BaseController<Role,String,RoleService> {
    public RoleController() {
        super("角色管理");
    }
}
