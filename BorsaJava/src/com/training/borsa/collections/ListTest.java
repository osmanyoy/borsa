package com.training.borsa.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ListTest {
	public static void main(String[] args) {
		List<String> strList = new ArrayList<>(1_000_000);
		long currentTimeMillis = System.currentTimeMillis();
		for (int i = 0; i < 1_000_000; i++) {
			strList.add("Osman" + i);
		}
		System.out.println("Add Delta : "  + (System.currentTimeMillis() - currentTimeMillis));

		currentTimeMillis = System.currentTimeMillis();
		for (int i = 0; i < 100_000; i++) {
			strList.get(i);
		}
		System.out.println("Get Delta : "  + (System.currentTimeMillis() - currentTimeMillis));

		currentTimeMillis = System.currentTimeMillis();
		for (int i = 0; i < 100_000; i++) {
			strList.remove(1);
		}
		System.out.println("Remove Delta : "  + (System.currentTimeMillis() - currentTimeMillis));
		
		List<String> synchronizedList = Collections.synchronizedList(strList);
		
	}
}
