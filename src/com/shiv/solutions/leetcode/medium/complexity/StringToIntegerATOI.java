package com.shiv.solutions.leetcode.medium.complexity;

import com.shiv.solutions.leetcode.constants.Constants;

/**
 * @author Shivshankar Sahoo
 * 
 * @problem
 * <a href="https://leetcode.com/problems/string-to-integer-atoi/description/">Leetcode</a></br>
 * 
 * @description
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit</br>
 * signed integer (similar to C/C++'s atoi function).</br>
 * The algorithm for myAtoi(string s) is as follows:</br>
 * Read in and ignore any leading whitespace.</br>
 * Check if the next character (if not already at the end of the string) is '-' or '+'.</br>
 * Read this character in if it is either. This determines if the final result is negative</br>
 * or positive respectively. Assume the result is positive if neither is present.</br>
 * Read in next the characters until the next non-digit character or the end of the input is reached.</br>
 * The rest of the string is ignored.</br>
 * Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32).</br>
 * If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).</br>
 * If the integer is out of the 32-bit signed integer range [-231, 231 - 1],</br>
 * then clamp the integer so that it remains in the range.</br>
 * Specifically, integers less than -231 should be clamped to -231, and integers greater</br>
 * than 231 - 1 should be clamped to 231 - 1.</br>
 * Return the integer as the final result.</br>
 * Note:</br>
 * <ol><li>Only the space character ' ' is considered a whitespace character.</li>
 * <li>Do not ignore any characters other than the leading whitespace or the rest
 * of the string after the digits.</li></ol>
 * 
 */
public class StringToIntegerATOI {

	public static int myAtoi(String s) {
		// check for empty string
		if(s==null) return 0;
		
		//removes leading spaces.
        s = s.trim();
        if(s.length() == 0) return 0;
        
        int result = 0;
        int currIndex = 0;
        int length = s.length();
        boolean isNegative = false;
        int maxLimit = Integer.MAX_VALUE / 10;
        
        // check if a sign is present & skips an index if present
        if(currIndex < length && s.charAt(currIndex) == '-') {
        	isNegative = true;
        	currIndex++;
        } else if(currIndex < length && s.charAt(currIndex) == '+') {
        	currIndex++;
        }
        
        //simply return 0 if first index (or 2nd index if sign present) is not a digit
        if(currIndex < length && !Character.isDigit(s.charAt(currIndex))) return 0;
        
        while(currIndex < length && Character.isDigit(s.charAt(currIndex))){
            int digit = s.charAt(currIndex) - '0';
            
            // check if result exceeds min and max limits of integer
            if(result > maxLimit || (result == maxLimit && digit>7)){
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            
            result = result*10 + digit;
            currIndex++;
        }
        
        if(isNegative) { return result * -1; }
        return result;
    }
	
	public static void main(String[] args) {
		String[] stringArray = new String[] {"42", "   -42", "4193 with words", "+",
				"-+12", "123-", "91283472332", "words and 987"};
		for(String input : stringArray) {
			Constants.printResultsForSingleMethod("Input String: '" + input + "'",
					"Fetched Integer: " + myAtoi(input));
		}
	}

}
