package com.dchealth.controller.sys;

import com.dchealth.annotation.PriOperation;
import com.dchealth.controller.base.BaseController;
import com.dchealth.entity.Resource;
import com.dchealth.service.sys.ResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "权限资源维护接口")
@RequestMapping(path = "api/resource")
public class ResourceController extends BaseController<Resource,String,ResourceService>{
    public ResourceController() {
        super("权限资源");
    }

    @GetMapping(path = "find-one-by-operation-code")
    @ApiOperation(value = "根据OperationCode获取的资源信息")
    @PreAuthorize("hasPermission('','read:single')")
    public Resource findResourceByResourceCode(@RequestParam("code") String resourceCode){
        return getService().getResourceByOperationCode(resourceCode);
    }

}
