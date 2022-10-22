package com.bankapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/*
 * <context:annotation-config/>
	<context:component-scan base-package="com.bankapp"/>
	
	<!-- spring + aspectJ integration -->
	<aop:aspectj-autoproxy/>
 */
@Configuration
@ComponentScan(basePackages = "com.bankapp")
@EnableAspectJAutoProxy
public class AppConfig {

}
