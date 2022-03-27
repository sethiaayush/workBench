package com.aayush.ds.linkedList;

public class DeletionFromLinkedList {
	public static void main(String[] args) {
		SinglyLinkedListNode headNodeSLLDeleteAt1 = SinglyLinkedListNode.getSinglyLinkedListOfLength(10);
		headNodeSLLDeleteAt1 = deleteFirstNodeFromSinglyLinkedList(headNodeSLLDeleteAt1);
		// System.out.println(FindLengthOfLinkedList.findTheLengthOfSinglyLinkedList(headNodeSLLDeleteAt1));

		SinglyLinkedListNode headNodeSLLDeleteAtEnd = SinglyLinkedListNode.getSinglyLinkedListOfLength(40);
		headNodeSLLDeleteAtEnd = deleteLastNodeFromSinglyLinkedList(headNodeSLLDeleteAtEnd);
		// System.out.println(FindLengthOfLinkedList.findTheLengthOfSinglyLinkedList(headNodeSLLDeleteAtEnd));

		SinglyLinkedListNode headNodeSLLDeleteAtLocation = SinglyLinkedListNode.getSinglyLinkedListOfLength(40);
		headNodeSLLDeleteAtEnd = deleteNodeAtLocationFromSinglyLinkedList(headNodeSLLDeleteAtLocation, 0);
		// System.out.println(FindLengthOfLinkedList.findTheLengthOfSinglyLinkedList(headNodeSLLDeleteAtEnd));

		DoublyLinkedListNode headNodeDLLDeleteAt1 = DoublyLinkedListNode.getDoublyLinkedListOfLength(10);
		headNodeDLLDeleteAt1 = deleteFirstNodeFromDoublyLinkedList(headNodeDLLDeleteAt1);
		System.out.println(FindLengthOfLinkedList.findTheLengthOfDoublyLinkedList(headNodeDLLDeleteAt1));

		DoublyLinkedListNode headNodeDLLDeleteAtEnd = DoublyLinkedListNode.getDoublyLinkedListOfLength(4);
		headNodeDLLDeleteAtEnd = deleteLastNodeFromDoublyLinkedList(headNodeDLLDeleteAtEnd);
		System.out.println(FindLengthOfLinkedList.findTheLengthOfDoublyLinkedList(headNodeDLLDeleteAtEnd));

		DoublyLinkedListNode headNodeDLLDeleteAtLocation = DoublyLinkedListNode.getDoublyLinkedListOfLength(4);
		headNodeDLLDeleteAtLocation = deleteNodeAtLocationFromDoublyLinkedList(headNodeDLLDeleteAtLocation, 2);
		System.out.println(FindLengthOfLinkedList.findTheLengthOfDoublyLinkedList(headNodeDLLDeleteAtLocation));

		CircularSinglyLinkedListNode headNodeCSLLDeleteAt1 = CircularSinglyLinkedListNode
				.getCircularSinglyLinkedListOfLength(4);
		headNodeCSLLDeleteAt1 = deleteFirstNodeFromCircularSinglyLinkedList(headNodeCSLLDeleteAt1);
		System.out.println(FindLengthOfLinkedList.findTheLengthOfCircularSinglyLinkedList(headNodeCSLLDeleteAt1));
	}

	// Time Complexity-->O(1)
	// Space Complexity-->O(1)
	public static SinglyLinkedListNode deleteFirstNodeFromSinglyLinkedList(SinglyLinkedListNode headNode) {
		return headNode.getNext();
	}

	// Time Complexity-->O(n)
	// Space Complexity-->O(1)
	public static SinglyLinkedListNode deleteLastNodeFromSinglyLinkedList(SinglyLinkedListNode headNode) {
		// if LL is null
		if (headNode == null) {
			return null;
		}
		// if LL has only 1 node
		if (headNode.getNext() == null) {
			return null;
		}
		// if LL has more than 1 element
		SinglyLinkedListNode currentNode = headNode;
		while (currentNode.getNext().getNext() != null) {
			currentNode = currentNode.getNext();
		}
		currentNode.setNext(null);
		return headNode;
	}

	// Time Complexity-->O(n)
	// Space Complexity-->O(1)
	public static SinglyLinkedListNode deleteNodeAtLocationFromSinglyLinkedList(SinglyLinkedListNode headNode,
			int locationToDeleteAt) {
		// if LL is null
		if (headNode == null) {
			return null;
		}
		// missing implementation for case when locationToDeleteAt > headNode#Length
		SinglyLinkedListNode currentNode = headNode;
		for (int i = 0; i < locationToDeleteAt - 2; i++) {
			currentNode = currentNode.getNext();
		}

		currentNode.setNext(currentNode.getNext().getNext());
		return headNode;
	}

	// Time Complexity-->O(1)
	// Space Complexity-->O(1)
	public static DoublyLinkedListNode deleteFirstNodeFromDoublyLinkedList(DoublyLinkedListNode headNode) {
		DoublyLinkedListNode nextNode = headNode.getNext();
		nextNode.setPrevious(null);
		return nextNode;
	}

	// Time Complexity-->O(n)
	// Space Complexity-->O(1)
	public static DoublyLinkedListNode deleteLastNodeFromDoublyLinkedList(DoublyLinkedListNode headNode) {
		// if DLL is null
		if (headNode == null) {
			return null;
		}
		// if DLL has only 1 node
		if (headNode.getNext() == null) {
			return null;
		}
		// if LL has more than 1 element
		DoublyLinkedListNode currentNode = headNode;
		while (currentNode.getNext() != null) {
			currentNode = currentNode.getNext();
		}
		currentNode.getPrevious().setNext(null);
		currentNode.setPrevious(null);
		return headNode;
	}

	// Time Complexity-->O(n)
	// Space Complexity-->O(1)
	public static DoublyLinkedListNode deleteNodeAtLocationFromDoublyLinkedList(DoublyLinkedListNode headNode,
			int locationToDeleteAt) {
		// if DLL is null
		if (headNode == null) {
			return null;
		}
		// missing implementation for case when locationToDeleteAt > headNode#Length
		DoublyLinkedListNode currentNode = headNode;
		for (int i = 0; i < locationToDeleteAt - 2; i++) {
			currentNode = currentNode.getNext();
		}
		DoublyLinkedListNode nextNode = currentNode.getNext();
		DoublyLinkedListNode nextToNextNode = nextNode.getNext();

		currentNode.setNext(nextToNextNode);
		nextToNextNode.setPrevious(currentNode);
		nextNode.setNext(null);
		nextNode.setPrevious(null);
		return headNode;
	}

	// Time Complexity-->O(n)
	// Space Complexity-->O(1)
	public static CircularSinglyLinkedListNode deleteFirstNodeFromCircularSinglyLinkedList(
			CircularSinglyLinkedListNode headNode) {
		CircularSinglyLinkedListNode currentNode = headNode.getNext();
		while (currentNode.getNext() != headNode) {
			currentNode = currentNode.getNext();
		}
		currentNode.setNext(currentNode.getNext().getNext());
		return currentNode.getNext();
	}
}
