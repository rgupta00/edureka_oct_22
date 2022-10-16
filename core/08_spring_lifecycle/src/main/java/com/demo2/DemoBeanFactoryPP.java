package com.demo2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoBeanFactoryPP {

	public static void main(String[] args) {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("demo2.xml");
		Account account=applicationContext.getBean("acc",Account.class);
		System.out.println(account);
	}
}
