package com.dchealth.repository;

import com.dchealth.entity.Role;
import com.dchealth.entity.SysUser;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends PagingAndSortingRepository<SysUser, String> {


    public SysUser findSysUserByUsername(String userName);

    List<SysUser> findSysusersByRoles(Role role);
}
