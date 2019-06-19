package com.training.borsa.collections;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
	public static void main(String[] args) {
		Set<String> set1 = new HashSet<>();
		set1.add("osman1");
		set1.add("osman2");
		set1.add("osman3");
		set1.add("osman4");
		Set<String> set2 = new HashSet<>();
		set2.add("osman2");
		set2.add("osman3");
		set2.add("osman4");
		set2.add("osman5");
		
		set2.removeAll(set1);
		System.out.println(set2);
		
	}
}
