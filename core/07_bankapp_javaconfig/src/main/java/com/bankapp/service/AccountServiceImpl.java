package com.bankapp.service;

import java.util.List;

import com.bankapp.dao.Account;
import com.bankapp.dao.AccountDao;
import com.bankapp.dao.AccountDaoMapImpl;

public class AccountServiceImpl implements AccountService {

	private AccountDao accountDao;

	
	public AccountServiceImpl() {}

	public AccountServiceImpl(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public List<Account> getAll() {
		return accountDao.getAll();
	}

	@Override
	public Account getById(int id) {
		return accountDao.getById(id);
	}

	@Override
	public void transfer(int fromAccId, int toAccId, double amount) {
		Account fromAcc = getById(fromAccId);
		Account toAcc = getById(toAccId);

		fromAcc.setBalance(fromAcc.getBalance() - amount);
		toAcc.setBalance(toAcc.getBalance() + amount);

		accountDao.updateAccount(fromAcc);
		accountDao.updateAccount(toAcc);

	}

	@Override
	public void deposit(int id, double amount) {
		Account acc = getById(id);

		acc.setBalance(acc.getBalance() + amount);

		accountDao.updateAccount(acc);

	}

	@Override
	public void withdraw(int id, double amount) {
		Account acc = getById(id);

		acc.setBalance(acc.getBalance() - amount);

		accountDao.updateAccount(acc);
	}

	@Override
	public void addAccount(Account account) {

	}

	@Override
	public void deleteAccount(int id) {

	}

}
