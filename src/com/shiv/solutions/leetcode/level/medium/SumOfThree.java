package com.shiv.solutions.leetcode.level.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.shiv.solutions.leetcode.constants.Constants;

/**
 * @author Shivshankar Sahoo
 * 
 * @problem
 * <a href="https://leetcode.com/problems/3sum/description/">Leetcode</a></br>
 * 
 * @description
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]</br>
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.</br>
 * Notice that the solution set must not contain duplicate triplets.</br>
 * Note that the order of the output and the order of the triplets does not matter.</br>
 * Constraints:</br>
 * <ul><li>3 <= nums.length <= 3000</li>
 * <li>-105 <= nums[i] <= 105</li></ul>
 * 
 */
public class SumOfThree {

	/**
	 * The solution uses set without sorting elements</br>
     * Time complexity: O(N * N * log3)</br>
	 * Space complexity: O(N)</br>
	 */
	private static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> resultSet = new HashSet<List<Integer>>();
        Set<Integer> duplicatedSet = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length-2; i++) {
            if (!duplicatedSet.add(nums[i])) continue;

            for (int j = i+1; j<nums.length; j++) {
                int value = 0 - nums[i] - nums[j];
                if (map.containsKey(value) && map.get(value) == i) {
                    List<Integer> list = new ArrayList<>(Arrays.asList(nums[i], nums[j], value));
                    Collections.sort(list);
                    resultSet.add(list);
                }
                map.put(nums[j], i);
            }
        }
        return new ArrayList<>(resultSet) ;
    }
	
	/**
	 * The solution uses brute force mechanism</br>
	 * Time complexity: O(N * N * N * log3)</br>
	 * Space complexity: O(N)</br>
	 */
	private static List<List<Integer>> threeSumBruteForce(int[] nums) {
        Set<List<Integer>> resultSet = new HashSet<List<Integer>>();
        for (int i=0; i<nums.length - 2; i++)
            for (int j= i+1; j<nums.length - 1; j++)
                for (int k = j+1 ; k<nums.length; k++)
                    if (0 == nums[i] + nums[j] + nums[k]) {
                        List<Integer> list = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k]));
                        Collections.sort(list);
                        resultSet.add(list);
                    }
        return new ArrayList<>(resultSet);
    }
	
	/**
	 * The solution uses two pointers along with sorting of elements</br>
	 * Time complexity: O(n^2)</br>
	 * Space complexity: O(1)</br>
	 */
	private static List<List<Integer>> threeSumUsingTwoPointersAlongWithSorting(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(nums);

		for (int i=0; i<nums.length-2; i++) {
			if (i != 0 && nums[i] == nums[i-1])
				continue;
			int left = i + 1, right = nums.length - 1;
			int sum = 0 - nums[i];

			while (left < right) {
				if (nums[left] + nums[right] == sum) {
					result.add(Arrays.asList(nums[i], nums[left], nums[right]));

					while (left < right && nums[left] == nums[left + 1])
						left++;

					while (left < right && nums[right] == nums[right - 1])
						right--;

					left++;
					right--;
				} else if (nums[left] + nums[right] < sum)
					left++;
				else
					right--;
			}
		}

		return result;
	}
	
	/**
	 * The solution uses binary search</br>
	 * Time complexity: O(N * logN + N * N * logN)</br>
	 * Space complexity: O(LogN)</br>
	 */
	private static List<List<Integer>> threeSumUsingBinarySearch(int[] nums) {
        Set<List<Integer>> resultSet = new HashSet<List<Integer>>();
        Arrays.sort(nums);

        for(int i=0; i < nums.length-2 && nums[i] <= 0;){
            for (int j = i+1; j < nums.length && nums[i] + nums[j] <= 0;) {
                int value = 0 - nums[i] - nums[j];
                if (value < 0) return new ArrayList<>(resultSet);
                int idx = Arrays.binarySearch(nums, j+1, nums.length, value);
                if (idx >= 0)
                    resultSet.add(Arrays.asList(nums[i], nums[j], value));
                j++;
                while (j < nums.length && nums[j] == nums[j-1]) j++;
            }
            i++;
            while(i < nums.length - 2 && nums[i] == nums[i-1]) i++;
        }
        return new ArrayList<>(resultSet);
    }
	
	public static void main(String[] args) {
		final String printConstant = "Arrays with sum of 3 using";
		int[][] numsArray = new int[][] {{0, 0, 0}, {0, 0, 0, 0}, {1, 1, 1}, {3, 0, -2, -1, 1, 2}, 
			{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4}, {-1, 0, 1, 2, -1, -4}, {0, 1, 1}};
		for(int[] nums : numsArray) {
			System.out.println("Input integer array: " + Arrays.toString(nums));
			System.out.println(printConstant + " M1: " + Constants.NEW_LINE + 
					threeSum(nums) + Constants.NEW_LINE);
			System.out.println(printConstant + " M2: " + Constants.NEW_LINE + 
					threeSumBruteForce(nums) + Constants.NEW_LINE);
			System.out.println(printConstant + " M3: " + Constants.NEW_LINE + 
					threeSumUsingTwoPointersAlongWithSorting(nums) + Constants.NEW_LINE);
			System.out.println(printConstant + " M4: " + Constants.NEW_LINE + 
					threeSumUsingBinarySearch(nums) + Constants.NEW_LINE);
			System.out.println(Constants.ASTERISK_LINE);
		}
	}

}
