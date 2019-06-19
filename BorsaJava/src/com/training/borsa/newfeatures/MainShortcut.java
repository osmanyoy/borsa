package com.training.borsa.newfeatures;

public class MainShortcut {
	public static void main(String[] args) {
		Person person = new Person();
		person.setName("Osman");
		person.setSurname("Yay");
		
		shortcut(p -> p.getName(), person);
		shortcut(Person::getName, person);

	}
	
	public static String shortcut(ILambdaShortcut shortcut, Person person) {
		return shortcut.abcd(person);
	}
}
