package com.interview.StackAndQueue;

import java.util.Stack;

/*
 * Get Minimum element from a stack in O(1) Time Complexity.
 */

public class GetMinimumFromStackInConstantTimeComplexity {

	public static void main(String[] args) {
		MyStackWithoutExtraSpace s = new MyStackWithoutExtraSpace();
		s.push(3);
		s.push(5);
		s.getMinimum();
		s.push(2);
		s.push(1);
		s.getMinimum();
		s.pop();
		s.getMinimum();
		s.pop();
		s.peek();
	}

}

// Below Implementation is with Space Complexity.
class MyStack {
	Stack<Integer> originalStack;
	Stack<Integer> minStack;

	public MyStack() {
		originalStack = new Stack<Integer>();
		minStack = new Stack<Integer>();
	}

	void push(Integer n) {
		originalStack.push(n);
		if (minStack.size() == 0 || n < minStack.peek()) {
			minStack.push(n);
		}
		System.out.println("Pushed Element is: " + n);
	}

	int pop() {
		int number = originalStack.pop();

		if (minStack.size() != 0 && minStack.peek() == number) {
			minStack.pop();
		}
		System.out.println("Popped Element is: " + number);
		return number;
	}

	int peek() {
		int number = originalStack.peek();
		System.out.println("Peeked Element is: " + number);
		return number;
	}

	int getMinimum() {
		int number = minStack.peek();
		System.out.println("Minimum Element is: " + number);
		return number;
	}
}

// Below implementation is without Extra Space Complexity

class MyStackWithoutExtraSpace {
	Stack<Integer> s;
	Integer minEle;

	// Constructor
	MyStackWithoutExtraSpace() {
		s = new Stack<Integer>();
	}

	// Prints minimum element of MyStack
	void getMinimum() {
		// Get the minimum number in the entire stack
		if (s.isEmpty())
			System.out.println("Stack is empty");

		// variable minEle stores the minimum element
		// in the stack.
		else
			System.out.println("Minimum Element in the " + " stack is: " + minEle);
	}

	// prints top element of MyStack
	void peek() {
		if (s.isEmpty()) {
			System.out.println("Stack is empty ");
			return;
		}

		Integer t = s.peek(); // Top element.

		System.out.print("Top Most Element is: ");

		// If t < minEle means minEle stores
		// value of t.
		if (t < minEle)
			System.out.println(minEle);
		else
			System.out.println(t);
	}

	void pop() {
		if (s.isEmpty()) {
			System.out.println("Stack is empty");
			return;
		}

		System.out.print("Top Most Element Removed: ");
		Integer t = s.pop();

		// Minimum will change as the minimum element
		// of the stack is being removed.
		if (t < minEle) {
			System.out.println(minEle);
			minEle = 2 * minEle - t;
		}

		else
			System.out.println(t);
	}

	void push(Integer x) {
		if (s.isEmpty()) {
			minEle = x;
			s.push(x);
			System.out.println("Number Inserted: " + x);
			return;
		}

		// If new number is less than original minEle
		if (x < minEle) {
			s.push(2 * x - minEle);
			minEle = x;
		}

		else
			s.push(x);

		System.out.println("Number Inserted: " + x);
	}
}