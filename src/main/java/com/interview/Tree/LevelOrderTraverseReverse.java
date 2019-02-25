package com.interview.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderTraverseReverse {

	
	public static void reverseLevelOrderTraversal(Node root){
        if(root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        Stack<Node> s = new Stack<>();
        
        q.offer(root);
        while(!q.isEmpty()){
            root = q.poll();
            if(root.right != null){
                q.offer(root.right);
            }
            if(root.left != null){
                q.offer(root.left);
            }
            s.push(root);
        }
        while(!s.isEmpty()){
            System.out.print(s.pop().data + " ");
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
		
		reverseLevelOrderTraversal(tree.root);
	}
}
