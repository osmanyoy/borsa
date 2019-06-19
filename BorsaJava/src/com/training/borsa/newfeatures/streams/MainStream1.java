package com.training.borsa.newfeatures.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainStream1 {
	public static void main(String[] args) {
		List<String> asList = Arrays.asList("Osman1", "mehmet1", "ali1", "t1", "b1");
		// Old
		List<String> sonucList = new ArrayList<>();
		for (String string : asList) {
			if (string.length() == 2) {
				sonucList.add(string);
			}
		}
		System.out.println(sonucList);

		// Yeni
		asList.stream()
		      .filter(s -> s.length() == 2)
		      .forEach(System.out::println);

		Stream<String> stream = asList.stream();
		Stream<String> filter = stream.filter(s -> s.length() == 2);

		List<Employee> employeeList = Arrays.asList(new Employee("osman", "yay", 92, 200, 49, EGender.MALE),
		        new Employee("mehmet", "yay", 80, 180, 30, EGender.MALE), new Employee("Ayþe", "yay", 48, 160, 25,
		                EGender.FEMALE), new Employee("Ali", "yay", 77, 140, 45, EGender.MALE), new Employee("Didem",
		                        "yay", 55, 170, 30, EGender.FEMALE));

		Map<String, Employee> empMap = new HashMap<>();
		employeeList.stream()
		            .filter(p -> {
			            System.out.println("Filter : " + p);
			            return (p.getAge() > 30);
		            })
		            .forEach(o -> {
			            System.out.println("ForEach : " + o);
			            empMap.put(o.getName(), o);
		            });

		long count = employeeList.stream()
		                         .filter(p -> {
			                         System.out.println("Filter : " + p);
			                         return (p.getAge() > 30);
		                         })
		                         .count();
		System.out.println("----------------------------------");
		employeeList.stream()
		            .filter(p -> {
			            System.out.println("Filter : " + p);
			            return (p.getAge() > 30);
		            })
		            .map(q -> q.getWeight())
		            .forEach(System.out::println);

		System.out.println("-----------Reduce-----------------------");
		Integer reduce = employeeList.stream()
		                             .filter(p -> {
			                             return (p.getAge() > 30);
		                             })
		                             .map(q -> q.getWeight())
		                             .reduce(0, (a, b) -> a + b);
		System.out.println("Total Weight : " + reduce);

		System.out.println("-----------Reduce-----------------------");
		Employee reduce2 = employeeList.stream()
		                               .filter(p -> {
			                               return (p.getAge() > 30);
		                               })
		                               .reduce(new EmployeePlus(), (a, b) -> {
			                               EmployeePlus employeePlus = (EmployeePlus) a;
			                               employeePlus.addEmployee(b);
			                               return employeePlus;
		                               });

		System.out.println("Total Weight : " + reduce2);

		System.out.println("-----------Collect-----------------------");
		employeeList.stream()
		            .filter(p -> {
			            return (p.getAge() > 30);
		            })
		            .peek(k -> k.setName(k.getName() + " peeked"));
		// .skip(1)
//		            .distinct()
//		            .limit(10)
//		            .sorted((o1,o2) -> o1.getAge() - o2.getAge())
//		            .sorted()
//		            .allMatch(o-> o.getHeight() > 190);
//		            .findAny()
//		            .findFirst()
//		            .collect(Collectors.toList());

		System.out.println("-----------Collect-----------------------");
		LinkedList<Employee> collect = employeeList.stream()
		                                           .filter(p -> {
			                                           return (p.getAge() > 30);
		                                           })
		                                           .peek(k -> k.setName(k.getName() + " peeked"))
		                                           .collect(Collectors.toCollection(LinkedList::new));

		System.out.println("-----------Collect-----------------------");
		Map<String, Employee> collect2 = employeeList.stream()
		                                             .filter(p -> {
			                                             return (p.getAge() > 30);
		                                             })
		                                             .peek(k -> k.setName(k.getName() + " peeked"))
		                                             .collect(Collectors.toMap(Employee::getName, Function.identity()));

		int sum = employeeList.stream()
		                      .filter(p -> {
			                      return (p.getAge() > 30);
		                      })
		                      .mapToInt(Employee::getAge)
		                      .sum();

		List<String> charExp = Arrays.asList("osman", "mosman", "ali", "veli", "osman");
		charExp.stream()
		       .map(s -> s.split(""))
		       .flatMap(Arrays::stream)
		       .distinct()
		       .forEach(System.out::println);
	}

	public static class EmployeePlus extends Employee {
		private List<Employee> employees = new ArrayList<>();

		public void addEmployee(Employee emp) {
			employees.add(emp);
		}
	}
}
