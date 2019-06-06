package com.interview.Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class HeightOfBinaryTree {

	/*
	 * The time complexity for both Iterative and Recursive is O(N)
	 */
	public static int heightOfBinaryTreeRecursive(Node root) {
		
		if(root == null){
            return 0;
        }
        int leftHeight  = heightOfBinaryTreeRecursive(root.left);
        int rightHeight = heightOfBinaryTreeRecursive(root.right);
        
        return Math.max(leftHeight, rightHeight) + 1;
	}

	public static int heightOfBinaryTreeIterative(Node root) {
		if (root == null) {
			return 0;
		}

		Queue<Node> queue = new ArrayDeque<>();
		queue.add(root);

		Node front = null;
		int height = 0;

		// do till queue is not empty
		while (!queue.isEmpty()) {
			// calculate number of nodes in current level
			int size = queue.size();

			// process each node of current level and enqueue their
			// non-empty left and right child to queue
			while (size-- > 0) {
				front = queue.poll();

				if (front.left != null) {
					queue.add(front.left);
				}

				if (front.right != null) {
					queue.add(front.right);
				}
			}

			// increment height by 1 for each level
			height++;
		}

		return height;
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
		
		System.out.println("Height of the Binary Tree is: "+  heightOfBinaryTreeRecursive(bst1.root));
	}

}
