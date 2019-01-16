package com.dchealth.config;

import com.dchealth.entity.SysUser;
import com.dchealth.filter.JwtAuthorizationFilter;
import com.dchealth.filter.ValidCodeFilter;
import com.dchealth.handler.CustomAccessDeniedHandler;
import com.dchealth.handler.DcAuthenticationEntryPoint;
import com.dchealth.handler.FailHandler;
import com.dchealth.handler.SuccessLoginHandler;
import com.dchealth.service.sys.SysUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SuccessLoginHandler successLoginHandler;

    @Autowired
    private SystemProperties systemProperties ;


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

    /**
     * 配置允许跨域访问的类型
     * @return
     */
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList(systemProperties.getCors().getAllowedOrigins().split(",")));
        configuration.setAllowedMethods(Arrays.asList(systemProperties.getCors().getAllowedMethods().split(",")));
        configuration.setAllowedHeaders(Arrays.asList(systemProperties.getCors().getAllowedHeaders().split(",")));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().disable() ;
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry expressionInterceptUrlRegistry =
                http.exceptionHandling()
                        .accessDeniedHandler(accessDeniedHandler)
                .authenticationEntryPoint(dcAuthenticationEntryPoint)
                        .and().addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(validCodeFilter, UsernamePasswordAuthenticationFilter.class)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .formLogin()
                .loginPage("/login.html")
                .successHandler(successLoginHandler).failureHandler(failHandler)
                .and()
                .authorizeRequests()
                .antMatchers("/login.html").permitAll();

        String exceptUrls = systemProperties.getExceptUrls();
        if(StringUtils.isNotEmpty(exceptUrls)){
            //添加排除验证的接口
            String[] split = exceptUrls.split(",");
            expressionInterceptUrlRegistry.antMatchers(split).permitAll();
        }


        expressionInterceptUrlRegistry.requestMatchers(CorsUtils::isCorsRequest).permitAll();//解决跨域请求
        expressionInterceptUrlRegistry
                .anyRequest().authenticated();
        http.csrf().disable();
    }
}