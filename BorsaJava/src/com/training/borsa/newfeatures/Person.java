package com.training.borsa.newfeatures;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
// @XmlType(propOrder = )
public class Person {
	@Override
	public String toString() {
		return "Person [name=" + name + ", surname=" + surname + ", boltest=" + boltest + "]";
	}
	@XmlElement(name = "xzy",required = true,nillable = false)
	private String name;
	private String surname;
	private boolean boltest;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public boolean isBoltest() {
		return boltest;
	}
	public void setBoltest(boolean boltest) {
		this.boltest = boltest;
	}
	
}
