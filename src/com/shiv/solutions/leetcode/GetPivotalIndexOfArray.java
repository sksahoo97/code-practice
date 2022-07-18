package com.shiv.solutions.leetcode;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/find-pivot-index/
 * 
 * The pivot index is the index where the sum of all the numbers
 * strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.
 */
public class GetPivotalIndexOfArray {

	public static int pivotIndex(int[] nums) {
		System.out.println("Input Array: " + Arrays.toString(nums));
        int sum = 0;
        //Find sum of the whole array
        for (int num: nums) sum += num;

        int leftsum = 0;
        for(int i=0; i<nums.length; i++) {
        	// sum is now right sum for index i
            sum -= nums[i];
            if(leftsum == sum) return i;
            leftsum += nums[i];
        }
        return -1;
    }
	
	public static void main(String[] args) {
		System.out.println("Pivot Index: " + pivotIndex(new int[] {1,7,3,6,5,6}));
		System.out.println("Pivot Index: " + pivotIndex(new int[] {1,2,3}));
		System.out.println("Pivot Index: " + pivotIndex(new int[] {2,1,-1}));
		System.out.println("Pivot Index: " + pivotIndex(new int[] {-7,1,5,2,-4,3,0}));
	}

}
