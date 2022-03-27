package com.aayush.WorkBench;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintOddEvenWithMutex {
	public static void main(String[] args) {
		new PrintOddEven(false).start();
		new PrintOddEven(true).start();
	}
}

class PrintOddEven extends Thread {
	private boolean printOdd;
	private static Lock lock = new ReentrantLock();
	private static int maxNumber = 10;
	private static int counter = 0;

	public PrintOddEven(boolean printOdd) {
		this.printOdd = printOdd;
	}

	@Override
	public void run() {
		while (counter < maxNumber) {
			lock.lock();
			try {
				if (printOdd == (counter % 2 == 1) && counter < maxNumber) {
					System.out.println(counter++);
				} else {
					System.out.println("useless check");
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
	}
}
