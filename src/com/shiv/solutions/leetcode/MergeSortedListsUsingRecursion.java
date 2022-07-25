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
public class MergeSortedListsUsingRecursion implements ListNodeOperations {

	public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
     
        if(list2 == null) return list1;
     
        if(list1.getVal() < list2.getVal()) {
            list1.setNext(mergeTwoLists(list1.getNext(), list2));
            return list1;
        } else {
            list2.setNext(mergeTwoLists(list1, list2.getNext()));
            return list2;
        }
    }
	
	public static void main(String[] args) {
		ListNode[] nodeArray = ListNodeOperations.getArrayOfSortedListNodes();
		for(int i=0;i<nodeArray.length-1; i++) {
			ListNodeOperations.print2ConsecutiveNodesOfListNodeArray(nodeArray, i);
			System.out.print("Addition Result: ");
			ListNodeOperations.displayListNodeAsString(mergeTwoLists(nodeArray[i], nodeArray[i+1]));
			i++;
		}
	}

}
