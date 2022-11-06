package com.bankapp.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.dao.AccountDao;
import com.bankapp.dto.AccountDetailsDto;
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
		return accountDao.findAll();
	}

	@Override
	public Account getById(int id) {
		return accountDao.findById(id)
				.orElseThrow(()-> new BankAccountNotFoundException("account with id" + id +" is not found"));
	}

	@Override
	public void transfer(int fromAccId, int toAccId, double amount) {
		Account fromAcc = getById(fromAccId);
		Account toAcc = getById(toAccId);

		fromAcc.setBalance(fromAcc.getBalance().subtract(new BigDecimal(amount)));
		toAcc.setBalance(toAcc.getBalance().add(new BigDecimal(amount)));

		accountDao.save(fromAcc);
		accountDao.save(toAcc);

		if (emailService != null) {
			emailService.sendEmail("amit@gmail.com", "fund is transfer successfully!");
		}

	}

	@Override
	public void deposit(int id, double amount) {
		Account acc = getById(id);

		acc.setBalance(acc.getBalance().add(new BigDecimal(amount)));

		accountDao.save(acc);

	}

	@Override
	public void withdraw(int id, double amount) {
		Account acc = getById(id);

		acc.setBalance(acc.getBalance().subtract(new BigDecimal(amount)));

		accountDao.save(acc);
	}

	@Override
	public Account addAccount(Account account) {
		accountDao.save(account);
		return account;
	}

	@Override
	public void deleteAccount(int id) {

		Account accountToDelete= getById(id);
		accountDao.delete(accountToDelete);
	}

	@Override
	public Account updateAccountDetails(int id, AccountDetailsDto accountDetailsDto) {
		Account accountToUpdate= getById(id);
		if(accountToUpdate!=null) {
			accountToUpdate.setPhone(accountDetailsDto.getPhone());
			accountToUpdate.setEmail(accountDetailsDto.getEmail());
			accountDao.save(accountToUpdate);
		}
		return accountToUpdate;
		
	}

}
