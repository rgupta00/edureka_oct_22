package com.bankapp.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountDaoJdbcImpl implements AccountDao{
private Map<Integer, Account> accounts=new HashMap<>();
	
	public AccountDaoJdbcImpl() {
		accounts.put(1, new Account(1, "sumit", 1000.00));
		accounts.put(2, new Account(2, "amit", 1000.00));
	}
	@Override
	public List<Account> getAll() {
		System.out.println("getAll using jdbc coded ...");
		return new ArrayList<Account>(accounts.values());
	}

	@Override
	public Account getById(int id) {
		return accounts.get(id);
	}

	@Override
	public void updateAccount(Account account) {
		try {
			Thread.sleep(1000);
		}catch(InterruptedException ex) {}
		accounts.put(account.getId(), account);
	}

	@Override
	public void addAccount(Account account) {
		
	}

	@Override
	public void deleteAccount(int id) {
		
	}

}
