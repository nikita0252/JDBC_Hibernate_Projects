package com.model;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test 
{
	public static void main(String[] args)
	{
		
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Employee e = new Employee();
		e.setEmpid(101);
		e.setEmpname("abc");
		
		Employee e1 = new Employee();
		e1.setEmpid(102);
		e1.setEmpname("pqr");
		
		Department d = new Department();
		d.setDid(1);
		d.setDname("Hr");
		
		d.getE().add(e);
		d.getE().add(e1);
		
		s.persist(d);
		tx.commit();
		
	}

}
