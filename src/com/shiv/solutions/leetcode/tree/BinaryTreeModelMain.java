package com.shiv.solutions.leetcode.tree;

import com.shiv.solutions.leetcode.model.BinaryTreeModel;

public class BinaryTreeModelMain {

	public static void main(String[] args) {
		BinaryTreeModel balancedtree = getBinaryTreeModel();
		new BinaryTreePrinter(balancedtree).print(System.out);
	}
	
	static BinaryTreeModel getBinaryTreeModel() {
		BinaryTreeModel root = new BinaryTreeModel("root");

		BinaryTreeModel node1 = new BinaryTreeModel("node1");
		BinaryTreeModel node2 = new BinaryTreeModel("node2");
		root.setLeft(node1);
		root.setRight(node2);
		 
		BinaryTreeModel node3 = new BinaryTreeModel("node3");
		BinaryTreeModel node4 = new BinaryTreeModel("node4");
		node1.setLeft(node3);
		node1.setRight(node4);
		 
		node2.setLeft(new BinaryTreeModel("node5"));
		node2.setRight(new BinaryTreeModel("node6"));
		 
		BinaryTreeModel node7 = new BinaryTreeModel("node7");
		node3.setLeft(node7);
		node7.setLeft(new BinaryTreeModel("node8"));
		node7.setRight(new BinaryTreeModel("node9"));
		
		return root;
	}

}
