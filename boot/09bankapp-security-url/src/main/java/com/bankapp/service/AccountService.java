package com.bankapp.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import com.bankapp.dto.AccountDetailsDto;
import com.bankapp.entities.Account;

public interface AccountService {
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_MGR') or hasAuthority('ROLE_CLERK')")
	public List<Account> getAll();
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_MGR') or hasAuthority('ROLE_CLERK')")
	public Account getById(int id);

	@PreAuthorize("hasAuthority('ROLE_MGR') or hasAuthority('ROLE_CLERK')")
	public void transfer(int fromAccId, int toAccId, double amount);
	
	@PreAuthorize("hasAuthority('ROLE_MGR') or hasAuthority('ROLE_CLERK')")
	public void deposit(int id, double amount);
	
	@PreAuthorize("hasAuthority('ROLE_MGR') or hasAuthority('ROLE_CLERK')")
	public void withdraw(int id, double amount);
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public Account addAccount(Account account);
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public void deleteAccount(int id);
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public Account updateAccountDetails(int id, AccountDetailsDto accountDetailsDto);
}
