package com.dchealth.service.sys;

import com.dchealth.entity.Resource;
import com.dchealth.repository.ResourceRepo;
import com.dchealth.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ResourceService extends BaseService<Resource,String,ResourceRepo> {

    @Autowired
    private ResourceRepo resourceRepo;


    /**
     * 删除所有的制定的权限
     *
     * @param sysFlag
     * @return
     */
    @Transactional
    public int deleteResourceBySysFlag(String sysFlag) {
        return resourceRepo.deleteAllBySysFlag(sysFlag);
    }

    /**
     * 保存新增的权限
     * @param resources
     * @return
     */
    @Transactional
    public int updateSysResource(List<Resource> resources) {

        int i =0;
        for (Resource resource : resources) {
            if (!resourceRepo.existsResourceByResourceNameAndOperationCodeAndOperationNameAndSysFlag(resource.getResourceName(),
                    resource.getOperationCode(), resource.getOperationName(), resource.getSysFlag())) {
                resourceRepo.save(resource);
                i++;
            }
        }
        return i ;

    }

    /**
     * 根据OperationCode获取资源
     * @param operationCode
     * @return
     */
    public Resource getResourceByOperationCode(String operationCode){
        return resourceRepo.findResourceByOperationCode(operationCode);
    }

}
