package com.training.borsa.reflection.exp;

import java.lang.reflect.Field;

public class PersonManu {
	
	public static void main(String[] args) {
		PersonManu manu = new PersonManu();
		Person person = new Person();
		person.setName("Osman");
		person.setGender(1);
		manu.change(person);
	}
	
	public Person change(Person person) {
		Class<Person> class2= Person.class;
		Class<? extends Person> class1 = person.getClass();
		try {
			Field field = class1.getDeclaredField("gender");
			Field nameField = class1.getDeclaredField("name");
			int gender = field.getInt(person);
			String strName = (String)nameField.get(person);
			
			switch (gender) {
			case 1:
				strName = "Bay " + strName;
				break;
			case 2:
				strName = "Bayan " + strName;
				break;

			default:
				break;
			}
			nameField.set(person, strName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return person;
	}
}
