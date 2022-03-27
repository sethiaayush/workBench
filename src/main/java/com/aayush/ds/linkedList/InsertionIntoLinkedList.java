package com.aayush.ds.linkedList;

public class InsertionIntoLinkedList {
	public static void main(String[] args) {
		SinglyLinkedListNode headNodeSLLInsertAt1 = SinglyLinkedListNode.getSinglyLinkedListOfLength(10);
		headNodeSLLInsertAt1 = insertAtTheStartOfSinglyLinkedList(headNodeSLLInsertAt1);
		System.out.println(FindLengthOfLinkedList.findTheLengthOfSinglyLinkedList(headNodeSLLInsertAt1));

		SinglyLinkedListNode headNodeSLLInsertAtEnd = SinglyLinkedListNode.getSinglyLinkedListOfLength(10);
		System.out.println(FindLengthOfLinkedList
				.findTheLengthOfSinglyLinkedList(insertAtTheEndOfSinglyLinkedList(headNodeSLLInsertAtEnd)));

		SinglyLinkedListNode headNodeSLLInsertAtLocation = SinglyLinkedListNode.getSinglyLinkedListOfLength(10);
		System.out.println(FindLengthOfLinkedList.findTheLengthOfSinglyLinkedList(
				insertAtTheLocationOfSinglyLinkedList(headNodeSLLInsertAtLocation, 5)));

		DoublyLinkedListNode headNodeDLLInsertAt1 = DoublyLinkedListNode.getDoublyLinkedListOfLength(12);
		headNodeDLLInsertAt1 = insertAtTheStartOfDoublyLinkedList(headNodeDLLInsertAt1);
		System.out.println(FindLengthOfLinkedList.findTheLengthOfDoublyLinkedList(headNodeDLLInsertAt1));

		DoublyLinkedListNode headNodeDLLInsertAtEnd = DoublyLinkedListNode.getDoublyLinkedListOfLength(12);
		System.out.println(FindLengthOfLinkedList
				.findTheLengthOfDoublyLinkedList(insertAtTheEndOfDoublyLinkedList(headNodeDLLInsertAtEnd)));

		DoublyLinkedListNode headNodeDLLInsertAtLocation = DoublyLinkedListNode.getDoublyLinkedListOfLength(4);
		System.out.println(FindLengthOfLinkedList.findTheLengthOfDoublyLinkedList(
				insertAtTheLocationOfDoublyLinkedList(headNodeDLLInsertAtLocation, 2)));

		CircularSinglyLinkedListNode headNodeCSLLInsertAt1 = CircularSinglyLinkedListNode
				.getCircularSinglyLinkedListOfLength(4000);
		headNodeCSLLInsertAt1 = insertAtStartOfCircularSinglyLinkedList(headNodeCSLLInsertAt1);
		System.out.println(FindLengthOfLinkedList.findTheLengthOfCircularSinglyLinkedList(headNodeCSLLInsertAt1));

		CircularSinglyLinkedListNode headNodeCSLLInsertAtEnd = CircularSinglyLinkedListNode
				.getCircularSinglyLinkedListOfLength(4);
		headNodeCSLLInsertAtEnd = insertAtEndOfCircularSinglyLinkedList(headNodeCSLLInsertAtEnd);
		System.out.println(FindLengthOfLinkedList.findTheLengthOfCircularSinglyLinkedList(headNodeCSLLInsertAtEnd));

	}

	// Time Complexity-->O(1)
	// Space Complexity-->O(1)
	public static SinglyLinkedListNode insertAtTheStartOfSinglyLinkedList(SinglyLinkedListNode headNode) {
		return new SinglyLinkedListNode(1000, headNode);
	}

	// Time Complexity-->O(n)
	// Space Complexity-->O(1)
	public static SinglyLinkedListNode insertAtTheEndOfSinglyLinkedList(SinglyLinkedListNode headNode) {
		SinglyLinkedListNode lastNode = headNode;
		SinglyLinkedListNode currentNode = headNode;
		while ((currentNode = currentNode.getNext()) != null) {
			lastNode = currentNode;
		}
		SinglyLinkedListNode newNode = new SinglyLinkedListNode(1000, null);
		lastNode.setNext(newNode);
		return headNode;
	}

	// Time Complexity-->O(n)
	// Space Complexity-->O(1)
	public static SinglyLinkedListNode insertAtTheLocationOfSinglyLinkedList(SinglyLinkedListNode headNode,
			int atLocation) {
		if (headNode == null) {
			return new SinglyLinkedListNode(1000);
		}
		SinglyLinkedListNode insertAfter = headNode;
		for (int i = 2; i < atLocation; i++) {
			insertAfter = insertAfter.getNext();
		}
		insertAfter.setNext(new SinglyLinkedListNode(1000, insertAfter.getNext()));
		return headNode;
	}

	// Time Complexity-->O(1)
	// Space Complexity-->O(1)
	public static DoublyLinkedListNode insertAtTheStartOfDoublyLinkedList(DoublyLinkedListNode headNode) {
		return new DoublyLinkedListNode(1000, headNode);
	}

	// Time Complexity-->O(n)
	// Space Complexity-->O(1)
	public static DoublyLinkedListNode insertAtTheEndOfDoublyLinkedList(DoublyLinkedListNode headNode) {
		DoublyLinkedListNode currentNode = headNode;
		DoublyLinkedListNode lastNode = headNode;
		while ((currentNode = currentNode.getNext()) != null) {
			lastNode = currentNode;
		}
		DoublyLinkedListNode newNode = new DoublyLinkedListNode(1000, null, lastNode);
		lastNode.setNext(newNode);
		return headNode;
	}

	// Time Complexity-->O(n)
	// Space Complexity-->O(1)
	public static DoublyLinkedListNode insertAtTheLocationOfDoublyLinkedList(DoublyLinkedListNode headNode,
			int insertAtLocation) {
		if (headNode == null) {
			return new DoublyLinkedListNode(1000);
		}
		DoublyLinkedListNode insertAfter = headNode;
		for (int i = 2; i < insertAtLocation; i++) {
			insertAfter = insertAfter.getNext();
		}
		insertAfter.setNext(new DoublyLinkedListNode(1000, insertAfter.getNext(), insertAfter));
		return headNode;
	}

	// Time Complexity-->O(n)
	// Space Complexity-->O(1)
	public static CircularSinglyLinkedListNode insertAtStartOfCircularSinglyLinkedList(
			CircularSinglyLinkedListNode headNode) {
		CircularSinglyLinkedListNode newNode = new CircularSinglyLinkedListNode(1000, headNode);
		CircularSinglyLinkedListNode currentNode = headNode.getNext();
		while (currentNode.getNext() != headNode) {
			currentNode = currentNode.getNext();
		}
		currentNode.setNext(newNode);
		return newNode;
	}

	// Time Complexity-->O(n)
	// Space Complexity-->O(1)
	public static CircularSinglyLinkedListNode insertAtEndOfCircularSinglyLinkedList(
			CircularSinglyLinkedListNode headNode) {
		CircularSinglyLinkedListNode newNode = new CircularSinglyLinkedListNode(1000);
		CircularSinglyLinkedListNode currentNode = headNode.getNext();
		while (currentNode.getNext() != headNode) {
			currentNode = currentNode.getNext();
		}
		currentNode.setNext(newNode);
		newNode.setNext(headNode);
		return headNode;
	}

	// Time Complexity-->O(n)
	// Space Complexity-->O(1)
	public static CircularSinglyLinkedListNode insertAtLocationOfCircularSinglyLinkedList(
			CircularSinglyLinkedListNode headNode, int insertAtLocation) {
		CircularSinglyLinkedListNode newNode = new CircularSinglyLinkedListNode(1000);
		if (headNode == null) {

			newNode.setNext(newNode);
			return newNode;
		}
		CircularSinglyLinkedListNode insertAfter = headNode;
		for (int i = 2; i < insertAtLocation; i++) {
			insertAfter = insertAfter.getNext();
		}
		newNode.setNext(insertAfter.getNext());
		insertAfter.setNext(newNode);
		return headNode;

	}
}
