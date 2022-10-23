package com.crud;
import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.factory.HibernateSessionFactory;
import java.util.*;

public class B_ShowAll {

	public static void main(String[] args) {

		SessionFactory factory = HibernateSessionFactory.getSessionFactory();
		Session session = factory.openSession();

		//want to show all accounts, SQL vs HQL
//		List<Account> accounts=
//				session.createQuery("select a from Account a", Account.class).getResultList();
//		
//		accounts.forEach(a-> System.out.println(a));
		
//		List<String> accountsName=
//				session.createQuery("select a.name from Account a", String.class).getResultList();
//		
//		accountsName.forEach(name-> System.out.println(name));
		
//		List<Object[]> objects=
//				session.createQuery("select a.id, a.name from Account a", Object[].class).getResultList();
//		
//		for(Object o[]: objects) {
//			System.out.println(o[0]+": "+ o[1]);
//		}
		
		List<AccountData> accountDatas=
				session.createQuery("select new com.crud.AccountData(a.id, a.name) from Account a", AccountData.class).getResultList();
		
		accountDatas.forEach(ad-> System.out.println(ad));
		
		session.close();
		factory.close();

	}

}
