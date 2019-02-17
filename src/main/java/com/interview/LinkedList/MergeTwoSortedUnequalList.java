package com.interview.LinkedList;

/*
 * https://www.geeksforgeeks.org/merge-two-sorted-lists-place/
 * https://www.geeksforgeeks.org/merge-two-sorted-linked-lists/
 */

public class MergeTwoSortedUnequalList {

	public static void main(String[] args) {
		CustomLinkedList list1 = new CustomLinkedList(1);
		list1.addEnd(3);
		list1.addEnd(5);
		list1.addEnd(6);
		list1.addEnd(9);
		
		CustomLinkedList list2 = new CustomLinkedList(2);
		list2.addEnd(4);
		list2.addEnd(6);
		list2.addEnd(8);
		list2.addEnd(10);
		list2.addEnd(12);
		
		Node mergedNode = merge(list1.head, list2.head);
		PrintLinkedList.printList(mergedNode);
	}
	
	public static Node merge(Node l1, Node l2) {
		
		if(l1 == null) {
			return l2;
		}else if(l2 == null) {
			return l1;
		}
		if(l1.getData() < l2.getData()) {
			
			l1.setNext(merge(l1.getNext(), l2));
			return l1;
		}else {
			l2.setNext(merge(l2.getNext(), l1));
			return l2;
		}
	}
}
