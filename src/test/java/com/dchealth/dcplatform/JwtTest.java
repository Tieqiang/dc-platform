package com.dchealth.dcplatform;

import com.dchealth.config.SystemProperties;
import com.dchealth.util.JwtUtils;
import io.jsonwebtoken.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class JwtTest {

    @Autowired
    private JwtUtils jwtUtils ;

    @Autowired
    private SystemProperties systemProperties ;


    @Test
    public void tokenBuildTest(){

        String role = "admin,name,password,dongfeng,nihao,alb";

        Map<String, Object> map = new HashMap<>();
        map.put("role",role);
        String token = Jwts.builder().setClaims(map).setSubject("test").setExpiration(new Date(System.currentTimeMillis()+60*60*24*1000)).
                signWith(SignatureAlgorithm.HS256,"myScript").compact();
        System.out.println(token);
        //eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0IiwiZXhwIjoxNTQyMDkzMDAyfQ.IdlRAbZcK1KegOLQtEPC7A5zyqPv7YQ4qSYTXidR9UM
    }



    public void decodeToken(){
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0Iiwicm9sZSI6ImFkbWluLG5hbWUscGFzc3dvcmQiLCJleHAiOjE1NDIwOTUzODF9.DUJXtnf6O-s4WQCFS2ZgdX-ZyamXZufSJvzzpThRI5o";
        Jws<Claims> jws = Jwts.parser().setSigningKey("myScript").parseClaimsJws(token);


        String myScript = jws.getBody().getSubject();
        Object role = jws.getBody().get("role");
        System.out.println(role);
        System.out.println(myScript);
        Assert.assertEquals("test",myScript);
    }

    @Test
    public void testJwtUtilsPrefix(){
        System.out.println(systemProperties.getAuthention().getPrefix());
        Assert.assertTrue(true);
    }

}
