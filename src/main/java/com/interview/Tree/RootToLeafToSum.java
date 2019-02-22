package com.interview.Tree;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafToSum {

	 public static boolean rootToLeafToSum(Node root, int sum, List<Integer> listofNodes){
	        if(root == null){
	            return false;
	        }

	        if(root.left == null && root.right == null){
	            if(root.data == sum){
	                listofNodes.add(root.data);
	                return true;
	            }else{
	                return false;
	            }
	        }
	        if(rootToLeafToSum(root.left, sum-root.data, listofNodes) 
	        		|| rootToLeafToSum(root.right, sum - root.data, listofNodes)){
	        	
	            listofNodes.add(root.data);
	            return true;
	        }
	        return false;
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
		
		List<Integer> list = new ArrayList<Integer>();
		
		System.out.println("Path of the Binary Tree is: "+  rootToLeafToSum(bst1.root, 30, list ));
		System.out.println(list.toString());
	}
}
