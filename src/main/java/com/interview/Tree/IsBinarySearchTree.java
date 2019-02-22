package com.interview.Tree;

import java.util.LinkedList;
import java.util.Stack;

public class IsBinarySearchTree {

	public boolean isBST(Node root, int min, int max) {
		if(root == null) {
			return true;
		}
		if(root.data <= min || root.data > max) {
			return false;
		}

		return isBST(root.left, Integer.MIN_VALUE, root.data)
				&&  isBST(root.right, root.data, Integer.MAX_VALUE);

	}
	public boolean isBSTIterative(Node root) {
		if (root == null) {
			return true;
		}

		Stack<Node> stack = new Stack<>();
		Node node = root;
		int prev = Integer.MIN_VALUE;
		int current;
		while ( true ) {
			if (node != null) {
				stack.push(node);
				node = node.left;
			} else {
				if (stack.isEmpty()) {
					break;
				}
				node = stack.pop();
				current = node.data;
				if (current < prev) {
					return false;
				}
				prev = current;
				node = node.right;
			}
		}
		return true;
	}

	public static void main(String args[]){
		BinarySearchTree bt = new BinarySearchTree();
		
		bt.insert( 10);
		bt.insert( 2);
		bt.insert( 5);
		bt.insert( 6);
		bt.insert( 8);
		bt.insert( 3);

		IsBinarySearchTree isBST = new IsBinarySearchTree();
		System.out.println(isBST.isBSTIterative(bt.root));
	}
}
