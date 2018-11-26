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
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
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
    public void whenAddRole() {
        Iterable<Resource> all = resourceRepo.findAll();
        Role role = new Role();
        role.setRoleName("test");
        role.setResources((List<Resource>) all);
        Role saveRole = roleService.saveRole(role);
        Assert.assertNotNull(saveRole.getId());
    }


    @Test
    public void whenDeleteRole() {
        Iterable<Role> roles = roleRepo.findAll();
        roleService.deleteRoles(roles);
    }

    @Test
    public void whenAddRoleSingle() {
        Role role = new Role();
        role.setRoleName("管理员");
        role = roleService.saveRole(role);
        Assert.assertNotNull(role.getId());

    }

    /**
     * 测试修改角色
     */
    @Test
    @Transactional
    @Rollback(false)
    public void whenUpdateRole() {
        Iterable<Role> all = roleRepo.findAll();
        Iterator<Role> iterator = all.iterator();
        while (iterator.hasNext()) {
            Role next = iterator.next();
            if ("管理员".equals(next.getRoleName())) {
                Resource resource = new Resource();
                resource.setOperationName("test:test");
                resource.setSysFlag("1");
                resource.setResourceName("测试资源");
                resource.setOperationName("测试操作");
                List<Resource> resourceses = new ArrayList<>();
                resourceses.add(resource);
                next.setResources(resourceses);
                roleRepo.save(next);
            }
        }
    }

    @Test
    @Transactional
    @Rollback(false)
    public void whenDeleteRoleSingle() {
        Iterable<Role> all = roleRepo.findAll();
        Iterator<Role> iterator = all.iterator();
        while (iterator.hasNext()) {
            Role next = iterator.next();
            if ("管理员".equals(next.getRoleName())) {
                roleRepo.delete(next);
            }
        }
    }


}
