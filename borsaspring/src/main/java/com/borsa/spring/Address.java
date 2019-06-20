package com.borsa.spring;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	private String city;
	private String town;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	
}
