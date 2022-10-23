package com.crud;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.factory.HibernateSessionFactory;

public class A_Insert {

	public static void main(String[] args) {
		//SessionFactory
		//heavy object singleton, used to get the session object (main object in hiberate)
		
		//Session
		//session is a light wt object that wrap a jdbc connection and used to do crud operation
		//it act as a  container to manage life cycle of entity (pojo with some anno...)
		
		//SessionFactory --> Session
		
		SessionFactory factory=HibernateSessionFactory.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction tx= session.getTransaction();
		
		try {
			tx.begin();
			
			
			Account account=new Account("neetu", 5000.00);
			Account account2=new Account("pooja", 4000.00);
			
			session.save(account);
			session.save(account2);
			
			tx.commit();
		}catch(HibernateException ex) {
			tx.rollback();
		}
		
		
		session.close();
		
		factory.close();
	}

}


















