package com.interview.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
	
	public static void levelOrderTraverse(Node root) {
		
		if(root == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<Node>();
		
		queue.add(root);
		
		while(!queue.isEmpty()) {
			Node currentParent = queue.poll();
			System.out.println(currentParent.data);
			if(currentParent.left!=null) {
				queue.add(currentParent.left);
			}
			if(currentParent.right!=null) {
				queue.add(currentParent.right);
			}
		}
	}
	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree(); 
		bst.insert( 10);
		bst.insert( 2);
		bst.insert( 5);
		bst.insert( 6);
		bst.insert( 8);
		bst.insert( 3);
		
		levelOrderTraverse(bst.root);
	}
	
}
