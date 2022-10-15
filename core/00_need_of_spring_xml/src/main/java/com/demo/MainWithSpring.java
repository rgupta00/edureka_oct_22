package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainWithSpring {

	public static void main(String[] args) {
		
		//Spring act as a "container" ApplicationContext => ClasspathXmlApplicationContext
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		Passanger passanger=ctx.getBean("p",Passanger.class);
		passanger.travel();
		
		//Passanger passanger2=ctx.getBean("p",Passanger.class);
		
//		System.out.println(passanger.hashCode());
//		System.out.println(passanger2.hashCode());
	}
}
