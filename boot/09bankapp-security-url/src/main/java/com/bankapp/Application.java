package com.bankapp;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bankapp.entities.Account;
import com.bankapp.entities.UserEntity;
import com.bankapp.service.AccountService;
import com.bankapp.service.UserService;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private UserService userService;
	
	
	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		userService.addUserEntity(new UserEntity("raj", "raj123", Arrays.asList("ROLE_ADMIN","ROLE_MGR","ROLE_CLERK")));
		userService.addUserEntity(new UserEntity("ekta", "ekta123", Arrays.asList("ROLE_MGR","ROLE_CLERK")));
		userService.addUserEntity(new UserEntity("gun", "gun123", Arrays.asList("ROLE_CLERK")));
		
		//accountService.addAccount(new Account("ravi", new BigDecimal(1000), "ravi@gmail.com", "7567565656"));
		//accountService.addAccount(new Account("sumit", new BigDecimal(1000), "sumit@gmail.com", "7007565656"));
	
	
	}

}
