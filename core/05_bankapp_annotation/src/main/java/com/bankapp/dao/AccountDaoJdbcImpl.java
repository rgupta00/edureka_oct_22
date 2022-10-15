package com.bankapp.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
@Repository
public class AccountDaoJdbcImpl implements AccountDao{
private Map<Integer, Account> accounts=new HashMap<>();
	
	public AccountDaoJdbcImpl() {
		accounts.put(1, new Account(1, "sumit", 1000.00));
		accounts.put(2, new Account(2, "amit", 1000.00));
	}
	@Override
	public List<Account> getAll() {
		System.out.println("getAll using jdbc..");
		return new ArrayList<Account>(accounts.values());
	}

	@Override
	public Account getById(int id) {
		return accounts.get(id);
	}

	@Override
	public void updateAccount(Account account) {
		accounts.put(account.getId(), account);
	}

	@Override
	public void addAccount(Account account) {
		
	}

	@Override
	public void deleteAccount(int id) {
		
	}

}
