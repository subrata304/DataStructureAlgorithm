package com.interview.Tree;

public class DiameterOfBinaryTree {

	public static int diameter(Node root) {
		
		if(root == null) {
			return 0;
		}
		int leftheight = HeightOfBinaryTree.heightOfBinaryTree(root.left);
		int rightHeight = HeightOfBinaryTree.heightOfBinaryTree(root.right);
		
		int leftDiameter = diameter(root.left);
		int rightDiameter = diameter(root.right);
		
		
		return Math.max(1+leftheight + rightHeight, Math.max(leftDiameter, rightDiameter));
	}
	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree(); 
		bst.insert(10);
		bst.insert(8);
		bst.insert(16);
		bst.insert(3);
		bst.insert(9);
		bst.insert(14);
		bst.insert(13);
		bst.insert(17);
		
		System.out.println("Diamter of the Binart Tree is :"  + diameter(bst.root));
	}
}
