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
public class TransactionController {

	private AccountService accountService;

	@Autowired
	public TransactionController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	//i want to write the code transfer
	@GetMapping(path = "transfer")
	public String transferGet(Model model) {
		model.addAttribute("transferDto", new TransferDto());
		return "transferpage";
	}
	@PostMapping(path = "transfer")
	public String transferPost(TransferDto transferDto) {

		accountService.transfer(transferDto.getFromAccId(), transferDto.getToAccId(), transferDto.getAmount());
		return "redirect:allaccounts";//after post alway use PRG
	}
	
	
	//deposit
	
	@GetMapping(path = "deposit")
	public String depositGet(Model model) {
		model.addAttribute("depositDto", new DepositDto());
		return "deposit";
	}
	@PostMapping(path = "deposit")
	public String depositPost(DepositDto depositDto) {

		accountService.deposit(depositDto.getAccId(), depositDto.getAmount());
		return "redirect:allaccounts";//after post alway use PRG
	}
	
	//withdraw
	@GetMapping(path = "withdraw")
	public String withdrawGet(Model model) {
		model.addAttribute("withdrawDto", new WithdrawDto());
		return "withdraw";
	}
	@PostMapping(path = "withdraw")
	public String withdrawPost(WithdrawDto withdrawDto) {

		accountService.withdraw(withdrawDto.getAccId(), withdrawDto.getAmount());
		return "redirect:allaccounts";//after post alway use PRG
	}
}







