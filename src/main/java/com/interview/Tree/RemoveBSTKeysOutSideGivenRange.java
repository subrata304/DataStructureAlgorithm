package com.interview.Tree;

/*
 * https://www.geeksforgeeks.org/remove-bst-keys-outside-the-given-range/
 */
public class RemoveBSTKeysOutSideGivenRange {

	/*
	 * Time Complexity: O(n) where n is the number of nodes in given BST.
	 */
	public static Node removeOutsideRange(Node root, int min, int max) {
		if (root == null) {
			return null;
		}

		// FIRST FIX THE LEFT AND
		// RIGHT SUBTREE OF ROOT
		root.left = removeOutsideRange(root.left, min, max);
		root.right = removeOutsideRange(root.right, min, max);

		// NOW FIX THE ROOT. THERE ARE
		// TWO POSSIBLE CASES FOR THE ROOT
		// 1. a) Root's key is smaller than
		// min value(root is not in range)
		if (root.data < min) {
			Node rchild = root.right;
			root = null;
			return rchild;
		}

		// 1. b) Root's key is greater than
		// max value (Root is not in range)
		if (root.data > max) {
			Node lchild = root.left;
			root = null;
			return lchild;
		}

		// 2. Root in range
		return root;
	}
	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(6);bst.insert(-13);bst.insert(14);bst.insert(-8);bst.insert(15);bst.insert(13);
		bst.insert(7);
		
		System.out.print("In Order : ==> ");
		BinaryTreeTraversalRecursive.inOrderTraversal(bst.root);
		System.out.println();
		
		removeOutsideRange(bst.root, -10, 13);
		
		System.out.print("In Order : ==> ");
		BinaryTreeTraversalRecursive.inOrderTraversal(bst.root);
		System.out.println();
		
		
	}

}
