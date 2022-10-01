package com.shiv.solutions.leetcode;

/**
 * @author Shivshankar Sahoo
 * 
 * @problem
 * <a href="https://leetcode.com/problems/longest-palindromic-substring/">Leetcode</a></br>
 * 
 * @description
 * Given a string s, return the longest palindromic substring in s.</br>
 * A string is called a palindrome string if the reverse of that string is the same as the original string.</br>
 * 
 */
public class LongestPalindromicSubstring {

	public static String longestPalindrome(String s) {
		int n = s.length(), max = 1, l = 0, r = 0;
        char[] ca = s.toCharArray();
        for (int i = 0; i < n; i++) {
            for (int j = 1; i + j < n && i - j >= 0; j++) {
                if (ca[i + j] != ca[i - j]) break;
                if (2 * j + 1 > max) {
                    max = 2 * j + 1;
                    l = i - j;
                    r = i + j;
                }
            }
            for (int j = 1; i + j < n && i - j + 1 >= 0; j++) {
                if (ca[i + j] != ca[i - j + 1]) break;
                if (2 * j > max) {
                    max = 2 * j;
                    l = i - j + 1;
                    r = i + j;
                }
            }
        }
        return s.substring(l, r + 1);
    }
	
	public static void main(String[] args) {
		String[] words = new String[] {"babad", "cbbd"};
		for(String word :  words) {
			System.out.println("Input string: " + word);
			System.out.println("Longest palindrome substring: " + longestPalindrome(word));
		}
	}

}
