package com.shiv.solutions.leetcode.model;

/**
 * @author Shivshankar Sahoo
 * 
 * @description
 * This class represents a Binary Tree Node.</br>
 * Each Node has an Integer value.</br>
 * Each node has maximum tow child nodes - left & right that are also node objects.</br>
 *
 */
public class TreeNode {

	int val;
	TreeNode left;
	TreeNode right;
	
	public TreeNode() {}
	public TreeNode(int val) { this.val = val; }
	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
	
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	public TreeNode getLeft() {
		return left;
	}
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	public TreeNode getRight() {
		return right;
	}
	public void setRight(TreeNode right) {
		this.right = right;
	}
	
}
