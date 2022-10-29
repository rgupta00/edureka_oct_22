package com.bankapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bankapp.dao.Account;
import com.bankapp.dto.DepositDto;
import com.bankapp.dto.TransferDto;
import com.bankapp.dto.WithdrawDto;
import com.bankapp.service.AccountService;

@RestController
@RequestMapping(path = "api")
public class AccountRESTController {

	private AccountService accountService;

	@Autowired
	public AccountRESTController(AccountService accountService) {
		this.accountService = accountService;
	}
	
//	@GetMapping(path = "/")
//	public ModelAndView home(ModelAndView mv) {
//		mv.setViewName("accounts");
//		mv.addObject("accountsList", accountService.getAll());//data is added to req scope and request dispaching is done
//		return mv;
//	}
//	
	//--------------show all the accounts-----------
	@GetMapping(path = "accounts")
	public List<Account>  getAllAccounts() {
		return accountService.getAll();
	}
	
	//----------
	//. create a new account
	// change the address details	 etc
	// deleate a account
}







