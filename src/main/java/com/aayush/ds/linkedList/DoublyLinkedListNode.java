package com.aayush.ds.linkedList;

import java.util.Random;

public class DoublyLinkedListNode {

	private int data;
	private DoublyLinkedListNode next;
	private DoublyLinkedListNode previous;

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public DoublyLinkedListNode getNext() {
		return next;
	}

	public void setNext(DoublyLinkedListNode next) {
		this.next = next;
	}

	public DoublyLinkedListNode getPrevious() {
		return previous;
	}

	public void setPrevious(DoublyLinkedListNode previous) {
		this.previous = previous;
	}

	public static DoublyLinkedListNode getDoublyLinkedListOfLength(int length) {
		if (length == 0) {
			return null;
		}

		DoublyLinkedListNode headNode = new DoublyLinkedListNode(new Random().nextInt(100));
		DoublyLinkedListNode currentNode = headNode;
		for (int i = 0; i < length - 1; i++) {
			DoublyLinkedListNode newNode = new DoublyLinkedListNode(new Random().nextInt(100));
			currentNode.setNext(newNode);
			newNode.setPrevious(currentNode);
			currentNode = newNode;
		}
		return headNode;
	}

	public DoublyLinkedListNode(int data, DoublyLinkedListNode next) {
		this(data);
		this.next = next;
	}

	public DoublyLinkedListNode(int data, DoublyLinkedListNode next, DoublyLinkedListNode previous) {
		this(data, next);
		this.previous = previous;
	}

	public DoublyLinkedListNode(int data) {
		super();
		this.data = data;
	}

}
