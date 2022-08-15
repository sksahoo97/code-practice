package com.shiv.solutions.leetcode.tree;

import com.shiv.solutions.leetcode.model.TreeNode;

/**
 * @author Shivshankar Sahoo
 * 
 * @description
 * This class contains methods that can be used to</br>
 * work effectively with custom Binary Tree.</br>
 * 
 * Model class > com.shiv.solutions.leetcode.model.TreeNode</br>
 */
public class BinaryTreeNodeOperations {

	public static TreeNode[] getArrayOfBinaryTreeNodes() {
		TreeNode left = new TreeNode(9);
		TreeNode right = new TreeNode(20);
		right.setLeft(new TreeNode(15));
		right.setRight(new TreeNode(7));
		TreeNode tree = new TreeNode(3, left, right);
		
		TreeNode tree2 = new TreeNode(7);
		
		TreeNode tree3 = new TreeNode();
		
		left = new TreeNode(16);
		right = new TreeNode(61);
		left.setLeft(new TreeNode(15));
		left.setRight(new TreeNode(51));
		right.setLeft(new TreeNode(17));
		right.setRight(new TreeNode(71));
		right.getLeft().setLeft(new TreeNode(18));
		right.getLeft().setRight(new TreeNode(81));
		TreeNode tree4 = new TreeNode(12, left, right);
		
		return new TreeNode[] {tree, tree2, tree3, tree4};
	}
	
	public static String toString(TreeNode tree) {
		return traversePreOrder(tree);
	}
	
	private static String traversePreOrder(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.getVal());

        String pointerRight = "└──";
        String pointerLeft = (root.getRight() != null) ? "├──" : "└──";

        traverseNodes(sb, "", pointerLeft, root.getLeft(), root.getRight() != null);
        traverseNodes(sb, "", pointerRight, root.getRight(), false);

        return sb.toString();
    }

    private static void traverseNodes(StringBuilder sb, String padding,
    		String pointer, TreeNode node, boolean hasRightSibling) {
        if (node != null) {
            sb.append("\n");
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.getVal());

            StringBuilder paddingBuilder = new StringBuilder(padding);
            if (hasRightSibling) {
                paddingBuilder.append("│  ");
            } else {
                paddingBuilder.append("   ");
            }

            String paddingForBoth = paddingBuilder.toString();
            String pointerRight = "└──";
            String pointerLeft = (node.getRight() != null) ? "├──" : "└──";

            traverseNodes(sb, paddingForBoth, pointerLeft, node.getLeft(), node.getRight() != null);
            traverseNodes(sb, paddingForBoth, pointerRight, node.getRight(), false);
        }
    }
    
    public static TreeNode[] getArrayOfBinarySearchTreeNodes() {
    	TreeNode left = new TreeNode(1);
		TreeNode right = new TreeNode(3);
		TreeNode tree = new TreeNode(2, left, right);
		
		left = new TreeNode(10);
		right = new TreeNode(20);
		left.setLeft(new TreeNode(5));
		left.setRight(new TreeNode(12));
		right.setLeft(new TreeNode(18));
		right.setRight(new TreeNode(25));
		TreeNode tree2 = new TreeNode(15, left, right);
		
		TreeNode tree3 = new TreeNode();
		
		left = new TreeNode(1);
		right = new TreeNode(4);
		right.setLeft(new TreeNode(3));
		right.setRight(new TreeNode(6));
		TreeNode tree4 = new TreeNode(5, left, right);
    	
    	return new TreeNode[] {tree, tree2, tree3, tree4};
    }
	
}
