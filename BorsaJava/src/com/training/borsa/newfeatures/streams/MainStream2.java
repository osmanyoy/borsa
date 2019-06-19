package com.training.borsa.newfeatures.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MainStream2 {
	public static void main(String[] args) {
		List<String> charExp = Arrays.asList("osman", "mosman", "ali", "veli", "osman");
		Stream<String[]> map = charExp.stream()
		                              .map(s -> s.split(""));
		Stream<String> flatMap = map.flatMap(Arrays::stream);

		flatMap.distinct()
		       .forEach(System.out::println);
	}
}
