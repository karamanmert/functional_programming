package com.company.tekrar;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class Course {
	private String name;
	private String category;
	private int reviewScore;
	private int noOfStudents;

	public Course(String name, String category, int reviewScore, int noOfStudents) {
		this.name = name;
		this.category = category;
		this.reviewScore = reviewScore;
		this.noOfStudents = noOfStudents;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getReviewScore() {
		return reviewScore;
	}

	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}

	public int getNoOfStudents() {
		return noOfStudents;
	}

	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}

	@Override
	public String toString() {
		return
				"name='" + name + '\'' +
						", reviewScore=" + reviewScore +
						", noOfStudents=" + noOfStudents;
	}
}

//allMatch, noneMatch, anyMatch, sorted, limit..
public class FP04_C {
	public static void main(String[] args) {
		List<Course> courses = List.of(
				new Course("Spring", "Framework", 98, 20000),
				new Course("Spring Boot", "Framework", 95, 18000),
				new Course("API", "Microservices", 97, 22000),
				new Course("Microservices", "Microservices", 96, 25000),
				new Course("FullStack", "FullStack", 91, 14000),
				new Course("AWS", "Cloud", 92, 21000),
				new Course("Azure", "Cloud", 99, 21000),
				new Course("Docker", "Cloud", 92, 20000),
				new Course("Kubernetes", "Cloud", 91, 20000)
		);
		//reviewScoreGreaterThenNinety(courses);
		//reviewScoreGreaterThenNinetyFive(courses);
		//reviewScoreGreaterThenHundred(courses);
		//reviewScoreGreaterThenNinetyTwo(courses);
		//reviewScoreGreaterThenNinetyEight(courses);
		//checkIfNameContainsSpring(courses);
		//sortCourses(courses);
		//compareByNumberOfStudentsThenCompareByReviewScore(courses);
		//System.out.println("-----------");
		//compareByReviewThenNumber(courses);
		//getTopFiveCourses(courses);
		//getAllCoursesSkipTop3(courses);
		//skip3thenLimit4(courses);
		//takeWhileReviewScoreGreaterThen95(courses);
		//takeWhileNoOfStudentGreaterThen20000(courses);
		//dropWhileReviewScoreGreaterThen95(courses);
		//dropWhileNoOfStudentGreaterThen20000(courses);
		//findMaxNoOfStudent(courses);
		//findMinNoOfStudent(courses);
		//orElseUsage(courses);
		//findFirst(courses);
		findAny(courses);
	}

	private static void findAny(List<Course> courses) {
		Optional<Course> any = courses.stream()
				.filter(course -> course.getReviewScore() > 95)
				.sorted(Comparator.comparingInt(Course::getReviewScore))
				.findAny();
		System.out.println("any = " + any);
	}

	private static void findFirst(List<Course> courses) {
		Optional<Course> first = courses.stream().findFirst();
		System.out.println("first = " + first.get());
	}

	private static void orElseUsage(List<Course> courses) {
		Course course1 = courses.stream()
				.filter(course -> course.getReviewScore() > 100)
				.min(Comparator.comparingInt(Course::getReviewScore))
				.orElse(new Course("test","test",100,10000));
		System.out.println("course1 = " + course1);
	}

	private static void findMaxNoOfStudent(List<Course> courses) {
		Optional<Course> max = courses.stream().max(Comparator.comparingInt(Course::getNoOfStudents));
		System.out.println("max = " + max);

		Optional<Course> first = courses.stream()
				.sorted(Comparator.comparingInt(Course::getNoOfStudents).reversed())
				.findFirst();
		System.out.println("first = " + first.get());
	}

	private static void dropWhileReviewScoreGreaterThen95(List<Course> courses) {
		courses.stream()
				.sorted(
						Comparator.comparingInt(Course::getReviewScore)
								.thenComparingInt(Course::getNoOfStudents)
								.reversed()
				).forEach(System.out::println);
		System.out.println("*-*-*-*-*-*-*");
		courses.stream()
				.sorted(
						Comparator.comparingInt(Course::getReviewScore)
								.thenComparingInt(Course::getNoOfStudents)
								.reversed()
				)
				.dropWhile(course -> course.getReviewScore() > 95)
				.forEach(System.out::println);
	}

	private static void takeWhileNoOfStudentGreaterThen20000(List<Course> courses) {
		courses.stream()
				.sorted(
						Comparator.comparingInt(Course::getNoOfStudents)
								.reversed()
				).forEach(System.out::println);
		System.out.println("*-*-*-*-*-*-*");
		System.out.println("*-*-*-*-*-*-*");
		System.out.println("*-*-*-*-*-*-*");
		courses.stream()
				.sorted(Comparator.comparingInt(Course::getNoOfStudents).reversed())
				.takeWhile(course -> course.getNoOfStudents() > 20000)
				.forEach(System.out::println);
	}

	private static void takeWhileReviewScoreGreaterThen95(List<Course> courses) {
		courses.stream()
				.sorted(
						Comparator.comparingInt(Course::getReviewScore)
								.thenComparingInt(Course::getNoOfStudents)
								.reversed()
				).forEach(System.out::println);
		System.out.println("*-*-*-*-*-*-*");
		List<Course> collect = courses.stream()
				.sorted(
						Comparator.comparingInt(Course::getReviewScore)
								.thenComparingInt(Course::getNoOfStudents)
								.reversed()
				)
				.takeWhile(course -> course.getReviewScore() > 95)
				.collect(Collectors.toList());
		System.out.println("collect = " + collect);
	}

	private static void skip3thenLimit4(List<Course> courses) {
		List<Course> courseList = courses.stream()
				.sorted(Comparator.comparingInt(Course::getReviewScore)
						.reversed())
				.skip(3)
				.limit(4)
				.collect(Collectors.toList());
		System.out.println("courseList = " + courseList);
	}

	private static void getAllCoursesSkipTop3(List<Course> courses) {
		courses.stream()
				.sorted(
						Comparator.comparingInt(Course::getNoOfStudents)
								.thenComparingInt(Course::getReviewScore)
								.reversed()
				)
				.skip(3)
				.forEach(System.out::println);
	}

	private static void getTopFiveCourses(List<Course> courses) {
		courses.stream()
				.sorted(Comparator.comparingInt(Course::getNoOfStudents).reversed())
				.limit(5)
				.forEach(System.out::println);
	}

	private static void compareByReviewThenNumber(List<Course> courses) {
		List<Course> courseList = courses.stream()
				.sorted(
						Comparator.comparingInt(Course::getReviewScore)
								.thenComparingInt(Course::getNoOfStudents)
								.reversed()
				).collect(Collectors.toList());
		System.out.println(courseList);
		/*
			[
				name='Azure', reviewScore=99, noOfStudents=21000,
				name='Spring', reviewScore=98, noOfStudents=20000,
				name='API', reviewScore=97, noOfStudents=22000,
				name='Microservices', reviewScore=96, noOfStudents=25000,
				name='Spring Boot', reviewScore=95, noOfStudents=18000,
				name='AWS', reviewScore=92, noOfStudents=21000,
				name='Docker', reviewScore=92, noOfStudents=20000,
				name='Kubernetes', reviewScore=91, noOfStudents=20000,
				name='FullStack', reviewScore=91, noOfStudents=14000
			]
		 */

	}

	private static void compareByNumberOfStudentsThenCompareByReviewScore(List<Course> courses) {
		courses.stream()
				.sorted(
						Comparator.comparingInt(Course::getNoOfStudents)
								//.thenComparingInt(course -> course.getReviewScore())
								.thenComparingInt(Course::getReviewScore)
								.reversed()
				).forEach(System.out::println);
	}

	private static void sortCourses(List<Course> courses) {
		courses.stream()
				.sorted(
						Comparator.comparingInt(Course::getNoOfStudents)
								//.thenComparingInt(course -> course.getReviewScore())
								.thenComparingInt(Course::getReviewScore)
								.reversed()
				).forEach(System.out::println);
	}

	private static void checkIfNameContainsSpring(List<Course> courses) {
		boolean anyMatch = courses.stream()
				.anyMatch(course -> course.getName().contains("Spring"));
		System.out.println("anyMatch = " + anyMatch);

		boolean noneMatch = courses.stream().noneMatch(course -> course.getName().contains("Spring"));
		System.out.println("noneMatch = " + noneMatch);

		boolean allMatch = courses.stream().allMatch(course -> course.getName().contains("Spring"));
		System.out.println("allMatch = " + allMatch);
	}

	private static void reviewScoreGreaterThenNinetyEight(List<Course> courses) {
		boolean b = courses.stream().anyMatch(course -> course.getReviewScore() > 98);
	}

	private static void reviewScoreGreaterThenNinetyTwo(List<Course> courses) {
		boolean b = courses.stream().noneMatch(course -> course.getReviewScore() > 92);
		System.out.println("noneMatch 92 > " + b);
	}

	private static void reviewScoreGreaterThenHundred(List<Course> courses) {
		boolean b = courses.stream().noneMatch(course -> course.getReviewScore() > 100);
		System.out.println("noneMatch 100 > " + b);
	}

	private static void reviewScoreGreaterThenNinetyFive(List<Course> courses) {
		boolean b = courses.stream().allMatch(course -> course.getReviewScore() > 95);
		System.out.println("b = " + b);
	}


	private static void reviewScoreGreaterThenNinety(List<Course> courses) {
		//allMatch
		boolean b = courses.stream().allMatch(course -> course.getReviewScore() > 90);
		System.out.println("b = " + b);
	}

}
