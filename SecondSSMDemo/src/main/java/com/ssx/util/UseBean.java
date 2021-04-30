package com.ssx.util;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseBean {
    public static Object use(String beanName) {
        ClassPathXmlApplicationContext in = new ClassPathXmlApplicationContext("spring+mybatis-config.xml");
        return in.getBean(beanName);
    }

    public static <T> T  use(String beanName, Class<T> a) {
        ClassPathXmlApplicationContext in = new ClassPathXmlApplicationContext("spring+mybatis-config.xml");
        return in.getBean(beanName,a);
    }
}
