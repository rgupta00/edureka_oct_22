package com.bankapp.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.bankapp.entities.Account;

@Repository
@Primary
public class AccountDaoMapImpl implements AccountDao{
private Map<Integer, Account> accounts=new HashMap<>();
	
	public AccountDaoMapImpl() {
		accounts.put(1, new Account(1, "ravi", new BigDecimal(1000), "ravi@gmail.com", "5566656565"));
		accounts.put(2, new Account(2, "sumit", new BigDecimal(1000), "sumit@gmail.com", "8866656560"));
	}
	@Override
	public List<Account> getAll() {
		System.out.println("getAll using hard coded collection...");
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
