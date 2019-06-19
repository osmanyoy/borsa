package com.training.borsa.newfeatures;

import java.util.function.Predicate;

public class MainJavaIntf {
	public static void main(String[] args) {
		Predicate<Person> ttPredicate0 = Person::isBoltest;
		Predicate<Person> ttPredicate1 = p-> p.isBoltest();
		
		Predicate<Person> ttPredicate = p -> p.getName().isEmpty();
		ttPredicate.and(p -> p.getSurname().isEmpty()).or(p -> p == null);
	}
}
