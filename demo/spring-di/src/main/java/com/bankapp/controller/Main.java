package com.bankapp.controller;
import java.util.*;

import com.bankapp.dao.Account;
import com.bankapp.service.AccountService;
import com.bankapp.service.AccountServiceImpl;

public class Main {

	public static void main(String[] args) {
		
		AccountService accountService=new AccountServiceImpl();
		
		List<Account> accounts=accountService.getAll();
		accounts.forEach(a-> System.out.println(a));
		
		accountService.transfer(1, 2, 10);
		accounts=accountService.getAll();
		accounts.forEach(a-> System.out.println(a));
	}
}
