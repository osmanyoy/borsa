package com.training.borsa.jmx;

public class Test implements TestMBean {
 
    private String name;
    private String surname;

    @Override
    public String method1(String str) {
        String x = "method1 " + name + " " + getSurname() + " called for " + str;
		System.out.println(x);
		return x;
    }

    @Override
    public void method2(String str) {
        System.out.println("method2 " + name + " " + getSurname() + " called for " + str);
    }

    @Override
    public String getName() {
    	System.out.println("Return Name " + this.name);
        return name;
    }

    @Override
    public void setName(String playerName) {
    	System.out.println("Set Name to value " + playerName);
        this.name = playerName;
    }

    @Override
    public String getSurname() {
		return surname;
	}

    @Override
    public void setSurname(String surname) {
		this.surname = surname;
	}
}