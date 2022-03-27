package com.aayush.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSQueueWithArrayList {

	public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
		Queue<Integer> queue = new LinkedList<>();
		ArrayList<Integer> traversed = new ArrayList<>();
		boolean[] visited = new boolean[V];
		visited[0] = true;
		queue.offer(0);
		while (!queue.isEmpty()) {
			int queueElement = queue.poll();
			traversed.add(queueElement);

			// find neighbour and add them to the queue
			for (Integer neighbour : getNeighbour(queueElement, adj)) {
				if (!visited[neighbour]) {
					visited[neighbour] = true;
					queue.offer(neighbour);
				}
			}
		}
		return traversed;
	}

	public static ArrayList<Integer> getNeighbour(int V, ArrayList<ArrayList<Integer>> adj) {
		return adj.get(V);
	}
}
