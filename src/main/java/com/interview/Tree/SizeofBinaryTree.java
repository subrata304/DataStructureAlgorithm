package com.interview.Tree;

public class SizeofBinaryTree {

	
	public static int sizeOfBinaryTree(Node root){
		if(root == null) {
			return 0;
		}
		return 1+ sizeOfBinaryTree(root.left) + sizeOfBinaryTree(root.right);
	}
	
	
	
	public static void main(String[] args) {
		BinarySearchTree bst1 = new BinarySearchTree();
        
        bst1.insert( 10);
		bst1.insert( 20);
		bst1.insert( 14);
		bst1.insert( 2);
		bst1.insert( 8);
		bst1.insert( 3);
		bst1.insert( 7);
		
		System.out.println("Size of the Binary Tree is: "+  sizeOfBinaryTree(bst1.root));
	}
}
