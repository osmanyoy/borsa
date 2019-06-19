package com.training.borsa;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class FirstClass {
	public static void main(String[] args) {
		System.out.println("Hello World");
		
		// Normal 
		SecondClass class1 = new SecondClass();
		class1.setName("Osman");
		class1.hello();
		
		Class<SecondClass> clsObj =  SecondClass.class;
		
		try {
			SecondClass newInstance = clsObj.newInstance();
			Field[] declaredFields = clsObj.getDeclaredFields();
			for (Field field : declaredFields) {
				if (field.getName().equals("name")) {
					field.setAccessible(true);
					field.set(newInstance, "Osman");
				}
			}
			
			Method[] methods = clsObj.getMethods();
			for (Method method : methods) {
				if (method.getName().equals("hello")) {
					method.invoke(newInstance, null);
				}
			}
			
			Method method = clsObj.getMethod("hello", null);
			method.invoke(newInstance, null);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
