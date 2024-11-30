package o2mUni;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.*;

@Entity
public class Bank 
{
	@Id
	private int bid;
	private String bname;
	private int noofBranches;
	
	@OneToMany(cascade=CascadeType.ALL)
	private Set<Customer> c = new HashSet<>();

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public int getNoofBranches() {
		return noofBranches;
	}

	public void setNoofBranches(int noofBranches) {
		this.noofBranches = noofBranches;
	}

	public Set<Customer> getC() {
		return c;
	}

	public void setC(Set<Customer> c) {
		this.c = c;
	}

	


}
