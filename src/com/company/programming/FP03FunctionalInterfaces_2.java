package com.company.programming;

import java.util.List;
import java.util.Random;
import java.util.function.*;


public class FP03FunctionalInterfaces_2 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		//Predicate is used to represent a boolean condition
		//You have a input and you have an output which is boolean.
		Predicate<Integer> isEvenPredicate = x -> x % 2 == 0;

		//There is an input and output.
		Function<Integer, Integer> squareFunction = x -> x * x;
		Function<Integer, String> stringFunction = x -> x + "";

		//takes input but does not return anything
		//you get an input and you'd want to process it and there is no output
		Consumer<Integer> sysoutConsumer = x -> System.out.println(x);

		//you get two inputs and output. inputs and output are the same type.
		BinaryOperator<Integer> sumBinaryOperator = (x, y) -> x + y;

		//No input -> return something back ex:factory pattern
		// () ->NO PARAMETERS
		Supplier<Integer> randomIntegerSupplier = () -> {
			Random random = new Random();
			return random.nextInt(50);
		};
		System.out.println("randomIntegerSupplier = " + randomIntegerSupplier.get());

		//one input. has output. same type
		UnaryOperator<Integer> unaryOperator = (x) -> 3 * x;
		System.out.println("unaryOperator.apply(10) = " + unaryOperator.apply(10));

		//two inputs, output will be boolean
		BiPredicate<Integer, String> biPredicate = (number, string) -> {
			return number < 10 && string.length() > 4;
		};
		System.out.println(biPredicate.test(4, "karaman"));

		//two input, one output -> specify the return type!(3rd parameter)
		BiFunction<Integer, String, String> biFunction = (number, string) -> {
			return number + string;
		};
		System.out.println("biFunction = " + biFunction.apply(10,"mert"));

		//two input, no output
		BiConsumer<String, String> biConsumer = (s1,s2)->{
			System.out.println(s1);
			System.out.println(s2);
		};

		biConsumer.accept("mert","karaman");
	}
}
