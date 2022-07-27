package com.shiv.solutions.leetcode;

import java.util.ArrayList;
import java.util.List;

import com.shiv.solutions.leetcode.model.ListNode;

/**
 * @author Shivshankar Sahoo
 * 
 * @problem
 * <a href="https://leetcode.com/problems/middle-of-the-linked-list/">Leetcode</a>
 * 
 * @description
 * Given the head of a singly linked list, return the middle node of the linked list.</br>
 * If there are two middle nodes, return the second middle node.</br>
 * 
 * <pre>
 * Examples:
 * Input:  [1,2,3,4,5]			{[1 -> 2 -> 3 -> 4 -> 5]}
 * Output: [3,4,5] 				{[3 -> 4 -> 5]}
 * Explanation: The middle node of the list is node 3.
 * 
 * Input:  [1,2,3,4,5,6]		{[1 -> 2 -> 3 -> 4 -> 5 -> 6]}
 * Output: [4,5,6] 				{[4 -> 5 -> 6]}
 * Explanation: Since the list has two middle nodes with values 3 & 4, we return the second one.
 * </pre>
 * 
 */
public class FindMiddleNodeOfLinkedList {

	public static ListNode middleNode(ListNode head) {
        ListNode curr = head;
        List<Integer> values = new ArrayList<>();
        while(curr != null) {
            values.add(curr.getVal());
            curr = curr.getNext();
        }
    
        curr = head;
        for(int i=(values.size()/2); i<values.size(); i++) {
            curr.setVal(values.get(i));
            if(i == values.size()-1) {
                curr.setNext(null);
            } else
                curr = curr.getNext();
        }
        
        return head;
    }
	
	public static ListNode middleNodeUsingTwoPointers(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.getNext() != null){
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }
	
	public static void main(String[] args) {
		ListNode t1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
		System.out.print("Input linked list           : ");
		ListNodeOperations.displayListNodeAsString(t1);
		System.out.print("Linked list from middle node: ");
		//ListNodeOperations.displayListNodeAsString(middleNode(t1));
		ListNodeOperations.displayListNodeAsString(middleNodeUsingTwoPointers(t1));
	}

}
