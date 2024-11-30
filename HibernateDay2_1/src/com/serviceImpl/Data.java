package com.serviceImpl;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.service.*;
import com.config.*;
import com.model.Address;
import com.model.User;
import java.util.*;

public class Data implements Requirement
{

	Scanner sc = new Scanner(System.in);
	
	@Override
	public void insertData() 
	{
		try
		{
		 
		System.out.println("How many User's data you want to add");
		int no = sc.nextInt();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tr = session.beginTransaction();
		for(int i=1; i<=no; i++)
		{
			Address ad = new Address();
			User u = new User();
		System.out.println("Enter Id:");
		u.setId(sc.nextInt());
		System.out.println("Enter Name:");
		u.setName(sc.next());
		System.out.println("Enter Mobile no:");
		u.setMobno(sc.nextLong());
		System.out.println("Enter Gender:");
		u.setGender(sc.next());
		System.out.println("Enter GmailId:");
		u.setEmailId(sc.next());
		u.setAdr(ad);
		System.out.println("Enter PIN Code:");
		ad.setPincode(sc.nextInt());
		System.out.println("Enter City Name:");
		ad.setCity(sc.next());
		System.out.println("Enter Area Name:");
		ad.setArea(sc.next());
		
		session.persist(u);
		}
		tr.commit();
		System.out.println("Data Inserted..");
		
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void viewSingleData() 
	{
		try
		{
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		System.out.println("Enter Id for viewSingleData:");
		int id = sc.nextInt();
		
		User u = session.get(User.class, id);
		
		System.out.println(u.getId());
		System.out.println(u.getName());
		System.out.println(u.getMobno());
		System.out.println(u.getEmailId());
		System.out.println(u.getGender());
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void viewAllData()
	{
		try
		{
			Session s  = HibernateUtil.getSessionFactory().openSession();
				
			List<User> al = s.createQuery("from User").list();
			
				for(User u : al)
				{
					System.out.println(u.getId());
					System.out.println(u.getName());
					System.out.println(u.getMobno());
					System.out.println(u.getEmailId());
					System.out.println(u.getGender());
				}
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void updateData() {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();

			System.out.println("Enter Id of Developer");
			User u = session.get(User.class, sc.nextInt());
			Address ad = new Address();

			System.out.println("1.Mobile Number Update");
			System.out.println("2.Gmail ID Update");
			System.out.println("3.City Name Update");
			System.out.println("4.Area Name Update");

			System.out.println("Enter your Choice: ");
			int ch = sc.nextInt();

			switch (ch) {
			case 1:
				System.out.println("Enter updated Mobile Number :");
				u.setMobno(sc.nextLong());
				break;
			case 2:
				System.out.println("Enter updated Gmail Id :");
				u.setEmailId(sc.next());
				break;
			case 3:
				System.out.println("Enter updated City Name :");
				u.setAdr(ad);
				break;
			case 4:
				System.out.println("Enter updated Area Name :");
				u.setAdr(ad);
				break;

			}
			session.persist(u);
			session.beginTransaction().commit();
		} 
			catch (Exception e) 
		{
			e.printStackTrace();
		}

		System.out.println("Data updated");
		
	}

	@Override
	public void deleteSingleData()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			System.out.println("Enter Id of Developer which you want to delete");
			int id    = sc.nextInt();
			User u = session.get(User.class, id);
			 
			//System.out.println(d.getId());
			
			session.delete(u);
			session.beginTransaction().commit();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("Data deleted..");
		}
		

	@Override
	public void deleteAllData() 
	{
		try
		{
			Session s = HibernateUtil.getSessionFactory().openSession();
			Transaction tr = s.beginTransaction();
			List<User> al = s.createQuery("from User").list();
			
		for(User u : al)
			{
				s.delete(u);
			}
			tr.commit();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		
	
			
			
			
			
			
		}
		
		
	
}
