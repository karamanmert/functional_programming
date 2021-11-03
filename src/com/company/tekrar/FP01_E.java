package com.company.tekrar;

import java.util.List;

public class FP01_E {
	public static void main(String[] args) {
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices",
				"AWS", "PCF", "Azure", "Docker", "Kubernates");

		//printOddNumbers(numbers);
		//printAllCourses(courses);
		//printCoursesIfContainsSpring(courses);
		//printCoursesIfHasAtleast4Letters(courses);
		//printSquaresOfEvenNumbers(numbers);
		//printCubesOfOddNumbers(numbers);
		//printLengthOfCourses(courses);

	}

	private static void printLengthOfCourses(List<String> courses) {
		courses.stream()
				.map(String::length) //.map(x -> x.length())
				.forEach(System.out::println);
	}

	private static void printCubesOfOddNumbers(List<Integer> numbers) {
		numbers.stream()
				.filter(x -> x % 2 != 0)
				.map(x -> x * x * x)
				.forEach(System.out::println);
	}

	private static void printSquaresOfEvenNumbers(List<Integer> numbers) {
		numbers.stream()
				.filter(x -> x % 2 == 0)
				.map(x -> x * x)
				.forEach(System.out::println);
	}

	private static void printCoursesIfHasAtleast4Letters(List<String> courses) {
		courses.stream().filter(x -> x.length() >= 4).forEach(System.out::println);
	}

	private static void printCoursesIfContainsSpring(List<String> courses) {
		courses.stream().filter(x -> x.contains("Spring")).forEach(System.out::println);
	}

	private static void printAllCourses(List<String> courses) {
		courses.stream().forEach(System.out::println);
	}

	private static void printOddNumbers(List<Integer> numbers) {
		numbers.stream().filter(x -> x % 2 != 0).forEach(System.out::println);
	}
}
