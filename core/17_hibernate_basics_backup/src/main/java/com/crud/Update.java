package com.crud;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.factory.HibernateSessionFactory;

public class Update {

	public static void main(String[] args) {

		SessionFactory factory = HibernateSessionFactory.getSessionFactory();
		Session session = factory.openSession();
		
		Transaction tx=session.getTransaction(); //:(
		try {
			
			tx.begin();
			
			Account account1=session.get(Account.class, 5);
			account1.setBalance(account1.getBalance()+100);
			session.update(account1);
			
			tx.commit();
			
		}catch(HibernateException ex) {
			
			tx.rollback();
		}
		
		session.close();
		factory.close();

	}

}
