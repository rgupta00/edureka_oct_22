package com.demo.backup;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Foo implements InitializingBean, DisposableBean{

	public Foo() {
		System.out.println("ctr of foo");
	}

	private String message;

	
	// life cycle methods: void and not take any parameter
	@PostConstruct
	private void postConstructMethodUsingAnnotation() {
		System.out.println("it is post contr method @PostConstruct version");
	}
	
	private void postConstructMethod() {
		System.out.println("it is post contr method xml version");
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		System.out.println("it is public void setMessage(String message)");
		this.message = message;
	}
	
	@PreDestroy
	private void preDestroyMethodAnnotation() {
		System.out.println("preDestroy method @PreDestroy version is called before bean was destroyed");
	}

	private void preDestroyMethod() {
		System.out.println("preDestroy method xml version is called before bean was destroyed");
	}

	public void destroy() throws Exception {
		System.out.println("destroy is called DisposableBean version");
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("after is called InitializingBean version");
	}

}

//public class Foo implements BeanNameAware{
//
//	public Foo() {
//		System.out.println("ctr of foo");
//	}
//	private String message;
//
//	public String getMessage() {
//		return message;
//	}
//
//	public void setMessage(String message) {
//		System.out.println("it is public void setMessage(String message)");
//		this.message = message;
//	}
//
//	public void setBeanName(String name) {
//		System.out.println("bean is created : "+ name);
//	}
//}
