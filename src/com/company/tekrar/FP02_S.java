package com.company.tekrar;

import java.util.List;

public class FP02_S {
	public static void main(String[] args) {
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

		int sum = addListStructured(numbers);
		System.out.println(sum);
	}

	private static int addListStructured(List<Integer> numbers) {
		int sum = 0;
		for (int num : numbers) {
		sum += num;
		}
		return sum;
	}


}
