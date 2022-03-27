package com.aayush.WorkBench;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierImplementation {

	private void removeAnimals() {
		System.out.println("Removing animals " + Thread.currentThread().getId());
	}

	private void cleanPen() {
		System.out.println("Cleaning the pen " + Thread.currentThread().getId());
	}

	private void addAnimals() {
		System.out.println("Adding animals " + Thread.currentThread().getId());
	}

	public void performTask() {
		removeAnimals();
		cleanPen();
		addAnimals();
	}

	public void performTaskWithCyclicBarrier(CyclicBarrier c1, CyclicBarrier c2) {
		try {
			removeAnimals();
			c1.await();
			cleanPen();
			c1.await();
			addAnimals();
		} catch (InterruptedException | BrokenBarrierException e) {

		}

	}

	public static void main(String[] args) {
		ExecutorService service = null;
		try {
			service = Executors.newFixedThreadPool(4);
			CyclicBarrierImplementation implementation = new CyclicBarrierImplementation();
			/*
			 * for (int i = 0; i < 4; i++) { service.submit(() ->
			 * implementation.performTask()); }
			 */
			CyclicBarrier c1 = new CyclicBarrier(4);
			CyclicBarrier c2 = new CyclicBarrier(4,()->System.out.println("*** Pen Cleaned!"));
			for (int i = 0; i < 4; i++) {
				service.submit(() -> implementation.performTaskWithCyclicBarrier(c1, c2));
			}
		} finally {
			if (service != null)
				service.shutdown();
		}
	}
}
