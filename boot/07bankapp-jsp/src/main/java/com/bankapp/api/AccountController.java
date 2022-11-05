package com.bankapp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bankapp.service.AccountService;

@Controller
public class AccountController {

private AccountService accountService;
	
	@Autowired
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	
	//get all accounts on jsp
	@GetMapping(path = "allaccounts")
	public ModelAndView allaccounts(ModelAndView mv) {
		mv.addObject("accountsList", accountService.getAll());
		mv.setViewName("accounts");
		return mv;
	}
}






