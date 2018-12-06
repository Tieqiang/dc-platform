package com.dchealth.utils;


import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassUtils {

    /**
     * 相似对象属性copy
     * @param source
     * @param target
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    public static void copyProperties(Object source, Object target) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        Class<?> sourceClass = source.getClass();
        Class<?> targetClass = target.getClass();

        Field[] fields = targetClass.getDeclaredFields();
        for (Field field : fields) {
            String name = field.getName();
            Field sourceField = sourceClass.getDeclaredField(name);
            if (sourceField != null) {
                Class<?> type = sourceField.getType();
                Object value ;

                Method declaredMethod = sourceClass.getDeclaredMethod("get" + StringUtils.upperCase(name.substring(0, 1)) + name.substring(1));
                value = declaredMethod.invoke(source);
                Method setMethod = targetClass.getDeclaredMethod("set" + StringUtils.upperCase(name.substring(0, 1)) + name.substring(1),field.getType());
                setMethod.invoke(target,value);
            }
        }

    }

}
