package com.shiv.solutions.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * https://leetcode.com/problems/isomorphic-strings/
 * 
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving
 * the order of characters. No two characters may map to the same character, but a character may map to itself.
 * 
 */
public class IsomorphicStrings {

	public static boolean isIsomorphic(String s, String t) {
        // base case
        if (s == null || t == null) return false;
 
        // if 's' and 't' have different lengths, they cannot be isomorphic
        if (s.length() != t.length()) return false;
 
        // use a map to store a mapping from characters of string 's' to string 'Y'
        Map<Character, Character> map = new HashMap<>();
 
        // use set to store a pool of already mapped characters
        Set<Character> set = new HashSet<>();
 
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i), y = t.charAt(i);
 
            // if 'x' is seen before
            if (map.containsKey(x)) {
                // return false if the first occurrence of `x` is mapped to a
                // different character
                if (map.get(x) != y) {
                    return false;
                }
            }
 
            // if 'x' is seen for the first time (i.e., it isn't mapped yet)
            else {
                // return false if 'y' is already mapped to some other char in 's'
                if (set.contains(y)) {
                    return false;
                }
 
                // map 'y' to 'x' and mark it as mapped
                map.put(x, y);
                set.add(y);
            }
        }
 
        return true;
    }
	
	private static void printOutput(boolean result, String s, String t) {
		System.out.print("Strings " + s + " and " + t);
		System.out.println((result == true) ? " are Isomorphic!" : " are not Isomorphic");
	}
	
	public static void main(String[] args) {
		String[] s1 = new String[] {"bbbaaaba", "egg", "foo", "paper", "aba"};
		String[] s2 = new String[] {"aaabbbba", "add", "bar", "title", "xyy"};
		for(int i=0; i<s1.length; i++) {
			printOutput(isIsomorphic(s1[i], s2[i]), s1[i], s2[i]);
		}
	}

}
