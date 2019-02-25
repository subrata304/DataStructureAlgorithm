package com.interview.LinkedList;

public class IntersectionOfLinkedList {

	
	public static void findIntersectionPoint(Node head1, Node head2){
		
		int length1 = FindLengthLinkedList.findLengthRecursion(head1);
		int length2 = FindLengthLinkedList.findLengthRecursion(head2);
		
		int diff;
		Node interSectionNode;
		if(length1 > length2) {
			diff = length1 - length2;
			interSectionNode = findNode(head1, head2, diff);
		}else {
			diff = length2 - length1;
			interSectionNode = findNode(head2, head1, diff);
		}
		
		System.out.println("Intersection point is: "+ interSectionNode.getData());
		
	}
	
	private static Node findNode(Node head1, Node head2, int diff) {
		Node current1 = head1;
		Node current2 = head2;
		
		for(int i = 0 ; i< diff ; i++) {
			current1 = current1.getNext();
		}
		while (current1 != null && current2 != null) { 
            if (current1.getData() == current2.getData()) { 
                return current1; 
            } 
            current1 = current1.getNext(); 
            current2 = current2.getNext(); 
        }
		return null;
		
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
		
		CustomLinkedList list2 = new CustomLinkedList(2);
		list2.addEnd(4);
		list2.addEnd(8);
		list2.addEnd(6);
		list2.addEnd(9);
		list2.addEnd(10);
		
		findIntersectionPoint(list1.head, list2.head);
	}
}
