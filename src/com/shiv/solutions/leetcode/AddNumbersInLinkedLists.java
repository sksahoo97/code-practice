package com.shiv.solutions.leetcode;

/*
 * https://leetcode.com/problems/add-two-numbers/
 * 
 * Given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 
 * Example 1:
 * Input: t1 = [2,4,3], t2 = [5,6,4] 	{[2 -> 4 -> 3], [5 -> 6 -> 4]}
 * Output: [7,0,8] 						{[7 -> 0 -> 8]}
 * Explanation: 342 + 465 = 807
 * 
 */
class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class AddNumbersInLinkedLists {
	
	public static void display(ListNode inputNode) {
    	
    	if(inputNode == null) {    
          System.out.println("List is empty!");    
          return;    
    	}
    	
    	System.out.print("[ ");
        while(inputNode != null) {
        	System.out.print(inputNode.val + " ");
        	inputNode = inputNode.next;
        }
        System.out.print("]"); 
    }
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		System.out.print("\nAdding elements of 1st list: ");
		display(l1);
		System.out.print(", with elements of 2nd list: ");
		display(l2);
		
        int sum = 0;
        ListNode resListNode = new ListNode();
        ListNode copyListNode = resListNode;
        
        //start iteration
        while(l1!=null || l2!=null || sum!= 0) {
            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            
            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            ListNode newListNode = new ListNode();
            newListNode.val = sum%10;
            copyListNode.next = newListNode;
            copyListNode = newListNode;
            
            
            sum/=10;   //will always be 0 or 1
        }
        
        return resListNode.next;
    }
	
	public static void main(String[] args) {
		
		ListNode t1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
		ListNode t2 = new ListNode(5, new ListNode(6, new ListNode(4, null)));
		ListNode result = addTwoNumbers(t1, t2);
		System.out.print("\nAddition result: ");
		display(result);
		
		ListNode t3 = new ListNode(0, null);
		ListNode t4 = new ListNode(0, null);
		result = addTwoNumbers(t3, t4);
		System.out.print("\nAddition result: ");
		display(result);
		
		ListNode t5 = new ListNode(9, new ListNode(9, new ListNode(9, 
				new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, null)))))));
		ListNode t6 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, null))));
		result = addTwoNumbers(t5, t6);
		System.out.print("\nAddition result: ");
		display(result);
	}

}
