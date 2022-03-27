package com.aayush.ds.tree;

public class BinaryTreeToDLL {

	Node dll = new Node(Integer.MIN_VALUE);
	Node head;

	Node bToDLL(Node root) {
		inorderTraversal(root);

		return dll;

	}

	void inorderTraversal(Node treeRootNode) {

		if (treeRootNode == null) {
			return;
		}
		if (treeRootNode.left != null) {
			inorderTraversal(treeRootNode.left);
		}

		if (dll.data == Integer.MIN_VALUE) {
			dll = new Node(treeRootNode.data);
			head = dll;
			// System.out.print("--"+treeRootNode.data);
		} else {
			// System.out.print("---"+treeRootNode.data);
			Node nextPoint = new Node(treeRootNode.data);
			head.right = nextPoint;

			nextPoint.left = head;
			head = head.right;
		}

		if (treeRootNode.right != null) {
			inorderTraversal(treeRootNode.right);
		}
	}
}

class Node {
	Node left, right;
	int data;

	Node(int d) {
		data = d;
		left = right = null;
	}

}