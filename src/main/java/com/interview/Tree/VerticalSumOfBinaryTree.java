package com.interview.Tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalSumOfBinaryTree {

	// We can optimized this approach(No need for queue) by calling the method
	// recursively
	// for left tree and then put into map and then calling right tree with
	// corresponding height

	static Map<Integer, Integer> verticalSum = new TreeMap<>();

	static Queue<QueueNode> queue = new LinkedList<QueueNode>();

	public static void verticalSum(Node root) {

		if (root == null) {
			return;
		}
		queue.add(new QueueNode(root, 0));

		while (!queue.isEmpty()) {

			QueueNode temp = queue.poll();
			int hd = temp.hd;
			if (verticalSum.containsKey(temp.hd)) {
				verticalSum.put(temp.hd, (verticalSum.get(temp.hd) + temp.node.data));
			} else {
				verticalSum.put(temp.hd, temp.node.data);
			}

			if (temp.node.left != null)
				queue.add(new QueueNode(temp.node.left, hd - 1));
			if (temp.node.right != null)
				queue.add(new QueueNode(temp.node.right, hd + 1));

		}

	}

	// Approach 2 - Using a Double Linkedlist (Geeksforgeeks)

	static void verticalSumDLL(Node root) {
		// Create a doubly linked list node to
		// store sum of lines going through root.
		// Vertical sum is initialized as 0.
		LLNode llnode = new LLNode(0);

		// Compute vertical sum of different lines
		verticalSumDLLUtil(root, llnode);

		// llnode refers to sum of vertical line
		// going through root. Move llnode to the
		// leftmost line.
		while (llnode.prev != null)
			llnode = llnode.prev;

		// Prints vertical sum of all lines starting
		// from leftmost vertical line
		while (llnode != null) {
			System.out.print(llnode.data + " ");
			llnode = llnode.next;
		}
	}

	// Constructs linked list
	static void verticalSumDLLUtil(Node tnode, LLNode llnode) {
		// Add current node's data to its vertical line
		llnode.data = llnode.data + tnode.data;

		// Recursively process left subtree
		if (tnode.left != null) {
			if (llnode.prev == null) {
				llnode.prev = new LLNode(0);
				llnode.prev.next = llnode;
			}
			verticalSumDLLUtil(tnode.left, llnode.prev);
		}

		// Process right subtree
		if (tnode.right != null) {
			if (llnode.next == null) {
				llnode.next = new LLNode(0);
				llnode.next.prev = llnode;
			}
			verticalSumDLLUtil(tnode.right, llnode.next);
		}
	}

	static class LLNode {
		int data;
		LLNode prev, next;

		public LLNode(int d) {
			data = d;
		}
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);

		tree.root.left = new Node(2);
		tree.root.right = new Node(3);

		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		tree.root.right.left = new Node(7);
		tree.root.right.right = new Node(6);

		System.out.println("Following are vertical Sum of Binary Tree");

		 VerticalSumOfBinaryTree.verticalSum(tree.root);

		//verticalSumDLL(tree.root);

		int line = 0;

		for (Map.Entry<Integer, Integer> entry : verticalSum.entrySet()) {
			System.out.println("Sum at Vertical Line " + ++line + " : " + entry.getValue());
		}

	}

}
