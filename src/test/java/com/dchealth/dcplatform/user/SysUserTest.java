package com.dchealth.dcplatform.user;

import com.dchealth.entity.Role;
import com.dchealth.entity.SysUser;
import com.dchealth.repository.RoleRepo;
import com.dchealth.repository.UserRepo;
import com.dchealth.service.sys.SysUserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class SysUserTest {

    @Autowired
    private UserRepo userRepo ;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private RoleRepo roleRepo;

    @Test
    @Transactional
    @Rollback(false)
    public void whenAddUser(){
        Iterable<Role> all = roleRepo.findAll();
        SysUser sysUser = new SysUser();
        sysUser.setUsername("lili1");
        sysUser.setPassword(passwordEncoder.encode("lili"));
        sysUser.setRoles((List<Role>) all);
        sysUser= userRepo.save(sysUser);
        Assert.assertTrue(sysUser.isAccountNonExpired());
    }

    @Test
    public void test(){
        System.out.println(this.getMastString("bbbbbbb"));
    }



    public int getMastString(String s){
        int lenght = s.length();
        String maxStr = "";
        for(int i =1;i<lenght/2;i++){
            for (int j=0;j<lenght-i;j++){
                String compareString = s.substring(j,j+i);
                String leftString = s.substring(j+i);

                if(leftString.contains(compareString)){
                    if(maxStr.length()<compareString.length()){
                        maxStr = compareString;
                    }
                }
            }
        }
        return maxStr.length();
    }


}
