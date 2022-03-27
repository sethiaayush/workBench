package com.aayush.WorkBench;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Worker3Thread extends Thread {
	private int threadId;
	private static Lock mutexLock = new ReentrantLock();
	public static int max;
	private static int counter = 0;
	private static Condition thread_0_condition = mutexLock.newCondition();
	private static Condition thread_1_condition = mutexLock.newCondition();
	private static Condition thread_2_condition = mutexLock.newCondition();

	public Worker3Thread(int threadId) {
		this.threadId = threadId;
	}

	public void run() {
		while (counter <= max) {
			mutexLock.lock();
			try {
				while ((threadId != (counter % 3)) && counter <= max) {// mera kaam nahi hai
					// question is kiska kaam hai
					System.out.format("threadId %d and Counter %d\n", threadId, (counter % 3));
					if (threadId == 0) {
						if ((counter % 3) == 1) {
							System.out.println("await Thread--1");
							thread_1_condition.await();
						} else {// counter%3==2
							System.out.println("await Thread--2");
							thread_2_condition.await();
						}
					} else if (threadId == 1) {
						if ((counter % 3) == 0) {
							System.out.println("await Thread--0");
							thread_0_condition.await();
						} else {// counter%3==2
							System.out.println("await Thread--2");
							thread_2_condition.await();
						}
					} else {// threadId == 2
						if ((counter % 3) == 0) {
							System.out.println("await Thread--0");
							thread_0_condition.await();
						} else {// counter%3==1
							System.out.println("await Thread--1");
							thread_1_condition.await();
						}
					}
					// lets wait for that person

				}
				// comes here agar mera kaam hai
				// do your work and signal the correct condition
				if (counter <= max) {
					int counterBeforeIncrement = counter;
					System.out.println("Counter-->" + counter++);
					if (threadId == 0) {
						System.out.println("Signal--1");
						thread_1_condition.signal();
					} else if (threadId == 1) {
						System.out.println("Signal--2");
						thread_2_condition.signal();
					} else {// threadId == 2
						System.out.println("Signal--0");
						thread_0_condition.signal();
					}

				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				mutexLock.unlock();
			}
		}

	}
}

public class PrintUsing3ThreadsWith3Conditions {
	public static void main(String args[]) {
		Worker3Thread.max = 5;
		for (int i = 0; i < 3; i++)
			new Worker3Thread(i).start();
	}
}
