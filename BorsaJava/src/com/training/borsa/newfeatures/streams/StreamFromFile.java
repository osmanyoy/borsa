package com.training.borsa.newfeatures.streams;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFromFile {
	public static void main(String[] args) {
		try (Stream<String> lineStream = Files.lines(Paths.get("test.txt"))) {
			Map<String, Employee> collect = lineStream.map(e -> e.split(","))
			          .map(g -> {
				          Employee employee = new Employee();
				          employee.setName(g[0]);
				          employee.setSurname(g[1]);
				          employee.setWeight(Integer.parseInt(g[2]));
				          employee.setHeight(Integer.parseInt(g[3]));
				          employee.setAge(Integer.parseInt(g[4]));
				          return employee;
			          })
			          .collect(Collectors.toMap(e -> e.getName() + "_" + e.getSurname(), Function.identity()));
			System.out.println(collect);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
