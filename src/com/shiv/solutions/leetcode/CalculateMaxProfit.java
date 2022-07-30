package com.shiv.solutions.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Shivshankar Sahoo
 * 
 * @problem
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/">Leetcode</a></br>
 * 
 * @description
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.</br>
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a</br>
 * different day in the future to sell that stock.</br>
 * Return the maximum profit you can achieve from this transaction.</br>
 * If you cannot achieve any profit, return 0.
 * 
 * @explanations
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/discuss/1735493/JavaC%2B%2B-best-ever-EXPLANATION-could-possible/">Leetcode</a></br>
 *
 */
public class CalculateMaxProfit {

	public static int maxProfit(int[] prices) {
        int min = prices[0], max = prices[0];
        int minIndex = 0, maxIndex = 0;
        Set<Integer> profitSet = new HashSet<>();
        for(int i=0; i<prices.length; i++) {
            if(min > prices[i]) {
                min = prices[i];
                minIndex = i;
            }
            if(max < prices[i]) {
                max = prices[i];
                maxIndex = i;
            }
            if(maxIndex < minIndex) {
            	max = prices[i];
            }
            if((max - min) >= 0 && (minIndex < maxIndex)) {
            	profitSet.add((max - min));
            }
        }
        
        if(!profitSet.isEmpty()) return Collections.max(profitSet);
        		
        return 0;
    }
	
	public static int maxProfitOptimmised(int[] prices) {
		int profit = 0;
        int len = prices.length;
        int iBuy = 0; // index when buying
        for(int i=0;i<len;i++){
            if(prices[iBuy] > prices[i]) iBuy = i;
            profit = Math.max(profit, prices[i] - prices[iBuy]);
        }
        return profit;
	}
	
	public static void main(String[] args) {
		int[][] arrayOfPriceArrays = new int[][] { {7, 1, 5, 3, 6, 4}, {7, 6, 4, 3, 1}, {2, 4, 1} };
		for(int[] intArr : arrayOfPriceArrays) {
			System.out.println("Input array of per day stock price: " + Arrays.toString(intArr));
			System.out.println("Max Profit using method1: " + maxProfit(intArr));
			System.out.println("Max Profit using method2: " + maxProfitOptimmised(intArr));
		}
	}

}
