package com.shiv.solutions.leetcode.tree;

import java.util.Map;

import com.shiv.solutions.leetcode.model.TreeNode;

/**
 * @author Shivshankar Sahoo
 * 
 * @problem
 * <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/">Leetcode</a></br>
 * 
 * @description
 * Given a binary search tree (BST), find the lowest common ancestor (LCA)</br>
 * node of two given nodes in the BST.</br>
 * 
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor</br>
 * is defined between two nodes p and q as the lowest node in T that has both</br>
 * p and q as descendants (where we allow a node to be a descendant of itself).”</br>
 * 
 * All Node.val are unique, where p != q and p and q will exist in the BST.
 * 
 */
public class LowestCommonAncestorOfBinarySearchTree extends BinaryTreeNodeOperations {
	
	private static final String DISP_CONSTANT = "Lowest Common Ancestor using";

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return (root.getVal() - p.getVal()) * (root.getVal() - q.getVal()) < 1 ? 
        		root : lowestCommonAncestor(p.getVal() < root.getVal() ? 
        				root.getLeft() : root.getRight(), p, q);
    }
	
	public static TreeNode lowestCommonAncestorM2(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		} else if (p.getVal() < root.getVal() && q.getVal() < root.getVal()) {
			//if current root value is greater than both p and q value
			// that means root is in left of current root
	        return lowestCommonAncestorM2(root.getLeft(), p, q); 
	    } else if (p.getVal() > root.getVal() && q.getVal() > root.getVal()) {
	        // if current root value is lesser than both p and q value
	        // that means root is in right of current root
	        return lowestCommonAncestorM2(root.getRight(), p, q);
	    } else {
	        // if root value is between both left and right of the root
	        // then we got the least common ancestor
	        return root;
	    }
	}
	
	private static void print(TreeNode tree) {
		System.out.println(toString(tree));
	}
	
	public static void main(String[] args) {
		for(Map<String, TreeNode> entry : getListOfBSTNodeswithInputDescendants()) {
			System.out.println("Input Binary Search TreeNode:");
			print(entry.get(TREE));
			System.out.println("Target Descendants: ");
			System.out.print(P + ": ");
			print(entry.get(P));
			System.out.print(Q + ": ");
			print(entry.get(Q));
			System.out.print(DISP_CONSTANT + " M1: ");
			System.out.println(lowestCommonAncestor(entry.get(TREE), entry.get(P), entry.get(Q)).getVal());
			System.out.print(DISP_CONSTANT + " M2: ");
			System.out.println(lowestCommonAncestorM2(entry.get(TREE), entry.get(P), entry.get(Q)).getVal());
			System.out.println();
		}
	}

}
