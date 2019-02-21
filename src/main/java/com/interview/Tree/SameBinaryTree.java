package com.interview.Tree;

public class SameBinaryTree {

	private boolean sameTree(Node root1, Node root2) {
		if(root1 == null && root2 == null) {
			return true;
		}
		if(root1 == null || root2 == null) {
			return false;
		}
		
		return root1.data == root2.data 
				&& sameTree(root1.left, root2.left)
				&& sameTree(root1.right, root2.right);
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

		BinarySearchTree bst2 = new BinarySearchTree();
              
        bst2.insert( 10);
		bst2.insert( 20);
		bst2.insert( 14);
		bst2.insert( 2);
		bst2.insert( 8);
		bst2.insert( 3);
		bst2.insert( 7);
        
		SameBinaryTree sbt = new SameBinaryTree();
        System.out.println("Both tree are: " + sbt.sameTree(bst1.root, bst2.root));
	}

}
