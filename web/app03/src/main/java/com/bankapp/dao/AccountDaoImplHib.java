package com.bankapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
@Repository
@Primary
public class AccountDaoImplHib implements AccountDao {

	private SessionFactory sessionFactory;
	
	@Autowired
	public AccountDaoImplHib(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	//helper method
	private Session getSession() {
		return sessionFactory.getCurrentSession(); //getCurrentSession vs openSession
	}
	
	@Override
	public List<Account> getAll() {
		return getSession().createQuery("select a from Account a", Account.class).getResultList();
	}

	@Override
	public Account getById(int id) {
		return getSession().find(Account.class, id);
	}

	@Override
	public void updateAccount(Account account) {
		getSession().merge(account);
	}

	@Override
	public void addAccount(Account account) {
		getSession().save(account);
	}

	@Override
	public void deleteAccount(int id) {
		Account accountToDelete= getById(id);
		if(accountToDelete!=null) {
			getSession().delete(accountToDelete);
		}
	}

}
