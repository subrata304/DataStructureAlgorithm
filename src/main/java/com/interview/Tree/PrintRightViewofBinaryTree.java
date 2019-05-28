package com.interview.Tree;

public class PrintRightViewofBinaryTree {

	static int maxLevel = 0;

	public static void rightView(Node root, int level) {

		if (root == null) {
			return;
		}

		if (level > maxLevel) {
			maxLevel = level;
			System.out.print(root.data + " ");
		}

		rightView(root.right, level + 1);
		rightView(root.left, level + 1);

	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.right = new Node(4);
		tree.root.left.right.right = new Node(5);
		tree.root.left.right.right.right = new Node(6);
		System.out.println("Following are nodes in Right view of Binary Tree");
		PrintRightViewofBinaryTree.rightView(tree.root, 1);
		
		
	}
}
