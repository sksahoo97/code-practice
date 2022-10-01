package com.shiv.solutions.leetcode.medium.complexity;

/**
 * @author Shivshankar Sahoo
 * 
 * @problem
 * <a href="https://leetcode.com/problems/reverse-integer/">Leetcode</a></br>
 * 
 * @description
 * Given a signed 32-bit integer x, return x with its digits reversed.</br>
 * If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1],</br>
 * then return 0.</br>
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).</br>
 * 
 * @explanations
 * <a href="https://leetcode.com/problems/reverse-integer/solutions/138782/reverse-integer/">Leetcode/reverse-integer/solutions</a></br>
 * 
 */
public class ReverseInteger {

	private static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
	
	public static void main(String[] args) {
		int[] nums = new int[] {123, -123, 120};
		for(int x : nums) {
			System.out.println("Input number: " + x);
			System.out.println("Reversed number: " + reverse(x));
			System.out.println();
		}
	}

}
