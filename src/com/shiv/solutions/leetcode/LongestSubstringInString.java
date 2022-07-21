package com.shiv.solutions.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 * Find the length of the longest substring without repeating characters.
 * 
 */
public class LongestSubstringInString {

	static String getUniqueCharacterSubstring(String input) {
	    Map<Character, Integer> visited = new HashMap<>();
	    String output = "";
	    System.out.println("Input String: " + input);
	    for (int start = 0, end = 0; end < input.length(); end++) {
	        char currChar = input.charAt(end);
	        if (visited.containsKey(currChar)) {
	            start = Math.max(visited.get(currChar)+1, start);
	        }
	        if (output.length() < end - start + 1) {
	            output = input.substring(start, end + 1);
	        }
	        visited.put(currChar, end);
	    }
	    return output;
	}
	
	public static int lengthOfLongestSubstring(String str) {
	    int len = str.length();
	    int result = 0;
	    if(len == 0) return 0;
	    
	    for(int i=0; i<len; i++) {
	        boolean[] visited = new boolean[256];
	        for(int j=i; j<len; j++) {
	            if (visited[str.charAt(j)] == true)
	                break;
	            else {
	                result = Math.max(result, j - i + 1);
	                visited[str.charAt(j)] = true;
	            }
	        }
	        visited[str.charAt(i)] = false;
	    }
	    return result;
	}
	
	public static void main(String[] args) {
		String outConst = "Longest substring: ";
		String outConst1 = "Length of ";
		String[] sArray = new String[] {"pwwkew", "bbbbb", "abcabcbb"};
		for(String str : sArray) {
			System.out.println(outConst + getUniqueCharacterSubstring(str));
			System.out.println(outConst1 + outConst + lengthOfLongestSubstring(str));
			System.out.println("*****************************");
		}
	}

}
