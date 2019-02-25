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
			System.out.print(currentParent.data + "  ");
			if(currentParent.left!=null) {
				queue.add(currentParent.left);
			}
			if(currentParent.right!=null) {
				queue.add(currentParent.right);
			}
		}
	}
	
	public static void main(String[] args) {
		BinaryTreeTraversalIterative tree = new BinaryTreeTraversalIterative(); 
		tree.root = new Node(10); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(5); 
		tree.root.left.left = new Node(6); 
		tree.root.right.left = new Node(8); 
		tree.root.right.right = new Node(3);
		
		levelOrderTraverse(tree.root);
	}
	
}
