package com.company.programming;

import java.util.ArrayList;
import java.util.List;

public class FP06_Playwithstreams {
	public static void main(String[] args) {
		//bu liste değiştirilemez o yüzden yeni liste yarattık.
		List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices",
				"AWS", "PCF", "Azure", "Docker", "Kubernates");
		List<String> modifyableCourses = new ArrayList<>(courses);
		System.out.println(modifyableCourses);
		//Tüm elemanları büyük harf yap.
		modifyableCourses.replaceAll(String::toUpperCase); //replaceAll!!!!
		System.out.println(modifyableCourses);

		//Length < 8 sil
		modifyableCourses.removeIf(course -> course.length() < 8);
		System.out.println(modifyableCourses);
	}


}
