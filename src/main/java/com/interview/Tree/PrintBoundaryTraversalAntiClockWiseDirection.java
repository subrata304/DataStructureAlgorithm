package com.interview.Tree;

/*
 * Time Complexity: O(n) where n is the number of nodes in binary tree.
 */
public class PrintBoundaryTraversalAntiClockWiseDirection {

	public static void printLeaves(Node node) {
		
		System.out.println("In printLeaves");
		if (node != null) {
			printLeaves(node.left);

			// Print it if it is a leaf node
			if (node.left == null && node.right == null)
				System.out.print(node.data + " ");
			printLeaves(node.right);
		}
	}

	public static void printBoundaryLeft(Node node) {
		
		System.out.println("In printBoundaryLeft");
		if (node != null) {
			if (node.left != null) {

				// to ensure top down order, print the node
				// before calling itself for left subtree
				System.out.print(node.data + " ");
				printBoundaryLeft(node.left);
			} else if (node.right != null) {
				System.out.print(node.data + " ");
				printBoundaryLeft(node.right);
			}
		}
	}

	public static void printBoundaryRight(Node node) {
		
		System.out.println("In printBoundaryRight");
		if (node != null) {
			if (node.right != null) {
				// to ensure bottom up order, first call for right
				// subtree, then print this node
				printBoundaryRight(node.right);
				System.out.print(node.data + " ");
			} else if (node.left != null) {
				printBoundaryRight(node.left);
				System.out.print(node.data + " ");
			}
		}
	}

	public static void printBoundary(Node node) {
		if (node != null) {
			System.out.print(node.data + " ");

			// Print the left boundary in top-down manner.
			printBoundaryLeft(node.left);

			// Print all leaf nodes
			printLeaves(node.left);
			printLeaves(node.right);

			// Print the right boundary in bottom-up manner
			printBoundaryRight(node.right);
		}
	}

	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(20);
		tree.root.left = new Node(8);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(12);
		tree.root.left.right.left = new Node(10);
		tree.root.left.right.right = new Node(14);
		tree.root.right = new Node(22);
		tree.root.right.right = new Node(25);
		
		printBoundary(tree.root);
	}
}
