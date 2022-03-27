package com.aayush.WorkBench;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class App {
	private AtomicInteger sheepCount = new AtomicInteger(0);

	private void incrementAndReport() {
		System.out.println(sheepCount.incrementAndGet());
	}

	public static void main(String[] args) throws InterruptedException {
		System.out.println("start");
		ExecutorService service = null;
		try {
			service = Executors.newFixedThreadPool(20);
			App app = new App();
			for (int i = 0; i < 10; i++) {
				service.submit(() -> app.incrementAndReport());
			}
		} finally {
			if (service != null)
				service.shutdown();
		}
	}
}
