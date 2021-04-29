package com.ssx.spring2.aop;


import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoAop {
    @Before("execution(* com.ssx.spring2.ioc.Boy.buy(..))")
    public void haha(){
        Logger.getLogger(DemoAop.class).info("aop执行");
        System.out.println("这是before方法，先执行此方法-aop");
    }
}
