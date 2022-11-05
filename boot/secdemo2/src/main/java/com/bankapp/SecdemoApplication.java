package com.bankapp;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bankapp.entity.UserEntity;
import com.bankapp.service.UserService;

@SpringBootApplication
public class SecdemoApplication implements CommandLineRunner{

	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(SecdemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userService.addUserEntity(new UserEntity("raj", "raj123", Arrays.asList("ROLE_ADMIN","ROLE_MGR","ROLE_CLERK")));
		userService.addUserEntity(new UserEntity("ekta", "ekta123", Arrays.asList("ROLE_MGR","ROLE_CLERK")));
		userService.addUserEntity(new UserEntity("gun", "gun123", Arrays.asList("ROLE_CLERK")));
		
	}

}
