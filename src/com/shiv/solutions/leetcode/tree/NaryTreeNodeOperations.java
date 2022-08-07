package com.shiv.solutions.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

import com.shiv.solutions.leetcode.model.Node;

/**
 * @author Shivshankar Sahoo
 * 
 * @description
 * This class contains methods that can be used to</br>
 * work effectively with custom N-ary Tree.</br>
 * 
 * Model class > com.shiv.solutions.leetcode.model.Node</br>
 */
public abstract class NaryTreeNodeOperations {

	public static Node[] getArrayOfTreeNodesWithChildAsLists() {
		Node root = new Node(1);
		List<Node> childrenNode = new ArrayList<Node>(); 
		childrenNode.add(new Node(3));
		childrenNode.add(new Node(2));
		childrenNode.add(new Node(4));
		root.setChildren(childrenNode);
		childrenNode = new ArrayList<>();
		childrenNode.add(new Node(5));
		childrenNode.add(new Node(6));
		root.getChildren().get(0).setChildren(childrenNode);
		
		Node root2 = new Node(1);
		childrenNode = new ArrayList<>(); 
		childrenNode.add(new Node(2));
		childrenNode.add(new Node(3));
		childrenNode.add(new Node(4));
		childrenNode.add(new Node(5));
		root2.setChildren(childrenNode);
		childrenNode = new ArrayList<>();
		childrenNode.add(new Node(6));
		childrenNode.add(new Node(7));
		root2.getChildren().get(1).setChildren(childrenNode);
		childrenNode = new ArrayList<>();
		childrenNode.add(new Node(11));
		root2.getChildren().get(1).getChildren().get(1).setChildren(childrenNode);
		childrenNode = new ArrayList<>();
		childrenNode.add(new Node(14));
		root2.getChildren().get(1).getChildren().get(1).getChildren().get(0).setChildren(childrenNode);
		childrenNode = new ArrayList<>();
		childrenNode.add(new Node(8));
		root2.getChildren().get(2).setChildren(childrenNode);
		childrenNode = new ArrayList<>();
		childrenNode.add(new Node(12));
		root2.getChildren().get(2).getChildren().get(0).setChildren(childrenNode);
		childrenNode = new ArrayList<>();
		childrenNode.add(new Node(9));
		childrenNode.add(new Node(10));
		root2.getChildren().get(3).setChildren(childrenNode);
		childrenNode = new ArrayList<>();
		childrenNode.add(new Node(13));
		root2.getChildren().get(3).getChildren().get(0).setChildren(childrenNode);
		
		return new Node[] {root, root2};
	}
	
}
