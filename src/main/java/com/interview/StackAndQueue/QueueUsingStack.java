package com.interview.StackAndQueue;

import java.util.Stack;

public class QueueUsingStack {

	/*
	 * Time Complexity : 
	 * In method 1: enqueue - O(N), dequeue - O(1)
	 * In method 2: enqueue - O(1), dequeue - O(N)
	 */
	
	//Method 1 --> By making enQueue operation costly
	
	Stack<Integer> s1 = new Stack<Integer>();  
	Stack<Integer> s2 = new Stack<Integer>();

	public void enQueue(int x) {
		// Move all elements from s1 to s2
		while (!s1.isEmpty()) {
			s2.push(s1.pop());
		}

		// Push item into s1
		s1.push(x);

		// Push everything back to s1
		while (!s2.isEmpty()) {
			s1.push(s2.pop());
		}
	}
	public int deQueue() {
		// if first stack is empty
		if (s1.isEmpty()) {
			System.out.println("Queue is Empty");
			System.exit(0);
		}

		// Return top of s1
		int x = s1.peek();
		s1.pop();
		return x;
	}
	
	//Method 2 --> By making deQueue operation costly
	
	public void enQueueMethod2(int x) {
		s1.push(x);
	}

	public int deQueueMethod2() {
		int x;

		/* If both stacks are empty then error */
		if (s1.isEmpty() && s2.isEmpty()) {
			System.out.println("Queue is empty");
			System.exit(0);
		}

		/*
		 * Move elements from stack1 to stack 2 only if stack2 is empty
		 */
		if (s2.isEmpty()) {
			while (!s1.isEmpty()) {
				x = s1.pop();
				s2.push(x);
			}
		}
		x = s2.pop();
		return x;
	}
	public static void main(String args[]) 
    { 
		QueueUsingStack queue = new QueueUsingStack(); 
		queue.enQueueMethod2(1); 
		queue.enQueueMethod2(2); 
		queue.enQueueMethod2(3); 
  
        System.out.print(queue.deQueueMethod2() + " "); 
        System.out.print(queue.deQueueMethod2() + " "); 
        System.out.println(queue.deQueueMethod2() + " "); 
    } 
	
}
