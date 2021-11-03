package com.company.programming;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
//what is happening in the background when we use lambda expr?
public class FP03FunctionalInterfaces {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);


		Predicate<Integer> integerPredicate = x -> x % 2 == 0;
		//Predicate bir interface ve 1 TANE ABSTRACT METHODU var.
		//lambda exp. yazdığımız anda arka planda şöyle bir şey oluyor.
		Predicate<Integer> integerPredicate2 = new Predicate<Integer>() {
			@Override
			public boolean test(Integer x) {
				return x % 2 == 0;
			}
		};

		Function<Integer, Integer> integerFunction = x -> x * x;
		Function<Integer, Integer> integerFunction2 = new Function<Integer, Integer>() {
			@Override
			public Integer apply(Integer x) {
				return x*x;
			}
		};


		Consumer<Integer> integerConsumer = System.out::println;
		Consumer<Integer> integerConsumer2 = new Consumer<Integer>() {
			@Override
			public void accept(Integer x) {
				System.out.println(x);
			}
		};

		numbers.stream()
				.filter(integerPredicate)
				.map(integerFunction)
				.forEach(integerConsumer);
		/*
				numbers.stream()
				.filter(x -> x % 2 == 0)
				.map(x -> x * x)
				.forEach(System.out::println);
		 */

		//REDUCE
		BinaryOperator<Integer> binaryOperator = Integer::sum;
		BinaryOperator<Integer> binaryOperator1 = new BinaryOperator<Integer>() {
			@Override
			public Integer apply(Integer a, Integer b) {
				return a+b;
			}
		};
		int sum = numbers.stream().reduce(0, binaryOperator);

	}
}
