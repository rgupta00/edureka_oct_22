package com.bankapp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.dao.Account;
import com.bankapp.dao.AccountDao;
import com.bankapp.dao.AccountDaoMapImpl;
import com.bankapp.exception.BankAccountNotFoundExcetion;
@Service(value = "bs")
@Transactional(isolation = Isolation.REPEATABLE_READ)
//declartive way to handle ACID under the hood @Around advice 
final public class AccountServiceImpl implements AccountService {

	private AccountDao accountDao;

	
	
	@Autowired
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public List<Account> getAll() {
		return accountDao.getAll();
	}

	@Override
	public Account getById(int id) {
		Account account= accountDao.getById(id);
		if(account==null)
			throw new BankAccountNotFoundExcetion("account with id "+ id +" is not found");
		return account;
	}

	@Override
	public void transfer(int fromAccId, int toAccId, double amount) {	
		Account fromAcc = getById(fromAccId);
		Account toAcc = getById(toAccId);

		fromAcc.setBalance(fromAcc.getBalance() - amount);
		toAcc.setBalance(toAcc.getBalance() + amount);

		accountDao.updateAccount(fromAcc);
		if(1==1)
			throw new RuntimeException();
		
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
