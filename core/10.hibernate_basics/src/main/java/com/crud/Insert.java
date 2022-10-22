package com.crud;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.factory.HibernateSessionFactory;

public class Insert {

	public static void main(String[] args) {

		SessionFactory factory = HibernateSessionFactory.getSessionFactory();
		Session session = factory.openSession();
		
		Transaction tx=session.getTransaction(); //:(
		try {
			
			tx.begin();
			
			Account account1=new Account("kesav", 2000.0);
			Account account2=new Account("ravi", 2000.0);
			Account account3=new Account("ganga", 2000.0);
			
			session.save(account1);
			session.save(account2);
			session.save(account3);
			
			tx.commit();
			
		}catch(HibernateException ex) {
			
			tx.rollback();
		}
		
		session.close();
		factory.close();

	}

}
