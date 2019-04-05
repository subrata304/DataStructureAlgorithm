package com.interview.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class MirrorOfBinaryTree {

	//Recursive Approach
	public static Node mirror(Node root) {

		if (root == null) {
			return root;
		}
		Node left = mirror(root.left);
		Node right = mirror(root.right);

		root.left = right;
		root.right = left;

		return root;
	}

	//Iterative Approach
	public static void mirrorIterative(Node root) {
		if(root == null) return;

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);

		while(!queue.isEmpty()){
			Node current = queue.peek();
			queue.poll();

			Node tempLeftChild = current.left;

			current.left = current.right;
			current.right = tempLeftChild;

			if(current.left!= null) {
				queue.add(current.left);
			}
			if(current.right!= null) {
				queue.add(current.right);
			}
		}
	}


	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);


		BinaryTreeTraversalRecursive.preOrderTraversal(tree.root);

		Node mirrorTree = mirror(tree.root);

		System.out.println();

		BinaryTreeTraversalRecursive.preOrderTraversal(mirrorTree);


		//Calling Iterative Approach
		
		System.out.println();
		System.out.println("============================");

		BinaryTreeTraversalRecursive.preOrderTraversal(tree.root);

		mirrorIterative(tree.root);

		System.out.println();

		BinaryTreeTraversalRecursive.preOrderTraversal(tree.root);

	}
}
