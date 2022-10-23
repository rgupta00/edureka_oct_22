package com.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.factory.HibernateSessionFactory;
import java.util.*;

public class ShowAll {

	public static void main(String[] args) {

		SessionFactory factory = HibernateSessionFactory.getSessionFactory();
		Session session = factory.openSession();

		List<AccountData> accountsAccountDatas = session
				.createQuery("select new com.crud.AccountData( a.name, a.balance) from Account a", AccountData.class)
				.getResultList();
			
		//need to just print it
		for (AccountData accountData : accountsAccountDatas) {
			System.out.println(accountData);
		}
//
//		List<Object[]> accountsHolderNames=session.createQuery("select a.name, a.balance from Account a",
//				Object[].class).getResultList();
//		//need to just print it
//		for(Object[] data: accountsHolderNames) {
//			System.out.println(data[0]+" : "+ data[1]);
//		}

//		List<String> accounts = session.createQuery("select a.name from Account a", String.class).getResultList();
//		// need to just print it
//		for (String account : accounts) {
//			System.out.println(account);
//		}
		
		
		
		//jdbc : quaries SQL are not poratable :(==> JPQL or HQL
//		List<Account> accounts = session.createQuery("select a from Account a", Account.class).getResultList();
//		// need to just print it
//		for (Account account : accounts) {
//			System.out.println(account);
//		}
		session.close();
		factory.close();

	}

}
