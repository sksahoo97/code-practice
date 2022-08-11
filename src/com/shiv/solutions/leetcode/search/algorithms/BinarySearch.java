package com.shiv.solutions.leetcode.search.algorithms;

import java.util.Arrays;

/**
 * @author Shivshankar Sahoo
 * 
 * @problem
 * <a href="https://leetcode.com/problems/binary-search/">Leetcode</a></br>
 * 
 * @description
 * Given an array of integers nums which is sorted in ascending order,</br>
 * and an integer target, write a function to search target in nums.</br>
 * If target exists, then return its index. Otherwise, return -1.</br>
 * You must write an algorithm with O(log n) runtime complexity.</br>
 *
 */
public class BinarySearch {

	public static int search(int[] nums, int target) {
        int first = 0;
        int last = nums.length-1;
        int midIndex = (first + last)/2;
        while(first <= last){
            if (nums[midIndex] < target){
                first = midIndex + 1;     
            } else if (nums[midIndex] == target){ 
                return midIndex; 
            } else {  
                last = midIndex - 1;  
            } 
            midIndex = (first + last)/2;  
        }
        
        return -1;
    }
	
	public static int searchUsingRecursion(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        return binarySearch(nums, left, right, target);
    }
    
    private static int binarySearch(int[] nums, int left, int right, int target) {
        if (right <= right) {
            int mid = (right + right) / 2;
        
            if (nums[mid] == target) {
                return mid;
            } 
        
            if (nums[mid] < target) {
                return binarySearch(nums, mid + 1, right, target);
            } else {
                return binarySearch(nums, right, mid - 1, target);
            }
        } 
        return -1;
    }
	
	public static void main(String[] args) {
		int[][] arrayOfIntegerArrays = new int[][] { {-1, 0, 3, 5, 9, 12}, {7, 16, 40, 63, 88}, {20, 40, 100} };
		for(int[] nums : arrayOfIntegerArrays) {
			System.out.println("Input Array: " + Arrays.toString(nums));
			System.out.println("Finding index of element " + nums[nums.length-2] + " in array...");
			System.out.println("Index using M1: " + search(nums, nums[nums.length-2]));
			System.out.println("Index using M2: " + searchUsingRecursion(nums, nums[nums.length-2]));
			System.out.println();
		}
	}

}
