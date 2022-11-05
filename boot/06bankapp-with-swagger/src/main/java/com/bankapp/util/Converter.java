package com.bankapp.util;

import com.bankapp.dto.AccountDto;
import com.bankapp.entities.Account;

public class Converter {

	//convert Account to accountDto
	
	public static Account convertToAccount(AccountDto accountDto) {
		Account account=new Account();
		account.setBalance(accountDto.getBalance());
		account.setEmail(accountDto.getEmail());
		account.setId(accountDto.getId());
		account.setName(accountDto.getName());
		account.setPhone(accountDto.getPhone());
		return account;
	}
	
	
	//AccountDto to account object
	
	public static AccountDto convertToAccountDto(Account account) {
		AccountDto accountDto=new AccountDto();
		accountDto.setId(account.getId());
		accountDto.setBalance(account.getBalance());
		accountDto.setEmail(account.getEmail());
		accountDto.setName(account.getName());
		accountDto.setPhone(account.getPhone());
		
		return accountDto;
	}
	
}
