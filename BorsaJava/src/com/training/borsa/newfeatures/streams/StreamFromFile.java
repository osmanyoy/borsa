package com.training.borsa.newfeatures.streams;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFromFile {
	public static void main(String[] args) {
		try (Stream<String> lineStream = Files.lines(Paths.get("test.txt"))) {
			ForkJoinPool fk = ForkJoinPool.commonPool();
			System.out.println(fk.getParallelism());
			Map<String, Employee> collect = lineStream.parallel().filter(r -> {System.out.println(Thread.currentThread().getName()); return true;})
				.map(e -> {
				System.out.println(Thread.currentThread().getName() + " processing : " + e);
				return e.split(",");
			}).map(g -> {
				System.out.println(Thread.currentThread().getName() + " create Employee");
				Employee employee = new Employee();
				employee.setName(g[0]);
				employee.setSurname(g[1]);
				employee.setWeight(Integer.parseInt(g[2]));
				employee.setHeight(Integer.parseInt(g[3]));
				employee.setAge(Integer.parseInt(g[4]));
				return employee;
			}).collect(Collectors.toMap(e -> e.getName() + "_" + e.getSurname(), Function.identity()));
			
			System.out.println("********************************************************");
			collect.values().parallelStream().filter(e -> {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e1) {
					}
				System.out.println(Thread.currentThread().getName() + " *Filter* : " + e);
				return true;
			}).forEach(e -> {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e1) {
					}
				System.out.println(Thread.currentThread().getName() + " *forech* : " + e);
			});
			System.out.println(collect);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
