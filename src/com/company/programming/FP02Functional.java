package com.company.programming;

import java.util.*;
import java.util.stream.Collectors;

public class FP02Functional {
	public static void main(String[] args) {
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices",
				"AWS", "PCF", "Azure", "Docker", "Kubernates");
		List<Integer> squaredNumbers;
		List<Integer> evenAndSortedListFromNumberList;
		List<Integer> listCourseTitles;

		int sum = addListFunctional(numbers);
		System.out.println("sum = " + sum);

		int max = findMaxNumberInList(numbers); //FARKLI YOLLA
		System.out.println("max = " + max);

		int sum1 = findSumOfSquares(numbers);
		System.out.println("sum = " + sum1);

		int sum2 = findSumOfCubes(numbers);
		System.out.println("sum2 = " + sum2);

		int sumOfOddNumbers = findTheSumOfOddNumbers(numbers);
		System.out.println("sumOfOddNumbers = " + sumOfOddNumbers);

		//printDistinctNumbers(numbers);
		//printSortedNumbers(numbers);
		//printDistinctAndSortedNumbers(numbers);
		//printSortedAndComparedStrings(courses);
		squaredNumbers = squaredNumbers(numbers);
		//System.out.println("squaredNumbers = " + squaredNumbers);

		evenAndSortedListFromNumberList = evenAndSortedListFromNumberList(numbers);
		System.out.println("evenAndSortedListFromNumberList = " + evenAndSortedListFromNumberList);

		listCourseTitles = listWithLengthOfCourseTitles(courses);
		System.out.println("listCourseTitles = " + listCourseTitles);

	}

	//titleların uzunluguna gore yeni liste olustur. spring değil de 6 yazsın
	private static List<Integer> listWithLengthOfCourseTitles(List<String> courses) {
		return courses.stream().map(String::length).collect(Collectors.toList());
	}

	private static List<Integer> evenAndSortedListFromNumberList(List<Integer> numbers) {
		return numbers.stream()
				.filter(x -> x % 2 == 0)
				.sorted()
				.collect(Collectors.toList());
	}

	private static List<Integer> squaredNumbers(List<Integer> numbers) {
		return numbers.stream()
				.map(x -> x * x)
				.collect(Collectors.toList()); // collect all the results into a list
	}

	private static void printSortedAndComparedStrings(List<String> courses) {
		//courses.stream().sorted(Comparator.comparing(str -> str.length())).forEach(System.out::println);
		courses.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);
	}

	private static void printDistinctAndSortedNumbers(List<Integer> numbers) {
		numbers.stream().distinct().sorted().forEach(System.out::println);
	}

	private static void printSortedNumbers(List<Integer> numbers) {
		numbers.stream()
				.sorted()
				.forEach(System.out::println);
	}

	private static void printDistinctNumbers(List<Integer> numbers) {
		numbers.stream().distinct().forEach(System.out::println);
	}

	private static int findTheSumOfOddNumbers(List<Integer> numbers) {
		return numbers
				.stream()
				.filter(x -> x % 2 != 0)
				.reduce(0, Integer::sum);
	}

	private static int getCubes(int a) {
		return a * a * a;
	}

	private static int findSumOfCubes(List<Integer> numbers) {
		return numbers.stream().map(FP02Functional::getCubes).reduce(0, (x, y) -> x + y);
	}

	private static int findSumOfSquares(List<Integer> numbers) {
		return numbers.stream()
				.map(x -> x * x)
				.reduce(0, Integer::sum);
	}

	private static int findMaxNumberInList(List<Integer> numbers) {
		//return  numbers.stream().collect(Collectors.summarizingInt(Integer::intValue)).getMax();
		return numbers.stream().reduce(Integer.MIN_VALUE, (x, y) -> x > y ? x : y);
	}

	private static int sum(int aggregate, int nextNumber) {
		System.out.println("a = " + aggregate + ", b = " + nextNumber);
		return aggregate + nextNumber;
	}

	private static int addListFunctional(List<Integer> numbers) {
		return numbers.stream()
				//.reduce(0,FP02Functional::sum);//combine them into one result! REDUCE 0 is initial value
				.reduce(0, (x, y) -> x + y); //Integer::sum yazsak da olur.
	}
}
