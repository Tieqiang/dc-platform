package com.dchealth.service.sys;

import com.dchealth.entity.SysUser;
import com.dchealth.repository.UserRepo;
import com.dchealth.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SysUserService extends BaseService<SysUser,String,UserRepo> {

    @Autowired
    private UserRepo userRepo ;

    public SysUser loadUserByUsername(String username){
        return userRepo.findSysUserByUsername(username);
    }


    @Transactional
    public SysUser merge(SysUser sysUser) {
        return userRepo.save(sysUser);
    }


}
