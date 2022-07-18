package com.shiv.solutions.leetcode;

/*
 * https://leetcode.com/problems/is-subsequence/submissions/
 * 
 * A subsequence of a string is a new string that is formed from the original string
 * by deleting some (can be none) of the characters without disturbing the relative
 * positions of the remaining characters.
 * (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 * 
 */
public class CheckForSubsequence {

	public static boolean isSubsequence(String s, String t) {
        
        if(s==null || t==null)
            return false;
        
        System.out.println("Checking whether " + s + " is a subsequence of " + t + "...");
        //condition only for testcase
        //assumes that s is shorter and t is longer always
        if(t.isEmpty()) {
            if(s.isEmpty()) {
            	//s is assumed to be shorter string
            	//it can be a empty string
                return true;
            } else
                return false;
        }
        
        int bingo = 0;
        String longer = s.length() > t.length() ? s : t;
        String shorter = s.length() <= t.length() ? s : t;
        
        for(int i=0; i<longer.length() && bingo<shorter.length(); i++) {
            if(longer.charAt(i) == shorter.charAt(bingo)) {
                bingo ++;
            }
        }
        
        if(bingo == shorter.length()) return true;
        
        return false;
    }
	
	public static void main(String[] args) {
		System.out.println("Result: " + isSubsequence("abc", ""));
		System.out.println("Result: " + isSubsequence("", ""));
		System.out.println("Result: " + isSubsequence("", "afgagaga"));
		System.out.println("Result: " + isSubsequence("abc", "agjgbgdc"));
		System.out.println("Result: " + isSubsequence("aec", "dhhhdhd"));
		System.out.println("Result: " + isSubsequence("gfh", "goiohfsd"));
	}

}
