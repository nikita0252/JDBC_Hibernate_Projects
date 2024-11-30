package o2mUni;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Data {
	Scanner sc = new Scanner(System.in);

	public void insertData() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tr = session.beginTransaction();

		Bank b = new Bank();

		System.out.println("Insert Data Here..");
		System.out.println();
		System.out.println("Enter Bank ID: ");
		b.setBid(sc.nextInt());
		System.out.println("Enter Bank Name: ");
		b.setBname(sc.next() + sc.nextLine());
		System.out.println("Enter Branch Number: ");
		b.setNoofBranches(sc.nextInt());

		System.out.println("How much customer's data you want to add");
		int no = sc.nextInt();
		for (int i = 1; i <= no; i++) {

			Customer c = new Customer();
			System.out.println("Enter Customer ID:");
			c.setCid(sc.nextInt());
			System.out.println("Enter Customer Name:");
			c.setCname(sc.next());
			System.out.println("Enter Balance:");
			c.setBalance(sc.nextDouble());
			b.getC().add(c);

			session.persist(b);
			session.persist(c);

			System.err.println("Data inserted..");

		}
		tr.commit();

	}

	public void viewSingleData() 
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		System.out.println("Enter Bank Id");
		Bank b = s.get(Bank.class, sc.nextInt());
		System.out.println(b.getBid());
		System.out.println(b.getBname());
		System.out.println(b.getNoofBranches());
		Set<Customer> cs = b.getC();
		cs.forEach(a -> System.out.println(a.getCid() + "\n " + a.getCname() + "\n " + a.getBalance()));

	}
	
	public void viewAllData()
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		
		List<Bank> l = s.createQuery("from Bank").list();
		
		for(Bank b : l)
		{
			System.out.println(b.getBid());
			System.out.println(b.getBname());
			System.out.println(b.getNoofBranches());
			
			Set<Customer> cs = b.getC();
			cs.forEach(a -> System.out.println(a.getCid() + "\n " + a.getCname() + "\n " + a.getBalance()));
			
		}
	}
	
	public void updateData()
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tr = s.beginTransaction();
		
		System.out.println("Enter Bank ID for update..");
		Bank b = s.get(Bank.class, sc.nextInt());
		Customer c = new Customer();
		
		System.out.println("1.Bank Name Update");
		System.out.println("2.Branch Number Update");
		System.out.println("3.Customer Name Update");
		System.out.println("4.Customer Balance Update");

		System.out.println("Enter your Choice: ");
		int ch = sc.nextInt();
		
		switch (ch) {
		case 1:
			System.out.println("Enter updated Bank Name :");
			b.setBname(sc.next());
			break;
		case 2:
			System.out.println("Enter updated Branch Number :");
			b.setNoofBranches(sc.nextInt());
			break;
		case 3:
			System.out.println("Enter updated Customer Name :");
			c.setCname(sc.next());
			break;
		case 4:
			System.out.println("Enter updated Balance :");
			c.setBalance(sc.nextDouble());
			break;
	}
		
		s.persist(b);
		s.persist(c);
		tr.commit();
		
}
	
		public void deleteSingleData()
		{
			Session s = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction t = s.beginTransaction();
			
			System.out.println("Enter Bank ID:");
			Bank b = s.get(Bank.class, sc.nextInt());
			
			System.out.println(b.getBid());
			System.out.println(b.getBname());
			System.out.println(b.getNoofBranches());
			
			Customer c = new Customer();
			Set<Customer> cs = b.getC();
			cs.forEach(a-> System.out.println(a.getCid()+"\n "+a.getCname()+"\n"+a.getBalance()));
			
		}
		
		public void deleteAllData()
		{
			Session s = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction t = s.beginTransaction();
			
			List<Bank> l = 	s.createQuery("from Bank").list();
			
			for(Bank b : l)
			{
				System.out.println(b.getBid());
				System.out.println(b.getBname());
				System.out.println(b.getNoofBranches());
				
				Set<Customer> c = b.getC();
				c.forEach(a-> System.out.println(a.getCid()+" \n"+a.getCname()+"\n"+a.getBalance()));
			}
			
		}
}
