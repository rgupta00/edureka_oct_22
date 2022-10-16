package com.demo.backup;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoLifeCycle {

	public static void main(String[] args) {
		System.out.println("---------------------");
		AbstractApplicationContext ctx=new ClassPathXmlApplicationContext("foo.xml");
		
		Foo foo=ctx.getBean("foo", Foo.class);
		System.out.println(foo.getMessage());
		ctx.registerShutdownHook();
		//ctx.close();
		
	}
}
