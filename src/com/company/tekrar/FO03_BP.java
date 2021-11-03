package com.company.tekrar;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//we are passing the logic of the method as an argument of the method
//we are passing the behavior of the method as an argument
//This is called behavior parameterization
public class FO03_BP {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

		//filterAndPrint(numbers, x1 -> x1 % 2 == 0);
		//filterAndPrint(numbers, x -> x % 2 != 0);

		System.out.println("-------------------------");
		System.out.println("numbers = " + numbers);

		mapAndCreateNewList(numbers, x -> x * x);
		mapAndCreateNewList(numbers, x -> x + x);
		mapAndCreateNewList(numbers, x -> x * x * x);


	}

	private static void mapAndCreateNewList(List<Integer> numbers, Function<Integer, Integer> function) {
		List<Integer> collect = numbers.stream().map(function).collect(Collectors.toList());
		System.out.println(collect);
	}

	private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> predicate) {
		numbers.stream()
				.filter(predicate)
				.forEach(System.out::println);
	}
}
