package com.aayush.ds.linkedList;

import java.util.Random;

public class CircularSinglyLinkedListNode {

	private int data;
	private CircularSinglyLinkedListNode next;

	public CircularSinglyLinkedListNode(int data) {
		super();
		this.data = data;
	}

	public CircularSinglyLinkedListNode(int data, CircularSinglyLinkedListNode next) {
		this(data);
		this.next = next;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public CircularSinglyLinkedListNode getNext() {
		return next;
	}

	public void setNext(CircularSinglyLinkedListNode next) {
		this.next = next;
	}

	public static CircularSinglyLinkedListNode getCircularSinglyLinkedListOfLength(int length) {
		if (length == 0) {
			return null;
		}
		CircularSinglyLinkedListNode headNode = new CircularSinglyLinkedListNode(new Random().nextInt(100));
		CircularSinglyLinkedListNode currentNode = headNode;
		for (int i = 0; i < length - 1; i++) {
			CircularSinglyLinkedListNode newNode = new CircularSinglyLinkedListNode(new Random().nextInt(100));
			currentNode.setNext(newNode);
			currentNode = newNode;
		}
		currentNode.setNext(headNode);
		return headNode;
	}

	public static void main(String[] args) {
		getCircularSinglyLinkedListOfLength(4);
	}
}
