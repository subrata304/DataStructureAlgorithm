package com.interview.Tree;

public class BinarySearchTree {
	
	Node root; 
	  
    BinarySearchTree() {  
        root = null;  
    } 
    public void insert(int key) { 
        root = insertBST(root, new Node(key)); 
    }
    
	public Node insertBST(Node root, Node node){
		if(root == null) {
			root = node; 
			return root;
		}
		if(root.data < node.data) {
			root.right = insertBST(root.right, node);
		}
		else {
			root.left = insertBST(root.left, node);
		}
		return root;
	}
	
	public Node insertIterative(Node root, int data) {
		Node node = new Node(data);
		if(root == null) return node;
		
		Node parent = null;
		Node current = root;
		
		while(current!= null) {
			parent = current;
			if(current.data <= data) {
				current = current.right;
			}else {
				current = current.left;
			}
		}
		
		if(parent.data <= data) {
			parent.right = node;
		}else {
			parent.left = node;
		}
		
		return root;
	}
	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree(); 
		bst.insert( 10);
		bst.insert( 2);
		bst.insert( 5);
		bst.insert( 6);
		bst.insert( 8);
		bst.insert( 3);
		
		
		System.out.print("In Order : ==> ");BinaryTreeTraversalRecursive.inOrderTraversal(bst.root);System.out.println();
		System.out.print("Pre Order : ==> ");BinaryTreeTraversalRecursive.preOrderTraversal(bst.root);System.out.println();
		System.out.print("Post Order : ==> ");BinaryTreeTraversalRecursive.postOrderTraversal(bst.root);System.out.println();
		
	}
}
