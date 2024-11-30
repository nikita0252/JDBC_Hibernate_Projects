package m2m;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Student 
{
	@Id
	private int sid;
	private String sname;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Course> c = new HashSet<>();
}
