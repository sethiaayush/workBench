package com.aayush.ds.linkedList;

import java.util.Random;

public class SinglyLinkedListNode {

	private int data;
	private SinglyLinkedListNode next;

	public SinglyLinkedListNode(int data, SinglyLinkedListNode next) {
		this(data);
		this.next = next;
	}

	public SinglyLinkedListNode(int data) {
		super();
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public SinglyLinkedListNode getNext() {
		return next;
	}

	public void setNext(SinglyLinkedListNode next) {
		this.next = next;
	}

	public static SinglyLinkedListNode getSinglyLinkedListOfLength(int length) {
		if(length==0) {
			return null;
		}
		SinglyLinkedListNode headNode = new SinglyLinkedListNode(new Random().nextInt(100));
		SinglyLinkedListNode currentNode = headNode;
		for (int i = 0; i < length - 1; i++) {
			SinglyLinkedListNode newNode = new SinglyLinkedListNode(new Random().nextInt(100));
			currentNode.setNext(newNode);
			currentNode = newNode;
		}
		return headNode;
	}

	public static void main(String[] args) {
		getSinglyLinkedListOfLength(4);
	}
}
