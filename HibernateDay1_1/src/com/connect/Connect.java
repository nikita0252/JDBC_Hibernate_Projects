package com.connect;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.config.HibernateUtil;

public class Connect {

	public static Session getSession() {

		Session session = HibernateUtil.getSessionFactory().openSession();

		return session;
	}
}
