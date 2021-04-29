package com.ssx.spring2;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {com.ssx.mvc.DemoRM.class})
public class AppConfigMVC {

}
