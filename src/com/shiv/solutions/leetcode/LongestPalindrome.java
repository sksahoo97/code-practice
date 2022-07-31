package com.shiv.solutions.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Shivshankar Sahoo
 * 
 * @problem
 * <a href="https://leetcode.com/problems/longest-palindrome/">Leetcode</a></br>
 * 
 * @description
 * Given a string s which consists of lowercase or uppercase letters,</br>
 * return the length of the longest palindrome that can be built with those letters.</br>
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome here.</br>
 * 
 * @explanations
 * Generate a lookup of occurrence of each character.</br>
 * If character appears even number of times, then it can occur same number of times</br>
 * in our result palindrome. So, Add number of occurrences in length.</br>
 * If it appears, odd number of times, add only four even number.</br>
 * i.e., For 5 => 4 i.e., Subtract 1</br>
 * Now, If resultant palindrome length is lesser than actual string length,</br>
 * Add an element at centre. i.e., Add 1 to adjust centre.</br>
 * Because adding a single character at centre still leaves a Palindrome as Palindrome.</br>
 * Example: Assume a palindrome such as "aabbeebbaa".... Now add some randome char at the centre.</br>
 * Then it becomes "aabbedebbaa" and this is also a Palindrome.</br>
 * 
 */
public class LongestPalindrome {

	public static int longestPalindrome(String s) {
		if(s==null || s.length()==0) return 0;

        Set<Character> set = new HashSet<>();
        int count = 0;

        for (char c : s.toCharArray()) {
        	if(!set.contains(c)){
                set.add(c);
            } else {
                set.remove(c);
                count += 2;
            }
        }
        return set.isEmpty() ? count : count+1;
	}
	
	public static int longestPalindromeM2(String s) {
        if(s==null || s.length()==0)
        return 0;
        if(s.length() == 1)
        return 1;
        
        int[] alpha = new int[128];
        int max_length = 0;
        for(char c:s.toCharArray()){
            alpha[c]++;
            if(alpha[c]==2)
            {
                max_length+=2;
                alpha[c]=0;
            }
        }
        if(s.length()>max_length)
        	return max_length+1;
        else
        	return max_length;
    }
	
	public static void main(String[] args) {
		String[] arr = new String[] {"abccccdd", "a"};
		for(String str : arr) {
			System.out.println("Input String: " + str);
			System.out.println("Longest palindrome length using M1: " + longestPalindrome(str));
			System.out.println("Longest palindrome length using M2: " + longestPalindromeM2(str));
		}
	}

}
