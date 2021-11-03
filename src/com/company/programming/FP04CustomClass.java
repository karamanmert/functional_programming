package com.company.programming;

import java.util.*;
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
public class FP04CustomClass {
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
		//findAny(courses);
		//findTotalNoOfStudents(courses);
		//findTheAverageNoOfStudents(courses);
		//findHowManyCoursesInTheCriteria(courses);
		//groupCoursesByCategory(courses);
		//countTheGroupsWhichAreGroupedByCategories(courses);
		//usageMaxOf(courses);
		//nameList(courses);
	}

	private static void nameList(List<Course> courses) {
		Map<String, List<String>> collect = courses.stream()
				.collect(Collectors.groupingBy(Course::getCategory,
						Collectors.mapping(Course::getName, Collectors.toList()))
				);
		System.out.println(collect);
		//{Cloud=[AWS, Azure, Docker, Kubernetes], FullStack=[FullStack], Microservices=[API, Microservices], Framework=[Spring, Spring Boot]}
	}

	private static void usageMaxOf(List<Course> courses) {
		//groupla ama önce get review skoru fazla olanı göster.
		Map<String, Optional<Course>> collect = courses.stream()
				.collect(
						Collectors.groupingBy(Course::getCategory,
								Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))
				);
		System.out.println(collect);
	}

	private static void countTheGroupsWhichAreGroupedByCategories(List<Course> courses) {
		Map<String, Long> collect = courses.stream()
				.collect(Collectors.groupingBy(Course::getCategory, Collectors.counting()));
		System.out.println(collect);
		//{Cloud=4, FullStack=1, Microservices=2, Framework=2}
	}

	private static void groupCoursesByCategory(List<Course> courses) {
		Map<String, List<Course>> collect = courses.stream()
				.collect(Collectors.groupingBy(Course::getCategory));
		/*
		{
			Cloud=[name='AWS', reviewScore=92, noOfStudents=21000, name='Azure', reviewScore=99, noOfStudents=21000, name='Docker', reviewScore=92, noOfStudents=20000, name='Kubernetes', reviewScore=91, noOfStudents=20000],
			FullStack=[name='FullStack', reviewScore=91, noOfStudents=14000],
			Microservices=[name='API', reviewScore=97, noOfStudents=22000, name='Microservices', reviewScore=96, noOfStudents=25000],
			Framework=[name='Spring', reviewScore=98, noOfStudents=20000, name='Spring Boot', reviewScore=95, noOfStudents=18000]
		}
		 */
		System.out.println(collect);
		System.out.println("Find the elements in that specific group -> Framework ..");
		collect.get("Framework").forEach(System.out::println);
	}

	private static void findHowManyCoursesInTheCriteria(List<Course> courses) {
		long count = courses.stream().filter(course -> course.getReviewScore() > 95)
				.mapToInt(course -> course.getNoOfStudents())
				.count();
		System.out.println("findHowManyCoursesInTheCriteria :  " + count);
	}

	private static void findTheAverageNoOfStudents(List<Course> courses) {
		courses.stream()
				.filter(course -> course.getReviewScore() > 95)
				.mapToInt(course -> course.getNoOfStudents()).forEach(System.out::println);
		System.out.println("***");
		OptionalDouble average = courses.stream()
				.filter(course -> course.getReviewScore() > 95)
				.mapToInt(Course::getNoOfStudents)
				.average();
		System.out.println("average = " + average.getAsDouble());
	}

	private static void findTotalNoOfStudents(List<Course> courses) {
		//find total number of students who i
		int sum = courses.stream()
				.filter(course -> course.getReviewScore() > 95)
				//.mapToInt(course -> course.getNoOfStudents())
				.mapToInt(Course::getNoOfStudents)
				.sum();
		System.out.println("sum = " + sum);
	}

	private static void findAny(List<Course> courses) {
		System.out.println("normal courses");
		courses.stream().sorted(Comparator.comparingInt(Course::getNoOfStudents).reversed()).forEach(System.out::println);
		System.out.println("find any");
		Optional<Course> first = courses.stream()
				.filter(course -> course.getReviewScore() > 95)
				.sorted(Comparator.comparingInt(Course::getReviewScore).reversed())// BİR ŞEY BULAMAZSA <90 DA EMPTY DÖNER.
				.findAny();  // findFirst optional döner.
		System.out.println(first);
	}

	private static void findFirst(List<Course> courses) {
		System.out.println("normal courses");
		courses.stream().sorted(Comparator.comparingInt(Course::getNoOfStudents).reversed()).forEach(System.out::println);
		System.out.println("find first");
		Optional<Course> first = courses.stream()
				.filter(course -> course.getReviewScore() > 95)
				.sorted(Comparator.comparingInt(Course::getReviewScore).reversed())// BİR ŞEY BULAMAZSA <90 DA EMPTY DÖNER.
				.findFirst();  // findFirst optional döner.
		System.out.println(first);
	}


	private static void orElseUsage(List<Course> courses) {
		Course orElse = courses.stream()
				.filter(course -> course.getReviewScore() > 100) //90'a çevir öyle de dene.
				.min(Comparator.comparingInt(Course::getNoOfStudents))
				.orElse(new Course("C#", "XXXX", 100, 20111)); // yoksa bunu kullan.
		System.out.println(orElse);
	}

	private static void findMinNoOfStudent(List<Course> courses) {
		System.out.println("normal courses");
		courses.stream().sorted(Comparator.comparingInt(Course::getNoOfStudents).reversed()).forEach(System.out::println);
		System.out.println("Min course");
		Optional<Course> min = courses.stream()  //MIN RETURNS OPTIONAL
				.min(Comparator.comparingInt(Course::getNoOfStudents));
		System.out.println(min);
	}

	private static void findMaxNoOfStudent(List<Course> courses) {
		System.out.println("normal courses");
		courses.stream().sorted(Comparator.comparingInt(Course::getNoOfStudents).reversed()).forEach(System.out::println);
		System.out.println("Max course");
		Optional<Course> max = courses.stream()
				.max(Comparator.comparingInt(Course::getNoOfStudents)); // MAX RETURNS OPTIONAL!!!!!!11
		System.out.println(max);

	}

	private static void dropWhileNoOfStudentGreaterThen20000(List<Course> courses) {
		System.out.println("normal list:");
		courses.stream()
				.sorted(
						Comparator.comparingInt(Course::getNoOfStudents)
								.reversed()
				).forEach(System.out::println);
		System.out.println("--");
		courses.stream()
				.sorted(
						Comparator.comparingInt(Course::getNoOfStudents)
								.reversed()
				).dropWhile(course -> course.getNoOfStudents() > 20000)
				.skip(1)
				.limit(2)
				.collect(Collectors.toList())
				.forEach(System.out::println);
	}

	private static void takeWhileNoOfStudentGreaterThen20000(List<Course> courses) {
		courses.stream()
				.sorted(
						Comparator.comparingInt(Course::getNoOfStudents)
								.reversed()
				).takeWhile(course -> course.getNoOfStudents() > 20000)
				.skip(1)
				.limit(2)
				.collect(Collectors.toList())
				.forEach(System.out::println);
	}

	private static void dropWhileReviewScoreGreaterThen95(List<Course> courses) {
		System.out.println("normal list:");
		System.out.println(courses);
		courses.stream()
				.dropWhile(course -> course.getReviewScore() >= 95)
				.collect(Collectors.toList())
				.forEach(System.out::println);
	}

	private static void takeWhileReviewScoreGreaterThen95(List<Course> courses) {
		System.out.println("normal list:");
		System.out.println(courses);
		courses.stream()
				.takeWhile(course -> course.getReviewScore() >= 95)
				.collect(Collectors.toList())
				.forEach(System.out::println);
	}

	private static void skip3thenLimit4(List<Course> courses) {
		courses.stream()
				.sorted(
						Comparator.comparingInt(Course::getNoOfStudents)
								.reversed()
				).skip(3)
				.limit(4)
				.collect(Collectors.toList())
				.forEach(System.out::println);
	}

	private static void getAllCoursesSkipTop3(List<Course> courses) {
		courses.stream()
				.sorted(
						Comparator.comparingInt(Course::getNoOfStudents)
								.reversed()
				).skip(3)
				.collect(Collectors.toList())
				.forEach(System.out::println);
	}

	private static void getTopFiveCourses(List<Course> courses) {
		courses.stream()
				.sorted(
						Comparator.comparingInt(Course::getNoOfStudents)
								.reversed() //önce büyükler gelsin
				).limit(5) //ilk 5 i gelsin
				.collect(Collectors.toList())
				.forEach(System.out::println);
	}

	private static void compareByReviewThenNumber(List<Course> courses) {
		courses.stream()
				.sorted(
						Comparator.comparingInt(Course::getReviewScore)
								.thenComparingInt(Course::getNoOfStudents)
								.reversed()
				).collect(Collectors.toList())
				.forEach(System.out::println);
	}

	private static void compareByNumberOfStudentsThenCompareByReviewScore(List<Course> courses) {
		//COMPARING YAPARKEN EFFICIENCY İÇİN PRIMITIVE KULLAN!
		courses.stream()
				.sorted(
						Comparator.comparingInt(Course::getNoOfStudents) //önce numaraya göre sırala
								.thenComparingInt(Course::getReviewScore) //sonra isime göre sırala
								.reversed() //Önce yüksekleri görmek için
				)
				.collect(Collectors.toList())
				.forEach(System.out::println);
/*
		courses.stream()
				.sorted(
						Comparator.comparing(Course::getNoOfStudents) //önce numaraya göre sırala
								.thenComparing(Course::getReviewScore) //sonra isime göre sırala
								.reversed() //Önce yüksekleri görmek için
				)
				.collect(Collectors.toList())
				.forEach(System.out::println);

 */
	}

	private static void sortCourses(List<Course> courses) {
		//courses.stream().sorted(Comparator.comparing(course -> course.getNoOfStudents())).forEach(System.out::println);
		courses.stream().sorted(Comparator.comparing(Course::getNoOfStudents)).collect(Collectors.toList()).forEach(System.out::println);
		List<Course> collect = courses.stream().sorted(Comparator.comparing(Course::getNoOfStudents)).collect(Collectors.toList());
		System.out.println(collect);
	}

	private static void checkIfNameContainsSpring(List<Course> courses) {
		boolean anyMatch = courses.stream().anyMatch(course -> course.getName().contains("Spring"));
		System.out.println("anyMatch = " + anyMatch);
		boolean allMatch = courses.stream().allMatch(course -> course.getName().contains("Spring"));
		System.out.println("allMatch = " + allMatch);
		boolean noneMatch = courses.stream().noneMatch(course -> course.getName().contains("Spring"));
		System.out.println("noneMatch = " + noneMatch);
	}

	private static void reviewScoreGreaterThenNinetyEight(List<Course> courses) {
		boolean anyMatch = courses.stream().anyMatch(course -> course.getReviewScore() > 98);
		System.out.println("anyMatch > 98  " + anyMatch);
	}

	private static void reviewScoreGreaterThenNinetyTwo(List<Course> courses) {
		boolean noneMatch = courses.stream().noneMatch(course -> course.getReviewScore() > 92);
		System.out.println("noneMatch > 92  " + noneMatch);
	}

	private static void reviewScoreGreaterThenHundred(List<Course> courses) {
		boolean noneMatch = courses.stream().noneMatch(course -> course.getReviewScore() > 100);
		System.out.println("noneMatch > 100  " + noneMatch);
	}

	private static void reviewScoreGreaterThenNinetyFive(List<Course> courses) {
		boolean allMatch = courses.stream().allMatch(course -> course.getReviewScore() > 95);
		System.out.println("allMatch > 95  " + allMatch);
	}

	//allMatch predicatedir yani boolean result döner.
	//allMatch -> tüm koşulların sağlaması lazım. & operatorü gibi. 1 tane bile sağlamazsa false döner.
	private static void reviewScoreGreaterThenNinety(List<Course> courses) {
		//courses.stream().filter(x -> x.getReviewScore() > 95).forEach(x-> System.out.println(x.getName()));
		boolean allMatch = courses.stream().allMatch(course -> course.getReviewScore() > 90);
		System.out.println("allMatch > 90  " + allMatch);
	}
}
