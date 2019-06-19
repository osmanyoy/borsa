package com.training.borsa.reflection;

@PropFile(fileName = "myprop2.properties")
public class PropObject2 {
	@Prop(name = "server.test")
	private String test;
	@Prop(name = "server.mest")
	private String mest;
	@Prop(name = "server.cest")
	private int cest;
	
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	public String getMest() {
		return mest;
	}
	public void setMest(String mest) {
		this.mest = mest;
	}
	public int getCest() {
		return cest;
	}
	public void setCest(int cest) {
		this.cest = cest;
	}
	@Override
	public String toString() {
		return "PropObject2 [test=" + test + ", mest=" + mest + ", cest=" + cest + "]";
	}
	
	
}
