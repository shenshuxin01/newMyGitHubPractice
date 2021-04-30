package com.ssx.util;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SpringUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringUtil.applicationContext = applicationContext;
    }

    public static <T> T getBean(String beanName,Class<T> t) {
        Logger logger = Logger.getLogger(SpringUtil.class);
        logger.info("开始测试输出所有的bean-Name");
        logger.info("开始测试输出所有的bean-Name");
        logger.info("开始测试输出所有的bean-Name");
        logger.info("开始测试输出所有的bean-Name");
        logger.info("开始测试输出所有的bean-Name");
        logger.info("开始测试输出所有的bean-Name");
        logger.info("开始测试输出所有的bean-Name");
        logger.info("开始测试输出所有的bean-Name");

//        System.out.println();
        String[] names = applicationContext.getBeanDefinitionNames();
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
            logger.info("   第"+i+"个: "+names[i]);
        }
        logger.info("结束输出所有的bean-Name");
        logger.info("结束输出所有的bean-Name");
        logger.info("结束输出所有的bean-Name");
        logger.info("结束输出所有的bean-Name");

        if(applicationContext.containsBean(beanName)){
            return applicationContext.getBean(beanName,t);
        }else{
            return null;
        }
    }


}
