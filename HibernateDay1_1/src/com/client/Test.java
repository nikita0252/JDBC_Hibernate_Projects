package com.client;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.config.HibernateUtil;
import com.connect.Connect;
import com.model.Developer;
import java.util.*;

public class Test 
{
	Scanner sc = new Scanner(System.in);

	public void insertData() {
		Session session = Connect.getSession();

		System.out.println("How many Developer's data you want to add");
		int no = sc.nextInt();

		for (int i = 1; i <= no; i++) {

			Developer d = new Developer();

			System.out.println("Enter Id:");
			d.setId(sc.nextInt());
			System.out.println("Enter Name:");
			d.setName(sc.next());
			System.out.println("Enter Mobile No:");
			d.setMobno(sc.nextLong());
			System.out.println("Enter Company Name:");
			d.setCompany(sc.next());
			System.out.println("Enter Experience:");
			d.setExperience(sc.nextFloat());
			
			System.out.println("Enter Salary:");
			d.setSalary(sc.nextDouble());

			session.persist(d);
			session.beginTransaction().commit();
		}

	}

	public void updataeData() {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();

			System.out.println("Enter Id of Developer");
			Developer d = session.get(Developer.class, sc.nextInt());

			System.out.println("1.Salary Update");
			System.out.println("2.Mobile Number Update");
			System.out.println("3.Compnay Update");
			System.out.println("4.Experience Update");

			System.out.println("Enter your Choice: ");
			int ch = sc.nextInt();

			switch (ch) {
			case 1:
				System.out.println("Enter updated Salary :");
				d.setSalary(sc.nextDouble());
				break;
			case 2:
				System.out.println("Enter updated MobileNo :");
				d.setMobno(sc.nextLong());
				break;
			case 3:
				System.out.println("Enter updated Company :");
				d.setCompany(sc.next());
				break;
			case 4:
				System.out.println("Enter updated Experience :");
				d.setExperience(sc.nextFloat());
				break;

			}
			session.persist(d);
			session.beginTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Data updated");
	}

	public void retrive() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			System.out.println("Enter Id of Developer");
			int id = sc.nextInt();
			Developer d = session.get(Developer.class, id);

			//System.out.println(d.getId());
			//System.out.println(d.getName());
		} catch (Exception e) {
			System.err.println("Data not found");
		}
	}
	
	public void delete()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			System.out.println("Enter Id of Developer which you want to delete");
			int id    = sc.nextInt();
			Developer d = session.get(Developer.class, id);
			 
			//System.out.println(d.getId());
			
			session.delete(d);
			session.beginTransaction().commit();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("Data deleted..");
		}

	public static void main(String args[]) 
	{
		Test t = new Test();
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
		System.out.println("1.Insert Data: ");
		System.out.println("2.Update Data: ");
		System.out.println("3.Retrive Data: ");
		System.out.println("4.Delete Data: ");

		System.out.println("Enter your Choice: ");
		int ch = sc.nextInt();

		switch (ch) 
		{
		case 1:
			t.insertData();
			break;
			
		case 2:
			t.updataeData();
			break;
			
		case 3:
			t.retrive();
			break;
			
		case 4:
			t.delete();
			break;
			
		default :
			System.out.println("Exit");
		


	}
	}
	}
}
