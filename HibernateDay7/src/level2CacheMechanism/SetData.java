package level2CacheMechanism;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.*;

public class SetData 
{
	public static void main(String[] args) {
		
	
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tr = s.beginTransaction();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("How many student's data you want to add:");
		int no = sc.nextInt();
		
		for(int i = 1; i<= no; i++)
		{
		Student s1 = new Student();
		System.out.println("Enter Roll no:");
		s1.setRollno(sc.nextInt());
		System.out.println("Enter Name:");
		s1.setName(sc.next());
		
		s.persist(s1);
		}
		tr.commit();
		
	}
}
