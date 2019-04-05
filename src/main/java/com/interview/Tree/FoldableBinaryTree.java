package com.interview.Tree;

public class FoldableBinaryTree {

	public static boolean isFoldableTree(Node root) {
		if (root == null)
			return true;

		return IsFoldableUtil(root.left, root.right);
	}

	public static boolean IsFoldableUtil(Node n1, Node n2) {

		/*
		 * If both left and right subtrees are NULL, then return true
		 */
		if (n1 == null && n2 == null)
			return true;

		/*
		 * If one of the trees is NULL and other is not, then return false
		 */
		if (n1 == null || n2 == null)
			return false;

		/*
		 * Otherwise check if left and right subtrees are mirrors of their counterparts
		 */
		return IsFoldableUtil(n1.left, n2.right) && IsFoldableUtil(n1.right, n2.left);
	}
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree(); 

		/* The constructed binary tree is 
             1 
           /   \ 
          2     3 
           \    / 
            4  5 
		 */
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.right.left = new Node(4); 
		tree.root.left.right = new Node(5);
		
		System.out.println("Given Binary Tree "+ (isFoldableTree(tree.root)? "Is" : "isn't") + " Foldable Tree");
	}
}
