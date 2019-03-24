package com.interview.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthOfBinaryTree {

	private static void maxWidth(Node root) {

		//Using Level Order and Queue approach
		
		Queue<Node> queue  = new LinkedList<>();
		queue.add(root);
		
		int maxWidth = 0;
		
		while(!queue.isEmpty()) {
			
			int sizeOfQueue = queue.size();
			if(sizeOfQueue > maxWidth) {
				maxWidth  = sizeOfQueue;
			}
			
			while(sizeOfQueue-- > 0) {
				
				Node temp = queue.poll();
				
				if(temp.left!= null) {
					queue.add(temp.left);
				}
				if(temp.right!= null) {
					queue.add(temp.right);
				}
			}
		}
		System.out.println("Maximum Width is: "+ maxWidth);
	}
	//Start - Using Pre Order Traversal approach 
	public static void  getMaxWidth(Node node)  
    { 
        int h = HeightOfBinaryTree.heightOfBinaryTree(node); 
   
        int count[] = new int[h]; 
   
        int level = 0; 
   
        getMaxWidthRecur(node, count, level); 
   
        System.out.println("Maximum Width is: "+  getMax(count, h)); 
    } 
   
	public static void getMaxWidthRecur(Node node, int count[], int level)  
    { 
        if (node != null)  
        { 
            count[level]++; 
            getMaxWidthRecur(node.left, count, level + 1); 
            getMaxWidthRecur(node.right, count, level + 1); 
        } 
    } 
   
	public static int getMax(int arr[], int n)  
    { 
        int max = arr[0]; 
        int i; 
        for (i = 0; i < n; i++)  
        { 
            if (arr[i] > max) 
                max = arr[i]; 
        } 
        return max; 
    } 
	
    //End
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);

		tree.root.left = new Node(2);
		tree.root.right = new Node(3);

		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		tree.root.right.left = new Node(7);
		tree.root.right.right = new Node(6);

		MaxWidthOfBinaryTree.maxWidth(tree.root);
		
		//MaxWidthOfBinaryTree.getMaxWidth(tree.root);

	}

}
