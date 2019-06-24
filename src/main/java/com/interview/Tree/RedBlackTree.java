package com.interview.Tree;

public class RedBlackTree {

	/*
	 * Rules are as follow:
	 * 
	 * 1. Nodes can be either RED or BLACK
	 * 2. Root should always be BLACK.
	 * 3. No RED-RED relationship between parent and child.
	 * 4. Every path from root to null nodes should have same number of BLACK Nodes.
	 * 
	 */
	
	/*
	 * Insertion Logic:
	 * 1. If empty tree then create a BLACK root node.
	 * 2. Insert new leaf node as RED.
	 * 		A. If parent is BLACK then done.
	 * 		B. If parent is RED 
	 * 			i.  If BLACK or absent siblings, then rotate, recolor and check again.
	 * 			ii. If RED siblings,  recolor the siblings and parent and check again 
	 * 
	 * 
	 */
}
