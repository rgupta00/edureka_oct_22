package com.bankapp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.dto.DepositDto;
import com.bankapp.dto.TransferDto;
import com.bankapp.dto.WithdrawDto;
import com.bankapp.service.AccountService;

@RestController
@RequestMapping(path = "api/transaction")
public class TransactionApi {

	private AccountService accountService;
	
	@Autowired
	public TransactionApi(AccountService accountService) {
		this.accountService = accountService;
	}
	//--------------transfer the fund-------------------
	@PostMapping(path = "transfer")
	public ResponseEntity<String> transfer( @RequestBody TransferDto transferDto) {
		accountService.transfer(transferDto.getFromAccId(), transferDto.getToAccId(), transferDto.getAmount());
		return ResponseEntity.status(HttpStatus.CREATED).body("fund is transfered successfully");
	}
	
	//--------------deposit the fund-------------------
	@PostMapping(path = "deposit")
	public String deposit( @RequestBody DepositDto depositDto) {
		accountService.deposit(depositDto.getAccId(), depositDto.getAmount());
		return "fund is deposit successfully";
	}
	
	//--------------withdraw the fund-------------------
	@PostMapping(path = "withdraw")
	public String withdraw( @RequestBody WithdrawDto withdrawDto) {
		accountService.withdraw(withdrawDto.getAccId(), withdrawDto.getAmount());
		return "fund is withdraw successfully";
	}

}







