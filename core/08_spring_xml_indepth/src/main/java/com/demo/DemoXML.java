package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoXML {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("lifecycle.xml");
	}
}
