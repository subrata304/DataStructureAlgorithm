package com.interview.Tree;


/*
 * Time complexity O(height of tree)
 * Space complexity O(height of tree)
 */

public class LowestCommonAncestoryBinarySearchTree {

	public static Node lca(Node root, int n1, int n2) {
		if (root.data > Math.max(n1, n2)) {
			return lca(root.left, n1, n2);
			
		} else if (root.data < Math.min(n1, n2)) {
			return lca(root.right, n1, n2);
		
		} else {
			return root;
		}
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(20);
		tree.root.left = new Node(8);
		tree.root.right = new Node(22);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(12);
		tree.root.left.right.left = new Node(10);
		tree.root.left.right.right = new Node(14);
		
		System.out.println("LCA of (10, 14) = " + 
				LowestCommonAncestoryBinarySearchTree.lca(tree.root, 10, 14).data); 
	}
}
