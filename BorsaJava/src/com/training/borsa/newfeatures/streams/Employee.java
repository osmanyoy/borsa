package com.training.borsa.newfeatures.streams;

public class Employee{
	private String name;
	private String surname;
	private int weight;
	private int height;
	private int age;
	private EGender gender;
	
	public Employee() {
	}
	
	public Employee(String name, String surname, int weight, int height, int age, EGender gender) {
		super();
		this.name = name;
		this.surname = surname;
		this.weight = weight;
		this.height = height;
		this.age = age;
		this.gender = gender;
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
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public EGender getGender() {
		return gender;
	}
	public void setGender(EGender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", surname=" + surname + ", weight=" + weight + ", height=" + height
				+ ", age=" + age + ", gender=" + gender + "]";
	}
	
	
	
}
