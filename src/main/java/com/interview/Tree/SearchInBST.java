package com.interview.Tree;

public class SearchInBST {

	public static boolean search(Node root, int key) {
		
		if(root ==  null) {
			return false;
		}
		if(root.data == key) return true;
		
		else if(root.data < key) {
			return search(root.right, key);
		}
		else {
			return search(root.left, key);
		}
	}
	
	public static void main(String[] args) {
		BinaryTreeTraversalRecursive bst = new BinaryTreeTraversalRecursive(); 
		bst.root = new Node(10); 
		bst.root.left = new Node(-5); 
		bst.root.right = new Node(25); 
		
		bst.root.left.left = new Node(-10); 
		bst.root.left.right = new Node(5); 
		
		bst.root.right.right = new Node(36);
		
		int key = 36;
		
		if(search(bst.root, key)) {
			System.out.println("Key: "+ key + " is present in the BST");
		}else {
			System.out.println("Key: "+ key + " is NOT present in the BST");
		}
	}
}
