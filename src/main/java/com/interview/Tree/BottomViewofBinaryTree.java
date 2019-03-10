package com.interview.Tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

public class BottomViewofBinaryTree {

	static Map<Integer, Integer> topView = new TreeMap<>();
	//TreeMap - If we want to print in left to right
	//LinkedHashMap - If we want to print in level wise
	
	static Queue<QueueNode> queue = new LinkedList<QueueNode>();

	public static void bottomView(Node root) {

		if (root == null) {
			return;
		}
		queue.add(new QueueNode(root, 0));

		while (!queue.isEmpty()) {

			QueueNode temp = queue.poll();
			int hd = temp.hd;
			//if (!topView.containsKey(temp.hd)) {
				topView.put(temp.hd, temp.node.data);
			//}

			if (temp.node.left != null)
				queue.add(new QueueNode(temp.node.left, hd - 1));
			if (temp.node.right != null)
				queue.add(new QueueNode(temp.node.right, hd + 1));

		}

	}
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.right = new Node(4);
		tree.root.left.right.right = new Node(5);
		tree.root.left.right.right.right = new Node(6);
		System.out.println("Following are nodes in Bottom view of Binary Tree");
		BottomViewofBinaryTree.bottomView(tree.root);
		for (Entry<Integer, Integer> entry : topView.entrySet()) {
			System.out.print(entry.getValue() + " ");
		}

	}
}

