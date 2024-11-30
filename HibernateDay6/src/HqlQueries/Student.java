package HqlQueries;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student 
{
	@Id
	private int sid;
	private String sname;
	private long mobno;
	private String add;
	
	
	
}
