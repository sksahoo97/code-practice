package com.shiv.solutions.leetcode;

import java.util.Arrays;

import com.shiv.solutions.leetcode.constants.Constants;

/**
 * @author Shivshankar Sahoo
 * 
 * @problem
 * <a href="https://leetcode.com/problems/longest-common-prefix/">Leetcode</a></br>
 * 
 * @description
 * Write a function to find the longest common prefix string amongst an array of strings.</br>
 * If there is no common prefix, return an empty string "".</br>
 * Constraints:</br>
 * <ul><li>1 <= strs.length <= 200</li>
 * <li>0 <= strs[i].length <= 200</li>
 * <li>strs[i] consists of only lowercase English letters.</li></ul>
 * 
 */
public class LongestCommonPrefix {

	private static String longestCommonPrefix(String[] strs) {
		if(strs.length == 1)
			return strs[0];
        String firstString = strs[0];
        String commonPrefix = null;
        for(int i=1; i<=firstString.length(); i++) {
            String temp = firstString.substring(0,i);
            if(check(strs, temp)) {
            	commonPrefix = temp;
            } else
            	break;
        }

        return commonPrefix != null ? commonPrefix : "";
    }

    private static boolean check(String[] strs, String prefix) {
    	boolean isMatch = false;
        for(int i=1; i<strs.length; i++) {
            if(strs[i].startsWith(prefix)) {
            	isMatch = true;
                continue;
            } else
                return false;
        }
        return isMatch;
    }
	
	public static void main(String[] args) {
		final String[][] stringArray = new String[][] {{"flower", "flower", "flower", "flower"}, {"c", "c"},
			{"flower", "flow", "flight"}, {"dog", "racecar", "car"}, {"a"}};
		for(String[] input : stringArray) {
			System.out.println("Input string array: " + Arrays.toString(input));
			System.out.println("Longest Common Prefix: " + longestCommonPrefix(input) + Constants.NEW_LINE);
		}
	}

}
