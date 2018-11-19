package com.dchealth.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface PriOperation {

    //操作名称
    String operationName();
    //操作代码
    String operationCode();
    //是否系统权限
    String sysFlag() default "1";

}
