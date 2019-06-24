package com.interview.LinkedList;

public class RemoveLoopInaLinkedList {

	public static void main(String[] args) {
		CustomLinkedList list1 = new CustomLinkedList(1);
		list1.addEnd(2);
		list1.addEnd(3);
		list1.addEnd(4);
		list1.addEnd(5);

		list1.head.next.next.next.next.next = list1.head.next;
		detectAndRemoveLoop(list1.head);
		PrintLinkedList.printList(list1.head);
	}

	public static int detectAndRemoveLoop(Node node) {
		Node slow = node, fast = node;
		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			// If slow and fast meet at same point then loop is present
			if (slow == fast) {
				removeLoop(slow, node);
				return 1;
			}
		}
		return 0;
	}

	public static void removeLoop(Node loop, Node curr) {
		Node ptr1 = null, ptr2 = null;

		/*
		 * Set a pointer to the begging of the Linked List and move it one by one to find
		 * the first node which is part of the Linked List
		 */
		ptr1 = curr;
		while (1 == 1) {

			/*
			 * Now start a pointer from loop_node and check if it ever reaches ptr2
			 */
			ptr2 = loop;
			while (ptr2.next != loop && ptr2.next != ptr1) {
				ptr2 = ptr2.next;
			}

			/*
			 * If ptr2 reached ptr1 then there is a loop. So break the loop
			 */
			if (ptr2.next == ptr1) {
				break;
			}

			/* If ptr2 did't reach ptr1 then try the next node after ptr1 */
			ptr1 = ptr1.next;
		}

		/*
		 * After the end of loop ptr2 is the last node of the loop. So make next of ptr2
		 * as NULL
		 */
		ptr2.next = null;
	}
}
