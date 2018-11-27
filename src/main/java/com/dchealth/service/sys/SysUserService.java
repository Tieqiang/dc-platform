package com.dchealth.service.sys;

import com.dchealth.entity.Role;
import com.dchealth.entity.SysUser;
import com.dchealth.exception.DcException;
import com.dchealth.repository.RoleRepo;
import com.dchealth.repository.UserRepo;
import com.dchealth.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SysUserService extends BaseService<SysUser,String,UserRepo> {

    @Autowired
    private UserRepo userRepo ;

    @Autowired
    private RoleRepo roleRepo ;

    public SysUser loadUserByUsername(String username){
        return userRepo.findSysUserByUsername(username);
    }


    @Transactional
    public SysUser merge(SysUser sysUser) {
        return userRepo.save(sysUser);
    }


    public List<SysUser> getUserByRoleId(String roleId) {
        List<SysUser> sysUsers =new ArrayList<>();
        Optional<Role> byId = roleRepo.findById(roleId);
        if(byId.isPresent()){
            Role role = byId.get();
            sysUsers = userRepo.findSysusersByRoles(role);
        }else{
            throw new DcException("不存在的角色信息");
        }

        return sysUsers;
    }
}
