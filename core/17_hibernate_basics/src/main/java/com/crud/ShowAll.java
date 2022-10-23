package com.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.factory.HibernateSessionFactory;
import java.util.*;

public class ShowAll {

	public static void main(String[] args) {

		SessionFactory factory = HibernateSessionFactory.getSessionFactory();
		Session session = factory.openSession();

		session.close();
		factory.close();

	}

}
