package com.crud;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.factory.HibernateSessionFactory;

public class Delete {

	public static void main(String[] args) {

		SessionFactory factory = HibernateSessionFactory.getSessionFactory();
		Session session = factory.openSession();
		
		Transaction tx=session.getTransaction(); //:(
		try {
			
			tx.begin();
			
			Account account1=session.get(Account.class, 6);
			
					
					
			session.delete(account1);
			
			tx.commit();
			
		}catch(HibernateException ex) {
			
			tx.rollback();
		}
		
		session.close();
		factory.close();

	}

}
