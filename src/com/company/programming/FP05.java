package com.company.programming;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FP05 {
	public static void main(String[] args) {
		List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices",
				"AWS", "PCF", "Azure", "Docker", "Kubernates");

		combineAllSeparateByComma(courses);
		//deneme(courses);
		deneme2(courses);


	}

	private static void deneme2(List<String> courses) {
		System.out.println(courses.stream()
				.peek(System.out::println)
				.filter(course -> course.length() > 11)
				.map(course -> course.toUpperCase())
				.peek(System.out::println));  // Stream döner ama terminal op olmadığı için çalıştırmaz.
	}

	private static void deneme(List<String> courses) {
		//All the intermediate operations in java are LAZY. (  map, peek, filter..)
		//They are only executed when i execute the terminal operation( findFirst)
		Optional<String> first = courses.stream()
				.peek(System.out::println)
				.filter(course -> course.length() > 11)
				.map(course -> course.toUpperCase())
				.peek(System.out::println)
				.findFirst(); //1. elemanı bulduğu anda diğer elemanlar bakmıyor.

		System.out.println(first);
	}

	private static void combineAllSeparateByComma(List<String> courses) {
		String collect = courses.stream()
				.collect(Collectors.joining(", "));
		System.out.println(collect);
	}
}
