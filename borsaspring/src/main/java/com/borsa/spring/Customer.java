package com.borsa.spring;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.aspectj.lang.annotation.Before;

@Entity
@Table(name="musteri",indexes = @Index(columnList = "name,surname"))
@SecondaryTable(name = "musteriex")
public class Customer {
	
	@Id
	@GeneratedValue
	private long custId;
	@Column(length = 30,nullable = false,unique = true)
	@Size(max = 30)
	private String name;
	private String surname;
	
	@Column(table = "musteriex")
	private int value1;
	@Column(table = "musteriex")
	private int value2;
	@Column(table = "musteriex")
	private int value3;
	@Column(table = "musteriex")
	private int value4;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private DemoData demoData;
	
	@Embedded
	private Address address;
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "customer")
	private List<Phone> phones;
	
	@PrePersist
	@PreRemove
	@PreUpdate
	public void before() {
	}
	
	@PostPersist
	@PostRemove
	@PostUpdate
	@PostLoad
	public void after() {
	}

	public int getValue1() {
		return value1;
	}

	public void setValue1(int value1) {
		this.value1 = value1;
	}

	public int getValue2() {
		return value2;
	}

	public void setValue2(int value2) {
		this.value2 = value2;
	}

	public int getValue3() {
		return value3;
	}

	public void setValue3(int value3) {
		this.value3 = value3;
	}

	public int getValue4() {
		return value4;
	}

	public void setValue4(int value4) {
		this.value4 = value4;
	}

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

	public long getCustId() {
		return custId;
	}

	public void setCustId(long custId) {
		this.custId = custId;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}
	
	
}
