package com.demo;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoLifeCycle {

	public static void main(String[] args) {
		//one of the real life use case of BeanFactoryPP is to the read the prop file
		//PropertyPlaceholderConfigurer
		System.out.println("---------------------");
		AbstractApplicationContext ctx=new ClassPathXmlApplicationContext("foo.xml");
		
		Foo foo=ctx.getBean("foo", Foo.class);
		System.out.println(foo.getMessage());
		System.out.println(foo.getMessage());
		ctx.registerShutdownHook();
		//ctx.close();
		
	}
}
