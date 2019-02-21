package com.interview.Tree;

public class HeightOfBinaryTree {

	public static int heightOfBinaryTree(Node root) {
		
		if(root == null){
            return 0;
        }
        int leftHeight  = heightOfBinaryTree(root.left);
        int rightHeight = heightOfBinaryTree(root.right);
        
        return Math.max(leftHeight, rightHeight) + 1;
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
		
		System.out.println("Height of the Binary Tree is: "+  heightOfBinaryTree(bst1.root));
	}

}
