package com.interview.LinkedList;


/*
 * Pairwise reverse the linked List, eg : 1->2->3->4->NULL to 2->1->4->3->NULL.
 * https://www.geeksforgeeks.org/pairwise-swap-elements-of-a-given-linked-list-by-changing-links/
 * https://www.geeksforgeeks.org/pairwise-swap-adjacent-nodes-of-a-linked-list-by-changing-pointers-set-2/
 * https://www.youtube.com/watch?v=jiLloHVmLDc
 */
public class PairWiseReverse {

	public static void main(String[] args) {
		CustomLinkedList list1 = new CustomLinkedList(1);
		list1.addEnd(2);
		list1.addEnd(3);
		list1.addEnd(4);
		list1.addEnd(5);
		list1.addEnd(6);
		list1.addEnd(7);
		list1.addEnd(8);
		
		//pairWiseSwapByData(list1.head);
		
		pairWiseReverse(list1.head);
	}
	// Swap Pair by Data
	private static void pairWiseSwapByData(Node head) {
		
		Node temp = head;
		while(temp!=null && temp.getNext()!= null) {
			int data = temp.getData();
			temp.data = temp.getNext().getData();
			temp.getNext().data = data;
			
			temp = temp.getNext().getNext();
		}
		PrintLinkedList.printList(head);

	}
	// Swap Pair by Changing Pointers
	// Time Complexity - O(N)
	private static void pairWiseReverse(Node head) {
		
		Node prev = head;
		Node newStart = prev.getNext();
		Node curr; Node temp;
		
		while(true) {
			curr = prev.getNext();
			temp = curr.getNext();
			curr.next = prev;
			
			if(temp == null || temp.getNext() == null) {
				prev.next = temp;
				break;
			}
			
			prev.next = temp.getNext();
			prev = temp;
		}
		PrintLinkedList.printList(newStart);
	}
	
}
