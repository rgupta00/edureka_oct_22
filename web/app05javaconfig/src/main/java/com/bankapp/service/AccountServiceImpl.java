package com.bankapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.dao.Account;
import com.bankapp.dao.AccountDao;
import com.bankapp.exception.BankAccountNotFoundExcetion;

@Service(value = "bs")
@Transactional
//declartive way to handle ACID under the hood @Around advice 
final public class AccountServiceImpl implements AccountService {

	private AccountDao accountDao;

	@Autowired
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Account> getAll() {
		return accountDao.getAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Account getById(int id) {
		Account account = accountDao.getById(id);
		if (account == null)
			throw new BankAccountNotFoundExcetion("account with id " + id + " is not found");
		return account;
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
