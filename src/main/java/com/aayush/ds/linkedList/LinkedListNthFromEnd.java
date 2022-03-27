package com.aayush.ds.linkedList;

public class LinkedListNthFromEnd {

	static Node head;

	public void push(int new_data) {
		/*
		 * 1 & 2: Allocate the Node & Put in the data
		 */
		Node new_node = new Node(new_data);

		/* 3. Make next of new Node as head */
		new_node.next = head;

		/* 4. Move the head to point to new Node */
		head = new_node;
	}

	public static void main(String[] args) {
		LinkedListNthFromEnd llist = new LinkedListNthFromEnd();
		llist.push(20);
		llist.push(4);
		llist.push(15);
		llist.push(35);
		System.out.println(llist.getNthFromLast(head, 4));
	}

	int getNthFromLast(Node head, int n) {
		Node main_ptr = head;
		Node ref_ptr = head;

		int count = 0;
		if (head != null) {
			while (count < n) {
				if (ref_ptr == null) {

					return -1;
				}
				ref_ptr = ref_ptr.next;
				count++;
			}

			if (ref_ptr == null) {

				if (head != null)
					return -1;
			} else {

				while (ref_ptr != null) {
					main_ptr = main_ptr.next;
					ref_ptr = ref_ptr.next;
				}
				return main_ptr.data;
			}
		}
		return -1;
	}
}

class Node {
	int data;
	Node next;

	Node(int d) {
		data = d;
		next = null;
	}
}
