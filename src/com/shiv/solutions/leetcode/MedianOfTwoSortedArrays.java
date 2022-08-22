package com.shiv.solutions.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Shivshankar Sahoo
 * 
 * @problem
 * <a href="https://leetcode.com/problems/https://leetcode.com/problems/median-of-two-sorted-arrays/">Leetcode</a></br>
 * 
 * @description
 * Given two sorted arrays nums1 and nums2 of size m and n respectively,</br>
 * return the median of the two sorted arrays.</br>
 * The overall run time complexity should be O(log (m+n))</br>
 *
 */
public class MedianOfTwoSortedArrays {

	private final static String DISP_CONSTANT = "After merging both arrays: ";
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> numList = Stream
        						.concat(Arrays.stream(nums1).boxed(), Arrays.stream(nums2).boxed())
        						.sorted()
        						.collect(Collectors.toList());
        System.out.println(DISP_CONSTANT + numList);
        return getMedian(numList);
    }
	
	public static double findMedianSortedArraysM2(int[] nums1, int[] nums2) {
        int nums1Len = nums1.length;
        int nums2Len = nums2.length;
        int[] nums = new int[nums1Len + nums2Len];
  
        System.arraycopy(nums1, 0, nums, 0, nums1Len);
        System.arraycopy(nums2, 0, nums, nums1Len, nums2Len);
  
        Arrays.sort(nums);
        System.out.println(DISP_CONSTANT + Arrays.toString(nums));
        return getMedian(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    }
	
	private static double getMedian(List<Integer> numList) {
		int mid = numList.size()/2;
        if(numList.size() % 2 == 1) {
            return (double) numList.get(mid);
        } else {
            return (double) (numList.get(mid) + numList.get(mid - 1)) / 2;
        }
	}
	
	public static void main(String[] args) {
		int[] nums1 = new int[] {3, 6};
		int[] nums2 = new int[] {7, 9};
		System.out.println("Input Arrays: " + Arrays.toString(nums1) + ", " + Arrays.toString(nums2));
		System.out.println("Using M1:-");
		System.out.println("Median: " + findMedianSortedArrays(nums1, nums2));
		System.out.println("Using M2:-");
		System.out.println("Median: " + findMedianSortedArraysM2(nums1, nums2));
	}

}
