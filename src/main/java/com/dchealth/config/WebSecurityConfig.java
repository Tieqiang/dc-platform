package com.dchealth.config;

import com.dchealth.entity.SysUser;
import com.dchealth.filter.JwtAuthorizationFilter;
import com.dchealth.filter.ValidCodeFilter;
import com.dchealth.handler.CustomAccessDeniedHandler;
import com.dchealth.handler.DcAuthenticationEntryPoint;
import com.dchealth.handler.FailHandler;
import com.dchealth.handler.SuccessLoginHandler;
import com.dchealth.service.sys.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SuccessLoginHandler successLoginHandler;

    @Autowired
    private FailHandler failHandler;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private ValidCodeFilter validCodeFilter;


    @Autowired
    private JwtAuthorizationFilter jwtAuthorizationFilter;

    @Autowired
    private DcAuthenticationEntryPoint dcAuthenticationEntryPoint;

    @Autowired
    private CustomAccessDeniedHandler accessDeniedHandler;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Order(1)
    @Bean
    public UserDetailsService userDetailsServiceBean() throws Exception {

        UserDetailsService userDetailsService = new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                SysUser sysUser = sysUserService.loadUserByUsername(username);
                return sysUser;
            }
        };

        return userDetailsService;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.exceptionHandling().accessDeniedHandler(accessDeniedHandler)
                .authenticationEntryPoint(dcAuthenticationEntryPoint).and().addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(validCodeFilter, UsernamePasswordAuthenticationFilter.class)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .formLogin()
                .loginPage("/login.html")
                .successHandler(successLoginHandler).failureHandler(failHandler)
                .and()
                .authorizeRequests()
                .antMatchers("/login.html").permitAll()
                .anyRequest().authenticated();
        http.csrf().disable();
    }
}