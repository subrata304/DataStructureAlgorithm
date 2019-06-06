package com.interview.Tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class SameBinaryTree {

	private boolean IsSameTreeRecursive(Node root1, Node root2) {
		if(root1 == null && root2 == null) {
			return true;
		}
		if(root1 == null || root2 == null) {
			return false;
		}
		
		return root1.data == root2.data 
				&& IsSameTreeRecursive(root1.left, root2.left)
				&& IsSameTreeRecursive(root1.right, root2.right);
	}
	
	static class Pair<U, V> {
		public final U first; // first field of a Pair
		public final V second; // second field of a Pair

		// Constructs a new Pair with specified values
		private Pair(U first, V second) {
			this.first = first;
			this.second = second;
		}

		// Factory method for creating a Typed Pair immutable instance
		public static <U, V> Pair<U, V> of(U a, V b) {
			// calls private constructor
			return new Pair<>(a, b);
		}
	}
	public static boolean isSameBinaryTreeIterativeApproach(Node x, Node y) {
		// if both trees are empty, return true
		if (x == null && y == null) {
			return true;
		}

		// if first tree is empty (& second tree is non-empty), return false
		if (x == null) {
			return false;
		}

		// if second tree is empty (& first tree is non-empty), return false
		if (y == null) {
			return false;
		}

		// create a stack to hold Node pairs
		Deque<Pair<Node, Node>> stack = new ArrayDeque<>();
		stack.add(Pair.of(x, y));

		// do till stack is not empty
		while (!stack.isEmpty()) {
			// pop top pair from the stack and process it
			x = stack.peek().first;
			y = stack.peek().second;
			stack.poll();

			// if value of their root node don't match, return false
			if (x.data != y.data) {
				return false;
			}

			// if left subtree of both x and y exists, push their addresses
			// to stack else return false if only one left child exists
			if (x.left != null && y.left != null) {
				stack.add(Pair.of(x.left, y.left));
			} else if (x.left != null || y.left != null) {
				return false;
			}

			// if right subtree of both x and y exists, push their addresses
			// to stack else return false if only one right child exists
			if (x.right != null && y.right != null) {
				stack.add(Pair.of(x.right, y.right));
			} else if (x.right != null || y.right != null) {
				return false;
			}
		}

		// if we reach here, both binary trees are identical
		return true;
	}

	public static void main(String[] args) {
		BinarySearchTree bst1 = new BinarySearchTree();
              
        bst1.insert( 10);
		bst1.insert( 20);
		bst1.insert( 14);
		bst1.insert( 2);
		bst1.insert( 8);
		bst1.insert( 3);
		bst1.insert( 7);

		BinarySearchTree bst2 = new BinarySearchTree();
              
        bst2.insert( 10);
		bst2.insert( 20);
		bst2.insert( 14);
		bst2.insert( 2);
		bst2.insert( 8);
		bst2.insert( 3);
		bst2.insert( 7);
        
		SameBinaryTree sbt = new SameBinaryTree();
        System.out.println("Both tree are: " + sbt.isSameBinaryTreeIterativeApproach(bst1.root, bst2.root));
	}

}
