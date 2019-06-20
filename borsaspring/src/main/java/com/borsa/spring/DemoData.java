package com.borsa.spring;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DemoData {
	
	@Id
	@GeneratedValue
	private long ddId;
	
	private String tc;
	private String gender;
	
	public String getTc() {
		return tc;
	}
	public void setTc(String tc) {
		this.tc = tc;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getDdId() {
		return ddId;
	}
	public void setDdId(long ddId) {
		this.ddId = ddId;
	}
	
}
