package com.bankapp.api;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.entities.Account;
import com.bankapp.service.AccountService;

@RestController//  =@Controller+ @ResponseBody
@RequestMapping(path = "api")
public class AccountApi {
	
	private AccountService accountService;
	
	@Autowired
	public AccountApi(AccountService accountService) {
		this.accountService = accountService;
	}
	
	//logic to get all accounts
	@GetMapping(path = "accounts")
	public List<Account> getAll(){
		return accountService.getAll();
	}
	
	//get account by id
	//http://localhost:8090/bankapp/api/accounts?city=delhi&country=india @RequstParam annotation
	
	@GetMapping(path = "accounts/{id}")
	public Account getAccountById(@PathVariable(name = "id")  int id){
		return accountService.getById(id);
	}
	
	//update the account details
	
	//delete the acc
	
	//add new account

}
