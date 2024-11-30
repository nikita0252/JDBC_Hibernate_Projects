package m2m;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Bank
{
	@Id
	private int bid;
	private String bname;
	private int branchno;
	
	@ManyToMany(cascade = CascadeType.ALL)
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

	public int getBranchno() {
		return branchno;
	}

	public void setBranchno(int branchno) {
		this.branchno = branchno;
	}

	public Set<Customer> getC() {
		return c;
	}

	public void setC(Set<Customer> c) {
		this.c = c;
	}
	
	

}
