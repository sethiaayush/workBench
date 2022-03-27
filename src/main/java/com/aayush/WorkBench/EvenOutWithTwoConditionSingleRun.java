package com.aayush.WorkBench;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class EvenOutWithTwoConditionSingleRun {
	// Starting counter
	int counter = 1;

	static int N;
	Lock lock = new ReentrantLock();
	Condition evenCondition = lock.newCondition();
	Condition oddCondition = lock.newCondition();

	// Function to print odd numbers
	public void printOddNumber() {
		// Print number till the N
		while (counter < N) {
			try {
				lock.lock();
				// If count is odd then print
				if (counter % 2 == 1) {
					// Print the number
					System.out.print(counter + " ");
					// Increment counter
					counter++;
					// Notify to second thread
					evenCondition.signal();
				} else {
					// Exception handle
					try {
						oddCondition.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} finally {
				lock.unlock();
			}
		}
	}

	// Function to print even numbers
	public void printEvenNumber() {
		// Print number till the N
		while (counter < N) {
			try {
				lock.lock();
				// If count is even then print
				if (counter % 2 == 0) {
					// Print the number
					System.out.print(counter + " ");

					// Increment counter
					counter++;

					// Notify to 2nd thread
					oddCondition.signal();
					// Exception handle
				} else {
					try {
						evenCondition.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			} finally {
				lock.unlock();
			}
		}
	}

	// Driver Code
	public static void main(String[] args) {
		// Given Number N
		N = 100;

		// Create an object of class
		EvenOutWithTwoConditionSingleRun mt = new EvenOutWithTwoConditionSingleRun();

		// Create thread t1
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				mt.printEvenNumber();
			}
		});

		// Create thread t2
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				mt.printOddNumber();
			}
		});

		// Start both threads
		t1.start();
		t2.start();
	}
}