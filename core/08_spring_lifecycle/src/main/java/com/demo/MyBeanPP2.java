package com.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

public class MyBeanPP2 implements BeanPostProcessor, Ordered{

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("MyBeanPP2: it is called just before post ctr of any bean was called : "+ beanName);
		return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

		System.out.println("MyBeanPP2: it is called just after post ctr of any bean was called : "+ beanName);
		return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	}

	@Override
	public int getOrder() {
		return 1;
	}

	
}
