package com.shiv.solutions.leetcode;

import java.util.Stack;

import com.shiv.solutions.leetcode.model.ListNode;

/**
 * @author Shivshankar Sahoo
 * 
 * @problem
 * <a href="https://leetcode.com/problems/reverse-linked-list/">Leetcode</a></br>
 * 
 * @description
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * 
 * @explanations
 * <a href="https://www.interviewbit.com/blog/reverse-a-linked-list/">Interviewbit</a></br>
 *
 */
public class ReverseLinkedList {

	static boolean linkedListNodeNullCheck(ListNode inputNode) {
		return (inputNode == null || inputNode.getNext() == null) ? true : false;
	}
	
	private static ListNode reverseList(ListNode head) {
		if (linkedListNodeNullCheck(head)) return head;
        Stack<Integer> nodeValues = new Stack<>();
        ListNode current = head;
        while(current != null) {
            nodeValues.push(current.getVal());
            current = current.getNext();
        }
        
        current = head;
        for(int i=(nodeValues.size()-1); i>=0; i--) {
            current.setVal(nodeValues.pop());
            current = current.getNext();
        }
        return head;
    }
	
	private static ListNode reverseListBySwapping(ListNode head) {
		if (linkedListNodeNullCheck(head)) return head;
		ListNode curr = head;
        ListNode prev = null;
        while(curr != null) {
            ListNode tmp = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = tmp;
        }
        return prev;
	}
	
	private static ListNode reverseListByRecursion(ListNode head) {
		if (linkedListNodeNullCheck(head)) return head;
		return reverse(head, null);
	}
	
	public static ListNode reverse(ListNode head, ListNode newHead) {
        if(head == null)
            return newHead;
        ListNode next = head.getNext();
        head.setNext(newHead);
        return reverse(next, head);
    }
	
	public static void main(String[] args) {
		for(ListNode node : ListNodeOperations.getArrayOfSortedListNodes()) {
			System.out.print("Input Linked list:    ");
			ListNodeOperations.displayListNodeAsString(node);
			System.out.print("Reversed linked list: ");
			//ListNodeOperations.displayListNodeAsString(reverseList(node));
			//ListNodeOperations.displayListNodeAsString(reverseListBySwapping(node));
			ListNodeOperations.displayListNodeAsString(reverseListByRecursion(node));
			System.out.println();
		}
	}

}
