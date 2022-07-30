package com.shiv.solutions.leetcode;

import java.util.HashMap;

import com.shiv.solutions.leetcode.model.ListNode;

/**
 * @author Shivshankar Sahoo
 * 
 * @problem
 * <a href="https://leetcode.com/problems/linked-list-cycle-ii/">Leetcode</a></br>
 * 
 * @description
 * Given the head of a linked list, return the node where the cycle begins.</br>
 * If there is no cycle, return null.</br>
 * There is a cycle in a linked list if there is some node in the list that</br>
 * can be reached again by continuously following the next pointer.</br>
 *
 */
public class DetectCycleInLinkedList {

	public static ListNode detectCycleUsingHashMap(ListNode head) {
		// if head is null be break and return it (there is no cycle)
		if(ListNodeOperations.linkedListNodeNullCheck(head)) return null;
		
		HashMap<ListNode,Boolean> map = new HashMap<>();
		// if head is suddenly a node we've seen before, it's the first one so return it
	    while (!map.keySet().contains(head) && head != null){
	        map.put(head, true);
	        head = head.getNext();
	    }
	    return head;
	}
	
	public static ListNode detectCycleUsingTwoPointers(ListNode head) {
		if(ListNodeOperations.linkedListNodeNullCheck(head)) return null;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.getNext() != null){
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if(slow == fast){
                slow = head;
                while(slow != fast){
                    slow = slow.getNext();
                    fast = fast.getNext();
                }
                return slow;
            }
        }
        return null;
    }
	
	public static void main(String[] args) {
		ListNode cyclicNode = ListNodeOperations.getOneCyclicLinkedList();
		ListNodeOperations.displayCyclicLinkedListAsString("Input Cyclic Linked List:", cyclicNode);
		ListNodeOperations.displayCyclicLinkedListAsString("1st cyclic node reference using two pointers:",
				detectCycleUsingTwoPointers(cyclicNode));
		ListNodeOperations.displayCyclicLinkedListAsString("1st cyclic node reference using hash map:",
				detectCycleUsingHashMap(cyclicNode));
	}

}
