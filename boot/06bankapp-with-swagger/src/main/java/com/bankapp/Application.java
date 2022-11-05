package com.bankapp;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.bankapp.entities.Account;
import com.bankapp.service.AccountService;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private AccountService accountService;
	
	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		accountService.addAccount(new Account("ravi", new BigDecimal(1000), "ravi@gmail.com", "7567565656"));
		accountService.addAccount(new Account("sumit", new BigDecimal(1000), "sumit@gmail.com", "7007565656"));
	}

}
