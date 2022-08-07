package com.shiv.solutions.leetcode.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.shiv.solutions.leetcode.model.TreeNode;

/**
 * @author Shivshankar Sahoo
 * 
 * @problem
 * <a href="https://leetcode.com/problems/binary-tree-level-order-traversal/">Leetcode</a></br>
 * 
 * @description
 * Given the root of a binary tree, return the level order traversal</br>
 * of its nodes' values. (i.e., from left to right, level by level).</br>
 * 
 * @explanations
 * <a href="https://dev.to/seanpgallivan/solution-binary-tree-level-order-traversal-36cg#idea">DEV Community</a></br>
 *
 */
public class BinaryTreeLevelOrderTraversal extends BinaryTreeNodeOperations {

	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		levelTraverse(result, root, 0);
        return result;
    }
	
	private static void levelTraverse(List<List<Integer>> result, TreeNode root, int level) {
        if (root == null) return;
        if (level >= result.size()) {
            result.add(new LinkedList<Integer>());
        }
        result.get(level).add(root.getVal());
        levelTraverse(result, root.getLeft(), level+1);
        levelTraverse(result, root.getRight(), level+1);
    }
	
	public static List<List<Integer>> levelOrderUsingQueue(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int qlen = queue.size();
            List<Integer> row = new ArrayList<>();
            for (int i=0; i<qlen; i++) {
                TreeNode curr = queue.poll();
                row.add(curr.getVal());
                if (curr.getLeft() != null) queue.add(curr.getLeft());
                if (curr.getRight() != null) queue.add(curr.getRight());
            }
            ans.add(row);
        }
        return ans;
    }
	
    public static List<List<Integer>> levelOrderUsingRecursion(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        List<Integer> rootList = new ArrayList<>();
        rootList.add(root.getVal());
        result.add(rootList);
        levelOrderTraverse(root, 1, result);
        return result;
    }
    
    private static void levelOrderTraverse(TreeNode root, int level, List<List<Integer>> result) {
        if(root == null)
            return;
        List<Integer> children = exploreChildren(root);
        if(!children.isEmpty()){
            if(level < result.size())
                result.get(level).addAll(children);
            else
                result.add(children);
        }
        levelOrderTraverse(root.getLeft(), level + 1, result);
        levelOrderTraverse(root.getRight(), level + 1,result);
    }
    
    private static List<Integer> exploreChildren(TreeNode root) {
        List<Integer> children = new ArrayList<>();
        if(root.getLeft() != null)
            children.add(root.getLeft().getVal());
        if(root.getRight() != null)
            children.add(root.getRight().getVal());
        return children;
    }
    
	public static void main(String[] args) {
		final String dispConst = "Binary Tree level order traversal using";
		for(TreeNode tree : getArrayOfBinaryTreeNodes()) {
			System.out.println("Input Binary TreeNode:");
			System.out.println(toString(tree));
			System.out.println(dispConst + " M1: " + levelOrder(tree));
			System.out.println(dispConst + " M2: " + levelOrderUsingQueue(tree));
			System.out.println(dispConst + " M3: " + levelOrderUsingRecursion(tree));
			System.out.println();
		}
	}

}
