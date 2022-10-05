package com.shiv.solutions.leetcode.level.medium;

import java.util.Arrays;

import com.shiv.solutions.leetcode.constants.Constants;

/**
 * @author Shivshankar Sahoo
 * 
 * @problem
 * <a href="https://leetcode.com/problems/container-with-most-water/description/">Leetcode</a></br>
 * 
 * @description
 * You are given an integer array height of length n.</br>
 * There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) & (i, height[i]).</br>
 * Find two lines that together with the x-axis form a container, such that</br>
 * the container contains the most water.</br>
 * Return the maximum amount of water a container can store.</br>
 * Notice that you may not slant the container.</br>
 * 
 * @explanations
 * <a href="https://leetcode.com/problems/container-with-most-water/solutions/6099/yet-another-way-to-see-what-happens-in-the-on-algorithm/">Leetcode/discussions</a></br>
 * 
 * To solve this problem we use a two pointer solution.</br>
 * <ul><li>Consider one pointer on the extreme left (start of array) and another at extreme right (end of array)</li>
 * <li>Then compare the heights of these locations/index and find the area i.e smallest height * width</li>
 * <li>Then compare this area with the previously calculated one and save the max value and keep on moving the pointer accordingly.
 * <ul><li>if height[left] <= height[right], then left = left + 1</li>
 * <li>if height[left] > height[right], then right = right - 1</li></ul></li>
 * 
 */
public class ContainerWithMostWater {

	public static int maxArea(int[] height) {
        int maxarea = 0;
        int left = 0; 
        int right = height.length - 1;
        while (left < right) {
            int width = right - left;
            maxarea = Math.max(maxarea, Math.min(height[left], height[right]) * width);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxarea;
    }
	
	public static void main(String[] args) {
		int[][] heightsArray = new int[][] {{1, 8, 6, 2, 5, 4, 8, 3, 7}, {1, 1}};
		for(int[] heights : heightsArray) {
			System.out.println("Input Heights: " + Arrays.toString(heights));
			System.out.println("Container with most water (maxArea): " + maxArea(heights) + Constants.NEW_LINE);
		}
	}

}
