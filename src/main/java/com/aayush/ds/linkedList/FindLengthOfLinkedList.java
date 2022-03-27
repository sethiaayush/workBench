package com.aayush.ds.linkedList;

//Time Complexity--O(n)--for scanning the list of size n
//Space Complexity--O(1)--for temporary variable

public class FindLengthOfLinkedList {
	public static void main(String[] args) {
		SinglyLinkedListNode sLLheadNode = SinglyLinkedListNode.getSinglyLinkedListOfLength(150);
		System.out.println(findTheLengthOfSinglyLinkedList(sLLheadNode));

		CircularSinglyLinkedListNode circularSLL = CircularSinglyLinkedListNode
				.getCircularSinglyLinkedListOfLength(40000);
		System.out.println(findTheLengthOfCircularSinglyLinkedList(circularSLL));

	}

	public static int findTheLengthOfSinglyLinkedList(SinglyLinkedListNode headNode) {
		int length = 0;
		SinglyLinkedListNode currentNode = headNode;
		while (currentNode != null) {
			length++;
			currentNode = currentNode.getNext();
		}
		return length;
	}

	public static int findTheLengthOfDoublyLinkedList(DoublyLinkedListNode headNode) {
		int length = 0;
		DoublyLinkedListNode currentNode = headNode;
		while (currentNode != null) {
			length++;
			currentNode = currentNode.getNext();
		}
		return length;
	}

	public static int findTheLengthOfCircularSinglyLinkedList(CircularSinglyLinkedListNode headNode) {
		int length = 0;
		if (headNode == null) {
			return length;
		}
		CircularSinglyLinkedListNode currentNode = headNode.getNext();
		// to add length of first getNext
		if (currentNode != null) {
			length++;
		}
		while (currentNode != headNode) {
			length++;
			currentNode = currentNode.getNext();
		}
		return length;
	}

}
