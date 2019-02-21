package com.interview.Tree;

public class BinaryTreeTraversalRecursive {

	static Node root;

	public BinaryTreeTraversalRecursive() {
		root = null;
	}

	public static void inOrderTraversal(Node root) {

		if(root != null) {
			inOrderTraversal(root.left);
			System.out.print(root.data+ " ");
			inOrderTraversal(root.right);
		}
	}

	public static void preOrderTraversal(Node root) {

		if(root!= null) {
			System.out.print(root.data+ " ");
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);
		}
	}

	public static void postOrderTraversal(Node root) {

		if(root!= null) {
			postOrderTraversal(root.left);
			postOrderTraversal(root.right);
			System.out.print(root.data+ " ");
		}
	}


	public static void main(String[] args) {
		BinaryTreeTraversalRecursive tree = new BinaryTreeTraversalRecursive(); 
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
