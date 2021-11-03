package com.company.programming;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FP06Threads {
	public static void main(String[] args) {
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					System.out.println(Thread.currentThread().getId() + ":" + i);
				}
			}
		};

		Runnable runnable1 = () -> {
			IntStream.range(0, 10000)
					.forEach(i -> System.out.println(Thread.currentThread().getId() + ":" + i));
		};

		//execute the thread
		Thread thread = new Thread(runnable1);

		thread.start();

		Thread thread1 = new Thread(runnable1);
		thread1.start();

		Thread thread2 = new Thread(runnable1);
		thread2.start();

	}
}
