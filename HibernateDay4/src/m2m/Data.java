package m2m;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.*;

public class Data 
{
	Scanner sc = new Scanner(System.in);
	public void insertData()
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tr = s.beginTransaction();
		
		Bank b = new Bank();
		
		 
		System.out.println("Enter the ID of Bank:");
		b.setBid(sc.nextInt());
		System.out.println("Enter Name of Bank:");
		b.setBname(sc.next());
		System.out.println("Enter No of Branch:");
		b.setBranchno(sc.nextInt());
		 
		System.out.println("How much customer's data you want to add:");
		int no = sc.nextInt();
		for(int i=1; i<=no; i++ )
		{
		Customer c = new Customer();
		System.out.println("Enter ID of Customer:");
		c.setCid(sc.nextInt());
		System.out.println("Enter Name of Customer:");
		c.setCname(sc.next());
		
		b.getC().add(c);
		
		s.persist(b);
		s.persist(c);

		}
		tr.commit();
		System.out.println("Data inserted..");
			
		}
	    
		public void viewSingleData()
		{
			Session s = HibernateUtil.getSessionFactory().openSession();
			
			System.out.println("1.Bank Data:");
			System.out.println("2.Customer Data:");
			System.out.println("Which Data you want to view \n Enter Choice:");
			int ch = sc.nextInt();
			System.out.println("Enter Id of Bank:");
		    Bank b = s.get(Bank.class, sc.nextInt());
			switch(ch)
			{
			case 1 :
				
				System.out.println(b.getBid());
				System.out.println(b.getBname());
				System.out.println(b.getBranchno());
				break;
				
			case 2 :
				Customer c = new Customer();
				System.out.println("Enter Id of Customer:");
				c.setCid(sc.nextInt());
//				b = s.get(Bank.class, sc.nextInt());
				Set<Customer> cs = b.getC();
				cs.forEach(a-> System.out.println(a.getCid()+ " \n"+ a.getCname()+ "\n"));
				break;
			}
			
		}
		
		public void viewAllData()
		{
			Session s = HibernateUtil.getSessionFactory().openSession();
			
			List<Bank> l = s.createQuery("from Bank").list();
			
			for(Bank b : l)
			{
				System.out.println(b.getBid());
				System.out.println(b.getBname());
				System.out.println(b.getBranchno());
			
			Set<Customer> cs = b.getC();
			cs.forEach(a -> System.out.println(a.getCid() + " \n"+ a.getCid()));
		    
			}
		}
	}


