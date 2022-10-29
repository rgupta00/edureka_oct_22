package com.bankapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bankapp.dto.DepositDto;
import com.bankapp.dto.TransferDto;
import com.bankapp.dto.WithdrawDto;
import com.bankapp.service.AccountService;

@Controller
public class AccountController {

	private AccountService accountService;

	@Autowired
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@GetMapping(path = "/")
	public ModelAndView home(ModelAndView mv) {
		mv.setViewName("accounts");
		mv.addObject("accountsList", accountService.getAll());//data is added to req scope and request dispaching is done
		return mv;
	}
	
	//--------------show all the accounts-----------
	@GetMapping(path = "allaccounts")
	public ModelAndView showAll(ModelAndView mv) {
		mv.setViewName("accounts");
		mv.addObject("accountsList", accountService.getAll());//data is added to req scope and request dispaching is done
		return mv;
	}
	
	//----------
	//. create a new account
	// change the address details	 etc
	// deleate a account
}







