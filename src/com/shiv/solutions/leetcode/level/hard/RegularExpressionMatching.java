package com.shiv.solutions.leetcode.level.hard;

/**
 * @author Shivshankar Sahoo
 * 
 * @problem
 * <a href="https://leetcode.com/problems/regular-expression-matching/description/">Leetcode</a></br>
 * 
 * @description
 * Given an input string s and a pattern p, implement regular expression</br>
 * matching with support for '.' and '*' where:</br>
 * <ul><li>'.' Matches any single character.</li>​​​​
 * <li>'*' Matches zero or more of the preceding element.</li></ul>
 * 
 * Constraints:</br>
 * <ul><li>1 <= s.length <= 20 </li>
 * <li>1 <= p.length <= 30 </li>
 * <li>s contains only lowercase English letters</li>
 * <li>p contains only lowercase English letters, '.', and '*'.</li>
 * <li>It is guaranteed for each appearance of the character '*', 
 * there will be a previous valid character to match.</li></ul>
 * 
 * @explanations
 * <a href="https://www.youtube.com/watch?v=l3hda49XcDE">Youtube</a></br>
 * 
 */
public class RegularExpressionMatching {

	/**
     * Dynamic programming technique for regex matching.
     */
	public static boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int j = 1; j<=p.length(); j++){
            if(p.charAt(j-1) == '*' && dp[0][j-2]){
                dp[0][j] = true;
            }
        }
        for (int i = 1; i<=s.length(); i++){
            for (int j = 1; j<=p.length(); j++){
                if(p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) == '.'){
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(p.charAt(j-1) == '*'){
                    if(p.charAt(j-2) != s.charAt(i-1) && p.charAt(j-2)!='.'){
                        dp[i][j] = dp[i][j-2];
                    }
                    else{
                        dp[i][j] = (dp[i][j-2] || dp[i][j-1] || dp[i-1][j]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
	
	/**
     * Dynamic programming technique for regex matching.
     */
	public static boolean matchRegex(char[] text, char[] pattern) {
        boolean T[][] = new boolean[text.length + 1][pattern.length + 1];

        T[0][0] = true;
        //Deals with patterns like a* or a*b* or a*b*c*
        for (int i = 1; i < T[0].length; i++) {
            if (pattern[i-1] == '*') {
                T[0][i] = T[0][i - 2];
            }
        }

        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T[0].length; j++) {
                if (pattern[j - 1] == '.' || pattern[j - 1] == text[i - 1]) {
                    T[i][j] = T[i-1][j-1];
                } else if (pattern[j - 1] == '*')  {
                    T[i][j] = T[i][j - 2];
                    if (pattern[j-2] == '.' || pattern[j - 2] == text[i - 1]) {
                        T[i][j] = T[i][j] | T[i - 1][j];
                    }
                } else {
                    T[i][j] = false;
                }
            }
        }
        return T[text.length][pattern.length];
    }
	
	public static boolean isMatchRecursion(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();
        boolean first_match = (!text.isEmpty() &&
                               (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            return (isMatch(text, pattern.substring(2)) ||
                    (first_match && isMatch(text.substring(1), pattern)));
        } else {
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }
	
	public static void main(String[] args) {
		String[] textArray = new String[] {"aab", "aa", "aa", "ab",
				"abbbbccc", "xaabyc"};
		String[] patternArray = new String[] {"c*a*b", "a", "a*", ".*",
				"aa*bbb*bbbc*", "xa*b.c"};
		for(int i=0; i<textArray.length; i++) {
			System.out.println("Input Text: " + textArray[i]);
			System.out.println("Input Pattern: " + patternArray[i]);
			System.out.println("Pattern Matching using M1: " + isMatch(textArray[i], patternArray[i]));
			System.out.println("Pattern Matching using M2: " + matchRegex(textArray[i].toCharArray(), patternArray[i].toCharArray()));
			System.out.println("Pattern Matching using M3: " + isMatchRecursion(textArray[i], patternArray[i]));
			System.out.println();
		}
	}

}
