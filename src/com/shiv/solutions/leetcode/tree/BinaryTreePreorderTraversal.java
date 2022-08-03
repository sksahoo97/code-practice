package com.shiv.solutions.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

import com.shiv.solutions.leetcode.model.Node;

/**
 * @author Shivshankar Sahoo
 * 
 * @problem
 * <a href="https://leetcode.com/problems/n-ary-tree-preorder-traversal/">Leetcode</a></br>
 * 
 * @description
 * Given the root of an n-ary tree, return the preorder traversal of its nodes' values.
 * Nary-Tree input serialization is represented in their level order traversal.
 *
 */
public class BinaryTreePreorderTraversal extends BinaryTreeNodeOperations{

	public static List<Integer> preorderUsingRecursion(Node root) {
        List<Integer> output = new ArrayList<Integer>();
        preOrderTraversal(root, output);
        return output;
    }
    
    public static void preOrderTraversal(Node root, List<Integer> output){
        
        if(root == null)
            return;
        
		// add root
        output.add(root.getVal());
		
		// add left
        if(root.getChildren() != null
        		&& root.getChildren().size() > 0){
            Node temp = root.getChildren().get(0);
            preOrderTraversal(temp, output);
        }
        
		// here we simply iterate through all of the right 
        if(root.getChildren() != null
        		&& root.getChildren().size() > 1){
            for(int i = 1; i < root.getChildren().size(); i++){
                Node temp = root.getChildren().get(i);
                preOrderTraversal(temp, output);
            }
        }
    }
	
	public static List<Integer> preorder(Node root) {
        List<Integer> order = new ArrayList<Integer>();
        if (root != null) {
            order.add(root.getVal());
            for (int i = 0; i < root.getChildren().size(); i++) {
                order.add(root.getChildren().get(i).getVal());
                if (!(root.getChildren().get(i).getChildren() == null)) root.getChildren().addAll(i + 1, root.getChildren().get(i).getChildren());
            }
        }
        return order;
    }
	
	public static void main(String[] args) {
		for(Node root : getArrayOfBinaryTreeNodes()) {
			System.out.println("Input Binary Tree Node: \n" + root.toString());
			//System.out.println("Preorder traversal    : \n" + preorder(root));
			System.out.println("Preorder traversal: \n" + preorderUsingRecursion(root));
			System.out.println();
		}
	}

}
