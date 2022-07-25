package com.shiv.solutions.leetcode;

import com.shiv.solutions.leetcode.model.ListNode;

/**
 * @problem
 * <a href="https://leetcode.com/problems/merge-two-sorted-lists/">Leetcode</a>
 * 
 * @description
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists in a one sorted list.
 * The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 * 
 * @explanations
 * <a href="https://www.techiedelight.com/merge-given-sorted-linked-lists/">Techiedelight</a></br>
 * 
 */
public class MergeTwoSortedLists implements ListNodeOperations{

	public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode root = new ListNode();
		ListNode temp = root;
		
		while(list1 != null && list2 !=null) {
				if (list1.getVal() < list2.getVal()) {
				   temp.setNext(list1);
				   list1 = list1.getNext();
				} else {
				  temp.setNext(list2);
				  list2 = list2.getNext();
				}
				temp = temp.getNext();
	   }
	   temp.setNext(list1 != null ? list1 : list2);
	   return root.getNext();
	}
	
	public static void main(String[] args) {
		ListNode[] nodeArray = ListNodeOperations.getArrayOfSortedListNodes();
		System.out.println("Merging of linked lists started...");
		for(int i=0;i<nodeArray.length-1; i++) {
			ListNodeOperations.print2ConsecutiveNodesOfListNodeArray(nodeArray, i);
			System.out.print("Addition Result: ");
			ListNodeOperations.displayListNodeAsString(mergeTwoLists(nodeArray[i], nodeArray[i+1]));
			System.out.println();
			i++;
		}
	}

}
