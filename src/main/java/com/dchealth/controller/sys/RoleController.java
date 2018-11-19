package com.dchealth.controller.sys;

import com.dchealth.controller.base.BaseController;
import com.dchealth.entity.Role;
import com.dchealth.service.sys.RoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/role")
public class RoleController extends BaseController<Role,String,RoleService> {
    public RoleController() {
        super("角色管理");
    }
}
