package com.interview.LinkedList;

public class CustomLinkedList {

	Node head;

	public CustomLinkedList(int data) {
		head = new Node(data);
	}
	/*
	 * Add an element at the beggning of the list
	 * Time Complexity : O(1)
	 */
	public void addFront(int data) {
		Node temp = new Node(data);
		temp.setNext(head);
		head = temp;
	}
	/*
	 * Add an element at the end of the list
	 * Time Complexity : O(n)
	 */
	public void addEnd(int data) {
		Node newNode = new Node(data);
		newNode.setNext(null); // It will be last node of the List.
		
		/*If the Linked List is empty, then make the 
          new node as head */
		if (head == null) 
	    { 
	        head = new Node(data); 
	        return; 
	    }
		
		Node temp = head;
		while(temp.getNext()!= null) {
			temp = temp.getNext();
		}
		temp.setNext(newNode);
	}
	/*
	 * Add an element after a given Node.
	 * Time Complexity : O(n)
	 */
	public void addAfter(Node insertAfter, int data) {
		
		if(insertAfter == null) {
			System.out.println("Invalid Node!! It can not be null.");
		}
		Node newNode = new Node(data);
		
		Node temp = head;
		while(temp!= null) {
			if(temp.getData() == insertAfter.getData()) {
				newNode.setNext(temp.getNext());
				temp.setNext(newNode);
				break;
			}
			temp = temp.getNext();
		}
	}
	/*
	 * Given a ‘key’, delete the first occurrence of the key in linked list.
	 */
	public void deleteNode(int data){
		
		Node temp = head;
		Node prev = null;
		
		// If head node itself holds the key to be deleted 
        if (temp != null && temp.getData() == data) 
        { 
            head = temp.getNext(); // Changed head 
            return; 
        } 
		
		while(temp!= null && temp.getData()!=data) {
			prev = temp;
			temp = temp.getNext();
		}
		if (temp == null) {
			System.out.println("Invalid key to delete..!!");
		}
		prev.setNext(temp.getNext());
	}	
	/*
	 * Delete the node from given position.
	 */
	public void deleteNodeAtPosition(int position) {
		int count = 0;
		Node temp = head;
		Node prev = null;
		
		if(temp!= null && position == 1){
			head = temp.getNext();
			return;
		}
		while(temp!=null && (++count != position)) {
			prev = temp;
			temp = temp.getNext();
		}
		
		// If position is more than number of ndoes 
        if (temp == null || temp.getNext() == null) 
            return; 
		
		prev.setNext(temp.getNext());
	}
}

class Node {

	private int data;
	private Node next;

	public Node(int data) {
		this.data = data;
		this.next = null;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public int getData() {
		return data;
	}
}