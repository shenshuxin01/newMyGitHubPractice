package com.ssx.spring2;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackageClasses = {com.ssx.spring2.IBuy.class})
@ComponentScan(basePackageClasses = {com.ssx.entity.POJOUser.class})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {

}
