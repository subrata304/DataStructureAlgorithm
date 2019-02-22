package com.interview.Tree;

import java.util.Stack;

public class BinaryTreeTraversalIterative {

	static Node root;

	public BinaryTreeTraversalIterative() {
		root = null;
	}

	public static void inOrderTraversal(Node root) {

		if(root == null) {
			
		}
		Stack<Node> stack = new Stack<Node>();
		
		while(true) {
			if(root!=null) {
				stack.push(root);
				root = root.left;
			}else {
				if(stack.isEmpty()) {
					break;
				}
				root = stack.pop();
				System.out.print(root.data + " ");
				root = root.right;
			}
		}
		
	}

	public static void preOrderTraversal(Node root) {

		if(root == null) {
			return;
		}
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		
		while(!stack.isEmpty()) {
			
			Node current = stack.pop();
			
			System.out.print(current.data+ " ");
			
			if(current.right!=null) {
				stack.push(current.right);
			}
			if(current.left!=null) {
				stack.push(current.left);
			}
		}
	}

	public static void postOrderTraversal(Node root) {

		if(root == null) {
			return;
		}
		
		Stack<Node> stack1 = new Stack<Node>();
		Stack<Node> stack2 = new Stack<Node>();
		
		stack1.push(root);
		
		while(!stack1.isEmpty()) {
			Node current = stack1.pop();
			
			stack2.push(current);
			
			if(current.left!=null) {
				stack1.push(current.left);
			}
			if(current.right!=null) {
				stack1.push(current.right);
			}
		}
		while(!stack2.isEmpty()) {
			System.out.print(stack2.pop().data+ " ");
		}
	}


	public static void main(String[] args) {
		BinaryTreeTraversalIterative tree = new BinaryTreeTraversalIterative(); 
		tree.root = new Node(10); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(5); 
		tree.root.left.left = new Node(6); 
		tree.root.right.left = new Node(8); 
		tree.root.right.right = new Node(3);

		System.out.print("In Order : ==> ");inOrderTraversal(tree.root);System.out.println();
		System.out.print("Pre Order : ==> ");preOrderTraversal(tree.root);System.out.println();
		System.out.print("Post Order : ==> ");postOrderTraversal(tree.root);System.out.println();
	}
}
