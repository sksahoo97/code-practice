package com.shiv.solutions.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/roman-to-integer/
 * @author aweso
 *
 */
public class RomanToInteger {

	public static int romanToIntOptimised(String s) {
        Map<Character,Integer> RomanVal = new HashMap<>();
        RomanVal.put('I',1);
        RomanVal.put('V',5);
        RomanVal.put('X',10);
        RomanVal.put('L',50);
        RomanVal.put('C',100);
        RomanVal.put('D',500);
        RomanVal.put('M',1000);
        int sum = 0;
        char[] Array = s.toCharArray();
        int Lenght = s.length();
        for(int i = 0 ;i < Lenght - 1; i++) {
            if(RomanVal.get(Array[i]) >= RomanVal.get(Array[i + 1])) {
                sum+=RomanVal.get(Array[i]);
            }else{
                sum-=RomanVal.get(Array[i]);
            }    
        }
        return sum+RomanVal.get(Array[Array.length - 1]);
    }
	
	public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int length = s.length();
        int temp = 0;
        char[] c = s.toCharArray();
        for(int i=0; i<length; i++) {
            if(i <= length-2) {
                if(c[i] == 'I' && (c[i+1] == 'V' || c[i+1] == 'X')) {
                    temp += map.get(c[i+1]) - map.get(c[i]);
                    i++;
                }else if(c[i] == 'X' && (c[i+1] == 'L' || c[i+1] == 'C')) {
                    temp += map.get(c[i+1]) - map.get(c[i]);
                    i++;
                }else if(c[i] == 'C' && (c[i+1] == 'D' || c[i+1] == 'M')) {
                    temp += map.get(c[i+1]) - map.get(c[i]);
                    i++;
                } else
                	temp += map.get(c[i]);
            } else
            	temp += map.get(c[i]);
            
        }
        return temp;
    }
	
	public static void main(String[] args) {
		String[] romanNums = new String[] {"III", "LVIII", "MCMXCIV"};
		for(String roman: romanNums) {
			System.out.println(romanToInt(roman));
			System.out.println(romanToIntOptimised(roman));
		}
	}

}
