package com.company.programming;

import java.util.List;

// goal -> WHAT TO DO?
public class FP01Functional {
	public static void main(String[] args) {
		//printAllNumbersInListFunctional(List.of(12, 9, 13, 4, 6, 2, 4, 12, 15));
		//printEvenNumbersInListFunctional(List.of(12, 9, 13, 4, 6, 2, 4, 12, 15));

	}


	private static void print(int num) {
		System.out.println(num);
	}

	private static boolean isEven(int num) {
		return num % 2 == 0;
	}

	private static void printAllNumbersInListFunctional(List<Integer> numbers) {
		numbers
				.stream() //arrayi sequence haline getirdi.
				//.forEach(FP01Functional::print); //her biri ile ne yapılacak?
				.forEach(System.out::println);
	}

	private static void printEvenNumbersInListFunctional(List<Integer> numbers) {
		numbers
				.stream()
				//.filter(FP01Functional::isEven) //for each seq. of number-> do this check
				.filter(number -> number % 2 == 0) //lambda exp. //if cond true go next step
				.forEach(System.out::println);
	}
}
