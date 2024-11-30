package com.client;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.config.HibernateUtil;
import com.model.Student;

public class Test 
{
	public static void main(String[] args) 
	{
		Student s = new Student();
		s.setRollno(101);
		s.setName("nikita");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction tx = session.beginTransaction();
		session.persist(s);
		tx.commit();
		
		
	}

}
