package com.company.programming;


import java.util.List;
import java.util.function.Supplier;

public class FP03MethodReferences {
	public static void main(String[] args) {
		List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices",
				"AWS", "PCF", "Azure", "Docker", "Kubernates");

		courses.stream()
				.map(String::toUpperCase)  //calling a method which is on the object.
				.forEach(FP03MethodReferences::print); //calling static method
		Supplier<String> supplier = String::new; //constructor ref for creating new objects
		//Supplier<String> supplier = () -> new String();

	}

	private static void print(String str) {
		System.out.println(str);
	}
}
