package com.onetoone;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.config.HibernateUtil;



public class Test 
{
	public static void main(String[] args) 
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		AdharCard adh = new AdharCard();
		adh.setAid(101);
		adh.setAdharname("nikita");
		
		Person p = new Person();
		p.setPid(1);
		p.setName("niki");
		p.setAd(adh);
		
		
		
		session.persist(p);
		tx.commit();
		
		
		
		
	}

}
