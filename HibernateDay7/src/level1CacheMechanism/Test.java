package level1CacheMechanism;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jboss.jandex.Main;



public class Test 
{
	public static void main(String[] args) 
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tr = session.beginTransaction();
		
		Session s1 = HibernateUtil.getSessionFactory().openSession();
		Student s=s1.get(Student.class, 1);
		System.out.println(s.getRollno());
		System.out.println(s.getName());
		
		Student st=s1.get(Student.class, 2);
		
		System.out.println(st.getRollno());
		System.out.println(st.getName());
		
//		Student st1=s1.get(Student.class, 1);
		
		
		Session s2=HibernateUtil.getSessionFactory().openSession();
		Student st2=s2.get(Student.class, 2);
		System.out.println(st.getRollno());
		System.out.println(st.getName());
		
		
		
	}

}
