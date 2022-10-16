package com.demo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Foo{

	public Foo() {
		System.out.println("ctr of foo");
	}

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		System.out.println("it is public void setMessage(String message)");
		this.message = message;
	}
	//something just before post ctr
	
	@PostConstruct
	private void postConstructMethodUsingAnnotation() {
		System.out.println("it is post contr method @PostConstruct version");
	}
	
	//something just after post ctr
	
	
	@PreDestroy
	private void preDestroyMethodAnnotation() {
		System.out.println("preDestroy method @PreDestroy version is called before bean was destroyed");
	}

}
