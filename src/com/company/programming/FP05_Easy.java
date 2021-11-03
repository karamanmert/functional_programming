package com.company.programming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FP05_Easy {
	public static void main(String[] args) {
		int sum = IntStream.range(0, 100).filter(x -> x % 2 != 0).sum();
		System.out.println("sum = " + sum);
		System.out.println(
				IntStream.rangeClosed(0, 10).average().getAsDouble()
		);
		System.out.println(
				IntStream.iterate(1, e -> e + 2) //1 den başla
						.limit(10) // infinite loop olmasın diye
						.peek(System.out::println)
						.sum()
		);
		//xxx();
		//xxx1();
		//xxx2();
		//xxx3();
		//xxx4();
		xxx5();
	}

	private static void xxx5() {
		int[] numberArray = {12,3,5,111,21315,6456,14};
		System.out.println("total: "+Arrays.stream(numberArray).sum());
		System.out.println(
				"average: " + Arrays.stream(numberArray).average().getAsDouble()
		);

		Arrays.stream(numberArray).filter(x->x%2==0).forEach(System.out::println);
		List<Integer> collect = Arrays.stream(numberArray).filter(e -> e % 2 == 0).boxed().collect(Collectors.toList());
		System.out.println(collect);

	}

	private static void xxx4() {
		List<Integer> collect = IntStream.iterate(2, e -> e * 2).limit(10)
				.boxed().collect(Collectors.toList());
		System.out.println(collect);
	}


	private static void xxx3() {
		//iterate
		System.out.println(
				IntStream.iterate(11,x->x+5)
						.limit(4)
						.peek(System.out::println)
						.sum()
		);
	}


	private static void xxx2() {
		// add even numbers between 0-100
		System.out.println(
				IntStream.range(0,101).filter(x->x%2==0).sum()
		);
	}

	private static void xxx1() {
		// add 0 to 10 return it back
		int sum = IntStream.range(0, 11).sum();
		System.out.println(sum);
	}

	private static void xxx() {
		//sout 0,10
		IntStream.range(0,11).forEach(System.out::println);
	}
}
