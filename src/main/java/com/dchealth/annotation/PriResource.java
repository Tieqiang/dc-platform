package com.dchealth.annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface PriResource {
    //资源名称
    String resourceName();
    //资源名称
    String resourceCode();
}
