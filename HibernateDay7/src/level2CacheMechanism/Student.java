package level2CacheMechanism;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Entity
public class Student 
{
	@Id
	private int rollno;
	private String name;
	
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
