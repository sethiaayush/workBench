package com.aayush.WorkBench;

public class PrintOutEvenWithWaitNotify2Methods {
	// Starting counter
	int counter = 1;

	static int N;

	// Function to print odd numbers
	public void printOddNumber() {
		synchronized (this) {
			// Print number till the N
			while (counter < N) {

				// If count is even then print
				if (counter % 2 == 1) {
					// Print the number
					System.out.print(counter + " ");

					// Increment counter
					counter++;

					// Notify to second thread
					notify();
				} else {
					// Exception handle
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		}
	}

	// Function to print even numbers
	public void printEvenNumber() {
		synchronized (this) {
			// Print number till the N
			while (counter < N) {

				// If count is odd then print
				if (counter % 2 == 0) {
					// Print the number
					System.out.print(counter + " ");

					// Increment counter
					counter++;

					// Notify to 2nd thread
					notify();
					// Exception handle
				} else {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			}
		}
	}

	// Driver Code
	public static void main(String[] args) {
		// Given Number N
		N = 100;

		// Create an object of class
		PrintOutEvenWithWaitNotify2Methods mt = new PrintOutEvenWithWaitNotify2Methods();

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
