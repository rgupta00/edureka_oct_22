package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("aop.xml");
		Magician magician=ctx.getBean("magician",Magician.class);
		magician.doMagic();
		//System.out.println(magician.getClass());
		
	}
}
