package com.company.programming;

import java.util.stream.LongStream;

/*
Java split the stream into multiple parts and execute these operations on those
multiple parts and combine the result of all those multiple parts.
 */
public class FP05_Parallezation {
	public static void main(String[] args) {
		//noParallel();
		//yesParallel();

	}

	//96 ms
	private static void yesParallel() {
		long time = System.currentTimeMillis();
		System.out.println(
				LongStream.range(0, 1000000000).parallel().sum()
		);
		System.out.println(System.currentTimeMillis() - time);
	}

	//1300 ms
	private static void noParallel() {
		long time = System.currentTimeMillis();
		System.out.println(
				LongStream.range(0, 1000000000).sum()
		);
		System.out.println(System.currentTimeMillis() - time);
	}
}
