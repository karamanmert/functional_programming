package com.company.programming;

import java.util.List;

public class FP01Structured {
	public static void main(String[] args) {
		//printAllNumbersInListStructured(List.of(12, 9, 13, 4, 6, 2, 4, 12, 15));
		printEvenNumbersInListStructured(List.of(12, 9, 13, 4, 6, 2, 4, 12, 15));
	}

	private static void printAllNumbersInListStructured(List<Integer> numbers) {
		//how to loop ?
		for (int ints : numbers) {
			System.out.println(ints);
		}
	}

	private static void printEvenNumbersInListStructured(List<Integer> numbers) {
		//how to loop ?
		for (int ints : numbers) {
			if (ints % 2 == 0)
				System.out.println(ints);
		}
	}
}
