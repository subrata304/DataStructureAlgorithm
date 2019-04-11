package com.interview.LinkedList;

public class DeleteAlternateNodefromLinkedList {

	
	// Approach 1: Iterative
	
	public static void deleteAlternativeIterative(Node head) {
		if (head == null)
			return;

		Node prev = head;
		Node now = head.next;

		while (prev != null && now != null) {
			/* Change next link of previus node */
			prev.next = now.next;

			/* Free node */
			now = null;

			/* Update prev and now */
			prev = prev.next;
			if (prev != null)
				now = prev.next;
		}
	} 
	
	
	//Approach 2: Recursive

	public static void deleteAlternativeRecursive(Node head) {
		if (head == null)
			return;

		Node node = head.next;

		if (node == null)
			return;

		/* Change the next link of head */
		head.next = node.next;

		/* Recursively call for the new next of head */
		deleteAlternativeRecursive(head.next);
	}
	
	
	public static void main(String[] args) {
		CustomLinkedList list1 = new CustomLinkedList(1);
		list1.addEnd(3);
		list1.addEnd(16);
		list1.addEnd(18);
		list1.addEnd(5);
		list1.addEnd(6);
		list1.addEnd(9);
		list1.addEnd(10);
		
		PrintLinkedList.printList(list1.head);
		
		deleteAlternativeIterative(list1.head);
		
		PrintLinkedList.printList(list1.head);
		
		deleteAlternativeRecursive(list1.head);
		
		PrintLinkedList.printList(list1.head);

	}
}
