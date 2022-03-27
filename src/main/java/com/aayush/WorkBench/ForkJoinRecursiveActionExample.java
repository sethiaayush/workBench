package com.aayush.WorkBench;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.logging.Logger;

public class ForkJoinRecursiveActionExample extends RecursiveAction {

	private static final long serialVersionUID = -6410512274038616769L;
	private String workload = "";
	private static final int THRESHOLD = 4;

	private static Logger logger = Logger.getAnonymousLogger();

	public ForkJoinRecursiveActionExample(String workload) {
		this.workload = workload;
	}

	@Override
	protected void compute() {
		if (workload.length() > THRESHOLD) {
			ForkJoinTask.invokeAll(createSubtasks());
		} else {
			processing(workload);
		}
	}

	private List<ForkJoinRecursiveActionExample> createSubtasks() {
		List<ForkJoinRecursiveActionExample> subtasks = new ArrayList<>();

		String partOne = workload.substring(0, workload.length() / 2);
		String partTwo = workload.substring(workload.length() / 2, workload.length());

		subtasks.add(new ForkJoinRecursiveActionExample(partOne));
		subtasks.add(new ForkJoinRecursiveActionExample(partTwo));

		return subtasks;
	}

	private void processing(String work) {
		String result = work.toUpperCase();
		logger.info("This result - (" + result + ") - was processed by " + Thread.currentThread().getName());
	}
}
