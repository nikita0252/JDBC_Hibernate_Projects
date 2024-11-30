package m2oUni;

import org.hibernate.Session;
import org.hibernate.Transaction;

import o2mUni.HibernateUtil;

public class Test 
{
	public static void main(String[] args) 
	{
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tr = s.beginTransaction();
		
		Employee e = new Employee();
		e.setEid(111);
		e.setEname("niiki"); 
		Employee e1 = new Employee();
		e1.setEid(112);
		e1.setEname("gita");
		
		Department hr = new Department();
		hr.setDid(1);
		hr.setDname("HR");
		
		e.setD(hr);
		e1.setD(hr);
		
		s.persist(e);
		s.persist(e1);
		
		tr.commit();
		
	}

}
