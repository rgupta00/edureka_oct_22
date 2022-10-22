package com.bankapp.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bankapp.config.AppConfig;
import com.bankapp.dao.Account;
import com.bankapp.service.AccountService;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
		
		AccountService accountService=(AccountService) context.getBean("bs");
		
		System.out.println(accountService.getClass());
		
		List<Account> accounts=accountService.getAll();
		accounts.forEach(a-> System.out.println(a));
		
		accountService.transfer(1, 2, 10);
		
		accounts=accountService.getAll();
		accounts.forEach(a-> System.out.println(a));
		
	}
}
