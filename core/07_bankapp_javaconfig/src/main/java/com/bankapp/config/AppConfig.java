package com.bankapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.bankapp.dao.AccountDao;
import com.bankapp.dao.AccountDaoMapImpl;
import com.bankapp.service.AccountService;
import com.bankapp.service.AccountServiceImpl;

@Configuration
//@ComponentScan(basePackages = {"com.bankapp"})
 public class AppConfig {

	@Bean
	public AccountDao accountDaoMapImpl() {
		AccountDao accountDao=new AccountDaoMapImpl();
		return accountDao;
	}
	
	@Bean(name = "bs")
	public AccountService getAccountService(AccountDao accountDao) {
		System.out.println("i am going to be called only only once getAccountService()");
		AccountService accountService=new AccountServiceImpl(accountDao);
	
		return accountService;
	}
}
