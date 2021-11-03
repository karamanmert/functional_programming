package com.company.tekrar;

import java.util.List;

public class FP01_S {
	public static void main(String[] args) {
		printAllNumbersInListStructured(List.of(12, 9, 13, 4, 6, 2, 4, 12, 15));
		System.out.println("------------------");
		printEvenNumbersInListStructured(List.of(12, 9, 13, 4, 6, 2, 4, 12, 15));
	}

	private static void printEvenNumbersInListStructured(List<Integer> integers) {
		for (int number : integers){
			if (number % 2 == 0)
				System.out.println("number = " + number);
		}
	}

	private static void printAllNumbersInListStructured(List<Integer> integers) {
		for (int number : integers){
			System.out.println("number = " + number);
		}
	}
}
