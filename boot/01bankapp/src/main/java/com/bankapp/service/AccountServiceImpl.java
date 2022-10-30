package com.bankapp.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.dao.AccountDao;
import com.bankapp.entities.Account;
import com.bankapp.exceptions.BankAccountNotFoundException;

@Service
public class AccountServiceImpl implements AccountService {

	private AccountDao accountDao;

	private EmailService emailService;

	public AccountServiceImpl() {
	}

	@Autowired
	public AccountServiceImpl(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	// @Autowired
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Autowired
	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}

	@Override
	public List<Account> getAll() {
		return accountDao.getAll();
	}

	@Override
	public Account getById(int id) {
		Account account = accountDao.getById(id);
		if (account == null)
			throw new BankAccountNotFoundException("account with id " + id + " is not found");
		return account;
	}

	@Override
	public void transfer(int fromAccId, int toAccId, double amount) {
		Account fromAcc = getById(fromAccId);
		Account toAcc = getById(toAccId);

		fromAcc.setBalance(fromAcc.getBalance().subtract(new BigDecimal(amount)));
		toAcc.setBalance(toAcc.getBalance().add(new BigDecimal(amount)));

		accountDao.updateAccount(fromAcc);
		accountDao.updateAccount(toAcc);

		if (emailService != null) {
			emailService.sendEmail("amit@gmail.com", "fund is transfer successfully!");
		}

	}

	@Override
	public void deposit(int id, double amount) {
		Account acc = getById(id);

		acc.setBalance(acc.getBalance().add(new BigDecimal(amount)));

		accountDao.updateAccount(acc);

	}

	@Override
	public void withdraw(int id, double amount) {
		Account acc = getById(id);

		acc.setBalance(acc.getBalance().subtract(new BigDecimal(amount)));

		accountDao.updateAccount(acc);
	}

	@Override
	public void addAccount(Account account) {

	}

	@Override
	public void deleteAccount(int id) {

	}

}
