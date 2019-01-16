package com.interview.LinkedList;

public class PrintLinkedList {

	public static void printList(CustomLinkedList list) {
		Node temp = list.head;
		while(temp != null) {
			System.out.print(temp.getData());
			if(temp.getNext()!= null) {
				System.out.print(" -> ");
			}
			temp = temp.getNext();
		}
	}
}
