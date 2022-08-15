package com.shiv.solutions.leetcode.tree;

import com.shiv.solutions.leetcode.model.TreeNode;

/**
 * @author Shivshankar Sahoo
 * 
 * @problem
 * <a href="https://leetcode.com/problems/first-bad-version/">Leetcode</a></br>
 * 
 * @description
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * A valid BST is defined as follows:
 * <ol><li>The left subtree of a node contains only nodes with keys less than the node's key.</li>
 * <li>The right subtree of a node contains only nodes with keys greater than the node's key.</li>
 * <li>Both the left and right subtrees must also be binary search trees.</li></ol>
 * 
 * @explanations
 * <a href="https://leetcode.com/problems/validate-binary-search-tree/discuss/2410319/DFS-Post-order-or-Full-visual-explanation-with-Image">Leetcode</a></br>
 * 
 */
public class ValidateBinarySearchTree extends BinaryTreeNodeOperations {

	public static boolean isValidBST(TreeNode root) {
        return isBinaryTree(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private static boolean isBinaryTree(TreeNode node, long min, long max){
		if (node==null)
			return true;

		return node.getVal() > min && node.getVal() < max 
			&& isBinaryTree(node.getLeft(), min, node.getVal()) 
			&& isBinaryTree(node.getRight(), node.getVal(), max);
	}
	
	public static void main(String[] args) {
		for(TreeNode tree : getArrayOfBinarySearchTreeNodes()) {
			System.out.println("Input Binary Search TreeNode:");
			System.out.println(toString(tree));
			System.out.println("Whether a valid BST: " + String.valueOf(isValidBST(tree)).toUpperCase());
			System.out.println();
		}
	}

}
