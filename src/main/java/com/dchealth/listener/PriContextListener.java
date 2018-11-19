package com.dchealth.listener;

import com.dchealth.annotation.PriOperation;
import com.dchealth.annotation.PriResource;
import com.dchealth.controller.base.BaseController;
import com.dchealth.entity.Resource;
import com.dchealth.service.sys.ResourceService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * 系统启动后获取所有的对象
 */
@Component
public class PriContextListener implements ApplicationListener<ContextRefreshedEvent> {


    @Autowired
    private ResourceService resourceService;

    private final Logger logger = LoggerFactory.getLogger(PriContextListener.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        //跟容器
        if (event.getApplicationContext().getParent() == null) {
            ApplicationContext applicationContext = event.getApplicationContext();
            Map<String, Object> beansWithAnnotation = applicationContext.getBeansWithAnnotation(PriResource.class);
            List<Resource> resourceList = new ArrayList<>();
            for (String key : beansWithAnnotation.keySet()) {
                Object o = beansWithAnnotation.get(key);
                Class<?> aClass = o.getClass();

                String name = aClass.getName();
                if (!StringUtils.endsWith(StringUtils.upperCase(name), StringUtils.upperCase(key))||(o instanceof BaseController)) {
                    //判断是否为Spring创建的临时类的实例
                    aClass = aClass.getSuperclass();
                }


                String resourceName = "";
                String resourceCode = "";
                if(o instanceof BaseController){
                    resourceName=((BaseController) o).getObjectName();
                    resourceCode = ((BaseController) o).getObjectCode();
                }else{
                    PriResource priResource = aClass.getAnnotation(PriResource.class);
                    resourceName = priResource.resourceName();
                    resourceCode= priResource.resourceCode();

                }
                logger.info(resourceName);


                if (StringUtils.isEmpty(resourceName)) {
                    try {
                        throw new Exception(aClass.getName() + "PriResource注解使用有误，请添加resourceName属性值");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return;
                }

                Method[] methods = aClass.getMethods();
                for (Method method : methods) {
                    Annotation[] annotations = method.getAnnotations();
                    logger.info(method.getName() + ":");
                    for (Annotation annotation : annotations) {
                        logger.info(annotation.toString());
                    }
                    PriOperation annotation = method.getAnnotation(PriOperation.class);
                    if (annotation != null) {
                        Resource resource = new Resource();
                        resource.setResourceName(resourceName);
                        resource.setOperationCode(resourceCode+":"+annotation.operationCode());
                        resource.setOperationName(annotation.operationName()+resourceName);
                        resource.setSysFlag("1");
                        resourceList.add(resource);
                    }
                }

            }
            int i = resourceService.updateSysResource(resourceList);
            logger.info("系统权限初始化成功，共新添加权限：" + i + "条");
        }
    }


}
