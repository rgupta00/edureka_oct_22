package com.demo;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Tester {

	public static void main(String[] args) {

		//SessionFactory==EntityManagerFactory
		//Session=EntityManager
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("foo");

		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			Account account=new Account("ravi", 4000.00);
			em.persist(account);
			tx.commit();
		} catch (Exception e) {
			System.out.println(e);
			tx.rollback();
		}

		em.close();
		emf.close();
	}
}
