package com.onetoone;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AdharCard 
{
	@Id
	
	private int aid;
	private String adharname;
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAdharname() {
		return adharname;
	}
	public void setAdharname(String adharname) {
		this.adharname = adharname;
	}
	
	
}
