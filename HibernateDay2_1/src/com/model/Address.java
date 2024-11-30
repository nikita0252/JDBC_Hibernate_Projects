package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Address 
{
	@Id
	private int pincode;
	private String area;
	private String city;
	
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	

}
