package com.dchealth.service.sys;

import com.dchealth.entity.Role;
import com.dchealth.repository.RoleRepo;
import com.dchealth.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleService extends BaseService<Role,String,RoleRepo> {

    @Autowired
    private RoleRepo roleRepo;


    @Transactional
    public Role saveRole(Role role){
        return roleRepo.save(role);
    }


    @Transactional
    public void deleteRoles(Iterable<Role> roles){
        roleRepo.deleteAll(roles);
    }

}
