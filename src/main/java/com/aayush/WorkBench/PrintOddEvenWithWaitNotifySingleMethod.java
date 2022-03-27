package com.aayush.WorkBench;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintOddEvenWithWaitNotifySingleMethod {
	public static void main(String[] args) {
		new PrintOddEvenWaitNotify(true).start();
		new PrintOddEvenWaitNotify(false).start();
	}
}

class PrintOddEvenWaitNotify extends Thread {
	private boolean printOdd;
	private static Lock lock = new ReentrantLock();
	private static Condition condition = lock.newCondition();
	private static int maxNumber = 10;
	private static int counter = 0;

	public PrintOddEvenWaitNotify(boolean printOdd) {
		this.printOdd = printOdd;
	}

	@Override
	public void run() {
		while (counter < maxNumber) {
			lock.lock();
			try {
				if (printOdd != (counter % 2 == 1) && counter < maxNumber) {
					System.out.println("await");
					condition.await();
				}
				System.out.println(counter++);
				condition.signal();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
	}
}