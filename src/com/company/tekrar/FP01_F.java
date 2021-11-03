package com.company.tekrar;

import java.util.List;

public class FP01_F {
	public static void main(String[] args) {
		printAllNumbersInListFunctional(List.of(12, 9, 13, 4, 6, 2, 4, 12, 15));
		System.out.println("****************");
		printEvenNumbersInListFunctional(List.of(12, 9, 13, 4, 6, 2, 4, 12, 15));
	}

	private static void printEvenNumbersInListFunctional(List<Integer> integers) {
		integers.stream().filter(x -> x % 2 == 0).forEach(System.out::println);
	}

	private static void printAllNumbersInListFunctional(List<Integer> integers) {
		integers.stream().forEach(System.out::println);
		//integers.stream().forEach(FP01_F::print);
	}

	private static void print(Integer integer) {
		System.out.println("integer = " + integer);
	}
}
