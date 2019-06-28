package com.interview.Tree;

public class ConstructBSTFromPreOrder {

	public static Node toBST(int preorder[]) {
		Index index = new Index();
		return toBST(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE, index);
	}

	public static Node toBST(int preorder[], int min, int max, Index index) {
		if (index.positionIndex >= preorder.length) {
			return null;
		}
		if (preorder[index.positionIndex] < min || preorder[index.positionIndex] >= max) {
			return null;
		}

		Node node = new Node();
		node.data = preorder[index.positionIndex];
		index.positionIndex++;
		node.left = toBST(preorder, min, node.data, index);
		node.right = toBST(preorder, node.data, max, index);
		return node;
	}
	public static void main(String args[]){
        int preorder[] = {10,5,1,7,40,50};
        Node root = toBST(preorder);
        
        System.out.print("In Order : ==> ");
		BinaryTreeTraversalRecursive.inOrderTraversal(root);
		
        System.out.println();

        System.out.print("Pre Order : ==> ");
		BinaryTreeTraversalRecursive.preOrderTraversal(root);
    }
}

class Index {
	int positionIndex;
}