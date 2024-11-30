package com.onetoone;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity

public class Person 
{
	@Id
	private int pid;
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	private AdharCard ad;
	
	public AdharCard getAd() {
		return ad;
	}
	public void setAd(AdharCard ad) {
		this.ad = ad;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
