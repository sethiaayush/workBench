package com.aayush.WorkBench;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Worker extends Thread {
	private int personID;
	private static Lock mutexLock = new ReentrantLock();
	private static int printTill = 99;
	private static int counter = 0;
	private static Condition numberPrinterCondition = mutexLock.newCondition();

	public Worker(int personID) {
		this.personID = personID;
	}

	public void run() {
		while (counter <= printTill) {
			mutexLock.lock();
			try {
				while ((personID != counter % 3) && counter <= printTill) { // check if it's not your turn
					//System.out.format("Person %d checked... then left.\n", personID);
					numberPrinterCondition.await();
				}
				if (counter <= printTill) {
					counter++; // it's your turn - take some soup!
					System.out.println(personID + "-->" + counter);
					// System.out.format("Person %d printed! Servings left: %d\n", personID,
					// counter);
					numberPrinterCondition.signalAll();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				mutexLock.unlock();
			}
		}
	}
}

public class PrintNumbersUsingDifferentThreads {
	public static void main(String args[]) {
		for (int i = 0; i < 3; i++)
			new Worker(i).start();
	}
}
