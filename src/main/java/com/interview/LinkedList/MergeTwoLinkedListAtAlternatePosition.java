package com.interview.LinkedList;

/*
 * https://www.geeksforgeeks.org/merge-a-linked-list-into-another-linked-list-at-alternate-positions/
 * 
 * For example, if first list is 5->7->17->13->11 and second is 12->10->2->4->6, 
 * the first list should become 5->12->7->10->17->2->13->4->11->6 and second list should become empty. 
 * The nodes of second list should only be inserted when there are positions available. 
 * For example, if the first list is 1->2->3 and
 * second list is 4->5->6->7->8, then first list should become 1->4->2->5->3->6 and second list to 7->8.
 */
public class MergeTwoLinkedListAtAlternatePosition {

	public static void merge(Node node1, Node node2) {
		Node p_curr = node1, q_curr = node2;
		Node p_next, q_next;

		while (p_curr != null && q_curr != null) {

			// Save next pointers
			p_next = p_curr.next;
			q_next = q_curr.next;

			// make q_curr as next of p_curr
			q_curr.next = p_next; // change next pointer of q_curr
			p_curr.next = q_curr; // change next pointer of p_curr

			// update current pointers for next iteration
			p_curr = p_next;
			q_curr = q_next;
		}
		node2 = q_curr;
	} 
	
	public static void main(String args[]) {
		CustomLinkedList list1 = new CustomLinkedList(1);
		list1.addEnd(2);
		list1.addEnd(3);
		
		PrintLinkedList.printList(list1);
		
		CustomLinkedList list2 = new CustomLinkedList(4);
		list2.addEnd(5);
		list2.addEnd(6);
		list2.addEnd(7);
		list2.addEnd(8);
		
		PrintLinkedList.printList(list2);
		
		merge(list1.head, list2.head);

		System.out.println("Modified first linked list:");
		PrintLinkedList.printList(list1);

		System.out.println("Modified second linked list:");
		PrintLinkedList.printList(list2);
	}
}
