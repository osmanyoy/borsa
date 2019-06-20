package com.borsa.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("xyz")
public class MyObject2 implements IMyIntf{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void execute(String str) {
		System.out.println("Hello : " + str);
		
	}
	
}
