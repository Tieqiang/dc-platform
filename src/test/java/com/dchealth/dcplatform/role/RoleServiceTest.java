package com.dchealth.dcplatform.role;

import com.dchealth.entity.Resource;
import com.dchealth.entity.Role;
import com.dchealth.repository.ResourceRepo;
import com.dchealth.repository.RoleRepo;
import com.dchealth.repository.UserRepo;
import com.dchealth.service.sys.RoleService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class RoleServiceTest {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ResourceRepo resourceRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Test
    public void whenAddRole(){
        Iterable<Resource> all = resourceRepo.findAll();
        Role role = new Role();
        role.setRoleName("test");
        role.setResources((List<Resource>) all);
        Role saveRole = roleService.saveRole(role);
        Assert.assertNotNull(saveRole.getId());
    }


    @Test
    public void whenDeleteRole(){
        Iterable<Role> roles = roleRepo.findAll();
        roleService.deleteRoles(roles);
    }


}
