package com.shiv.solutions.leetcode;

import java.util.HashMap;
import java.util.Optional;

import com.shiv.solutions.leetcode.model.ListNode;

/**
 * @author Shivshankar Sahoo
 * 
 * This interface contains method that are used to</br>
 * work effectively with custom linked lists.</br>
 * 
 * Model class > com.shiv.solutions.leetcode.model.ListNode</br>
 *
 */
public interface ListNodeOperations {

	static void display(ListNode inputNode) {
    	
    	if(inputNode == null) {    
          System.out.println("List is empty!");    
          return;    
    	}
    	
    	System.out.print("[ ");
        while(inputNode != null) {
        	System.out.print(inputNode.getVal() + " ");
        	inputNode = inputNode.getNext();
        }
        System.out.print("]");
    }
	
	static void displayListNodeAsString(ListNode inputNode) {
    	
		StringBuilder sb = new StringBuilder();
    	if(inputNode == null) {    
          System.out.println("List is empty!");   
    	}
    	
    	sb.append("[ ");
        while(inputNode != null) {
        	sb.append(inputNode.getVal() + " ");
        	inputNode = inputNode.getNext();
        }
        sb.append("]");
        System.out.println(sb.toString().trim());
    }
	
	/**
	 * @return listNodeArray[]
	 * @implNote
	 * This method will return an array with pre-filled sorted listNodes.</br>
	 * You can use this array as an input for various linked list
	 * related programs.
	 */
	static ListNode[] getArrayOfSortedListNodes() {
		ListNode t1 = new ListNode(1, new ListNode(2, new ListNode(4, null)));
		ListNode t2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));
		ListNode t3 = new ListNode();
		ListNode t4 = new ListNode(0);
		ListNode t5 = new ListNode(6, new ListNode(10, new ListNode(14, null)));
		ListNode t6 = new ListNode(1, new ListNode(3, new ListNode(9, new ListNode(15, null))));
		return new ListNode[] {t1, t2, t3, t4, t5, t6};
	}
	
	/**
	 * @param inputNodeArray
	 * @param i
	 * @implNote
	 * Use this method to print two consecutive nodes of ListNodeArray.</br>
	 * Specially used in for loop for printing values of adjacent nodes.
	 */
	static void print2ConsecutiveNodesOfListNodeArray(ListNode[] inputNodeArray, int i) {
		System.out.print("ListNode " + i + ": "); 
		ListNodeOperations.displayListNodeAsString(inputNodeArray[i]);
		System.out.print("ListNode " + (i+1) + ": ");
		ListNodeOperations.displayListNodeAsString(inputNodeArray[i+1]);
	}
	
	static boolean linkedListNodeNullCheck(ListNode inputNode) {
		return (inputNode == null || inputNode.getNext() == null) ? true : false;
	}
	
	static ListNode getOneCyclicLinkedList() {
		ListNode t1 = new ListNode(3);
		ListNode t2 = new ListNode(2);
		ListNode t3 = new ListNode(0);
		ListNode t4 = new ListNode(-4);
		t1.setNext(t2);
		t2.setNext(t3);
		t3.setNext(t4);
		t4.setNext(t2);
		return t1;
	}
	
	static void displayCyclicLinkedListAsString(String printText, ListNode inputNode) {
		if(Optional.ofNullable(printText).isPresent() && !printText.isEmpty()) {
    		System.out.println(printText);
    	}
		displayCyclicLinkedListAsString(inputNode);
	}
	
	static void displayCyclicLinkedListAsString(ListNode inputNode) {
		HashMap<ListNode,Boolean> map = new HashMap<>();
	    if (inputNode != null) {
	    	do {
	    		System.out.print(inputNode.getVal() + " ");
	    		map.put(inputNode, true);
	    		inputNode = inputNode.getNext();
	    	} while (!map.keySet().contains(inputNode) && inputNode != null);
	    	
	        // printing next 3 repetitive nodes of cyclic linked list
	        System.out.print("[ ");
	        for(int i=1;i<=3; i++) {
	        	System.out.print(inputNode.getVal() + " ");
	        	inputNode = inputNode.getNext();
	        }
	        System.out.println("...]");
	    }
	}
	
}
