package o2mUni;

import org.hibernate.Session;

public class Test 
{
	public static void main(String[] args) 
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		
		Employee e = new Employee();
		
		e.setEid(1);
		e.setEname("niki");
		
		Employee e1 = new Employee();
		e1.setEid(2);
		e1.setEname("sans");
		
		Department d = new Department();
		d.setDid(11);
		d.setDname("HR");
		 
		d.getE().add(e1);
		d.getE().add(e);
		
		s.persist(d);
		s.beginTransaction().commit();
		
		
	}

}
