package com.shiv.solutions.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/two-sum/
 * 
 * Given an array of integers nums and an integer target, return indices of
 * the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 * You can return the answer in any order.
 * 
 */
public class ArrayTwoSum {

	// Time complexity: O(n^2)
	private static int[] twoSum(int[] nums, int target) {
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
            
        }
        return new int[] {};
    }
	
	// Time complexity: O(n)
	private static int[] findTwoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[] { numMap.get(complement), i };
            } else {
                numMap.put(nums[i], i);
            }
        }
        return new int[] {};
    }
	
	// Time complexity: O(n*log(n))
    private static int[] findTwoSum_Sorting(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            if(nums[left] + nums[right] == target) {
                return new int[] {nums[left], nums[right]};
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] {};
    }
    
    private static void printOutput(int[] nums, int target) {
    	if(nums.length != 0) {
    		System.out.println("Input Array: " + Arrays.toString(nums));
    		System.out.println("Indexes of elements, whose sum match to target " + target + " are...");
    		System.out.println("Resultant indexes using brute force: " + Arrays.toString(twoSum(nums, target)));
    		System.out.println("Resultant indexes using hash map: " + Arrays.toString(findTwoSum(nums, target)));
    		System.out.println("Resultant elements using Sorting with 2-pointer approach: "
    					+ Arrays.toString(findTwoSum_Sorting(nums, target)));
    		System.out.println("********************************\n");
    	}
    }
	
	public static void main(String[] args) {
		printOutput(new int[] {3, 2, 6}, 9);
		printOutput(new int[] {2, 7, 11, 15}, 9);
		printOutput(new int[] {3, 2, 4}, 6);
		printOutput(new int[] {3, 3}, 6);
	}

}
