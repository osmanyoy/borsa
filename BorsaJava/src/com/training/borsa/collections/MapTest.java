package com.training.borsa.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import com.training.borsa.reflection.PropObject1;
import com.training.borsa.reflection.exp.Person;

public class MapTest {
	public static void main(String[] args) {
		Map<String, Person> myPersons = new HashMap<>();
		Map<PropObject1, Person> myPersons2 = new HashMap<>();
		
		Map<String, Person> myPersonsCon = new ConcurrentHashMap<>(1_000_000,0.9f,1_000);
		
		Collection<Person> values = myPersonsCon.values();
		for (Person person : values) {
			
		}
		
		Set<PropObject1> keySet = myPersons2.keySet();
		for (PropObject1 propObject1 : keySet) {
			Person person = myPersons2.get(propObject1);
		}
		
		Set<Entry<String, Person>> entrySet = myPersons.entrySet();
		for (Entry<String, Person> entry : entrySet) {
			String key = entry.getKey();
			Person value = entry.getValue();
		}

	}
}
