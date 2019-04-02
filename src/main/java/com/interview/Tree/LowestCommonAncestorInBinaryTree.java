package com.interview.Tree;

public class LowestCommonAncestorInBinaryTree {

	/*
	 * Time complexity O(n) 
	 * Space complexity O(h)
	 */

	public static Node lca(Node root, int n1, int n2) {
		if (root == null) {
			return null;
		}
		if (root.data == n1 || root.data == n2) {
			return root;
		}

		Node left = lca(root.left, n1, n2);
		Node right = lca(root.right, n1, n2);

		if (left != null && right != null) {
			return root;
		}
		return left != null ? left : right;
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.right = new Node(4);
		tree.root.left.right.left = new Node(5);
		tree.root.left.right.right = new Node(6);

		System.out.println("LCA of (5, 3) = " + 
				LowestCommonAncestorInBinaryTree.lca(tree.root, 5, 3).data); 

	}
}
