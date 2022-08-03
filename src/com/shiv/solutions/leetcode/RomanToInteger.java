package com.shiv.solutions.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Shivshankar Sahoo
 * 
 * @problem
 * <a href="https://leetcode.com/problems/roman-to-integer/">Leetcode</a></br>
 * 
 * @description
 * Given a roman numeral, convert it to an integer.</br>
 * Roman numerals are usually written largest to smallest from left to right.</br>
 * However, the numeral for four is not IIII. Instead, the number four is written as IV.</br>
 * Because the one is before the five we subtract it making four.</br>
 * The same principle applies to the number nine, which is written as IX.</br>
 * There are six instances where subtraction is used:</br>
 * I can be placed before V (5) and X (10) to make 4 and 9.</br>
 * X can be placed before L (50) and C (100) to make 40 and 90.</br>
 * C can be placed before D (500) and M (1000) to make 400 and 900.</br>
 *
 */
public class RomanToInteger {
	
	static Map<Character, Integer> romanValues;
	
	static {
		romanValues = new HashMap<>();
		romanValues.put('I', 1);
		romanValues.put('V', 5);
		romanValues.put('X', 10);
		romanValues.put('L', 50);
		romanValues.put('C', 100);
		romanValues.put('D', 500);
		romanValues.put('M', 1000);
	}

	public static int romanToIntOptimised(String s) {
        int sum = 0;
        char[] charArray = s.toCharArray();
        for(int i=0 ;i<charArray.length-1; i++) {
            if(romanValues.get(charArray[i]) >= romanValues.get(charArray[i + 1])) {
                sum += romanValues.get(charArray[i]);
            } else {
                sum -= romanValues.get(charArray[i]);
            }    
        }
        return sum + romanValues.get(charArray[charArray.length - 1]);
    }
	
	public static int romanToInt(String s) {
        int num = 0;
        char[] c = s.toCharArray();
        for(int i=0; i<c.length; i++) {
        	if(i <= c.length-2) {
        		if(checkForOppositeOrder(c[i], c[i+1])) {
        			num += romanValues.get(c[i+1]) - romanValues.get(c[i]);
                	i++;
        		} else
        			num += romanValues.get(c[i]);
        	} else
            	num += romanValues.get(c[i]);
        }
        return num;
    }
	
	private static boolean checkForOppositeOrder(char current, char next) {
		if(current == 'I' && (next == 'V' || next == 'X')) {
			return true;
		} else if(current == 'X' && (next == 'L' || next == 'C')) {
			return true;
        } else if(current == 'C' && (next == 'D' || next == 'M')) {
        	return true;
        }
		return false;
	}
	
	public static void main(String[] args) {
		String[] romanNums = new String[] {"III", "LVIII", "MCMXCIV"};
		for(String roman: romanNums) {
			System.out.println("Input Roman number: " + roman);
			System.out.println("Roman To Int using M1: " + romanToInt(roman));
			System.out.println("Roman To Int using M2: " + romanToIntOptimised(roman));
			System.out.println();
		}
	}

}
