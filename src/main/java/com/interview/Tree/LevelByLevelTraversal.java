package com.interview.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelByLevelTraversal {


	public static void levelByLevelOneQueueUsingDelimiter(Node root) {
		if (root == null) {
			return;
		}
		Queue<Node> q = new LinkedList<Node>();
		q.offer(root);
		q.offer(null);
		while (!q.isEmpty()) {
			root = q.poll();
			if (root != null) {
				System.out.print(root.data + " ");
				if (root.left != null) {
					q.offer(root.left);
				}
				if (root.right != null) {
					q.offer(root.right);
				}
			} else {
				if (!q.isEmpty()) {
					System.out.println();
					q.offer(null);
				}
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

		levelByLevelOneQueueUsingDelimiter(tree.root);
	}
}
