package com.interview.Tree;

public class ConvertBSTToGreaterSumTree {

	static Node root;
	static Sum summ = new Sum();

	/*
	 * By leveraging the fact that the tree is a BST, 
	 * we can find an O(n) solution. The idea is to traverse BST in reverse inorder.
	 * Reverse inorder traversal of a BST gives us keys in decreasing order. 
	 * Before visiting a node, we visit all greater nodes of that node. 
	 * While traversing we keep track of sum of keys which is the sum 
	 * of all the keys greater than the key of current node.
	 */
	public static void addGreaterUtil(Node node, Sum sum_ptr) {

		if (node == null) {
			return;
		}

		// Recur for right subtree first so that sum of all greater
		// nodes is stored at sum_ptr
		addGreaterUtil(node.right, sum_ptr);

		sum_ptr.sum = sum_ptr.sum + node.data;

		// Update key of this node
		node.data = sum_ptr.sum;

		// Recur for left subtree so that the updated sum is added
		// to smaller nodes
		addGreaterUtil(node.left, sum_ptr);
	}

	public static Node addGreater(Node node) {
		addGreaterUtil(node, summ);
		return node;
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		//bst.insert(10);
		bst.insert(5);
		bst.insert(2);
		//bst.insert(6);
		//bst.insert(8);
		bst.insert(13);

		System.out.print("In Order : ==> ");
		BinaryTreeTraversalRecursive.inOrderTraversal(bst.root);
		System.out.println();
		
		Node node = addGreater(bst.root); 
		
		System.out.print("In Order After converting to Greater Sum Tree: ==> ");
		BinaryTreeTraversalRecursive.inOrderTraversal(bst.root);
		System.out.println();
	}
}

class Sum {

	int sum = 0;
}