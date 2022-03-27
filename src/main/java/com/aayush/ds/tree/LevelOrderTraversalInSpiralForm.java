package com.aayush.ds.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class LevelOrderTraversalInSpiralForm {
	Deque<Node> deque = new LinkedList<>();
	ArrayList<Integer> toReturn = new ArrayList<>();

	// Function to return a list containing the level order
	// traversal in spiral form.
	ArrayList<Integer> findSpiral(Node root) {
		Deque<Node> dq = new ArrayDeque<>();
		if (root == null) {
			return toReturn;
		}
		// Insert the root of the tree into the deque
		dq.offer(root);

		// Create a variable that will switch in each iteration
		boolean reverse = true;

		// Start iteration
		while (!dq.isEmpty()) {

			// Save the size of the deque here itself, as in further steps the size
			// of deque will frequently change
			int n = dq.size();

			// If we are printing left to right
			if (!reverse) {

				// Iterate from left to right
				for (int i = 0; i < n; i++) {

					// Insert the child from the back of the deque
					// Left child first
					if (dq.peekFirst().left != null)
						dq.offerLast(dq.peekFirst().left);

					if (dq.peekFirst().right != null)
						dq.offerLast(dq.peekFirst().right);

					// Print the current processed element
					toReturn.add(dq.pollFirst().data);

				}
				// Switch reverse for next traversal
				reverse = !reverse;

			} else {

				// If we are printing right to left
				// Iterate the deque in reverse order and insert the children
				// from the front
				while (n-- > 0) {
					// Insert the child in the front of the deque
					// Right child first
					if (dq.peekLast().right != null)
						dq.offerFirst(dq.peekLast().right);

					if (dq.peekLast().left != null)
						dq.offerFirst(dq.peekLast().left);

					// Print the current processed element
					toReturn.add(dq.pollLast().data);

				}
				// Switch reverse for next traversal
				reverse = !reverse;

			}
		}
		return toReturn;
	}
}
