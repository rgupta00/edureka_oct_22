package com.crud;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.factory.HibernateSessionFactory;

public class D_Delete {

	public static void main(String[] args) {

		SessionFactory factory = HibernateSessionFactory.getSessionFactory();
		Session session = factory.openSession();

		Transaction tx = session.getTransaction(); // :(
		try {

			tx.begin();

			Account account = session.get(Account.class, 1);

			// update the bal
			if (account != null) {
				session.delete(account);
			}

			tx.commit();

		} catch (HibernateException ex) {

			tx.rollback();
		}

		session.close();
		factory.close();

	}

}
