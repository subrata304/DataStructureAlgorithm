package com.interview.LinkedList;

public class LinkedListCreateUtil {

	/*
	 * This method will create a linkedlist of a given size and 
	 * list values will be in the 'range'
	 */
	public static CustomLinkedList createRandomList(int length, int range) {
		
		CustomLinkedList list = new CustomLinkedList(getRandomNumber(range)); // Head
		int i = 1;
		while(i <= length -1) {
			list.addEnd(getRandomNumber(range));
			i++;
		}
		
		return list;
	}
	
	private static int getRandomNumber(int range){
		return (int )(Math.random() * range + 1);
	}
	/*
	 * This method will create a Singly Linkedlist of 8 size and values from 1 to 8.
	 */
	
	public static CustomLinkedList createStaticList() {
		CustomLinkedList list = new CustomLinkedList(1);
		list.addEnd(2);
		list.addEnd(3);
		list.addEnd(4);
		list.addEnd(5);
		list.addEnd(6);
		list.addEnd(7);
		list.addEnd(8);
		
		return list;
	}
}
