package com.interview.LinkedList;

public class FindLengthLinkedList {

	public static int findLength(CustomLinkedList list) {

		int length = 0;

		if (list == null || list.head == null) {
			System.out.println("Invalid LinkedList..!");
			return -1;
		}

		return findLengthRecursion(list.head);
	}

	private static int findLengthRecursion(Node head) {

		Node temp = head;

		if (temp == null) {
			return 0;
		} else {
			return 1 + findLengthRecursion(temp.getNext());
		}
	}
}
