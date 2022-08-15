package com.shiv.solutions.leetcode.search.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Shivshankar Sahoo
 * 
 * @problem
 * <a href="https://leetcode.com/problems/first-bad-version/">Leetcode</a></br>
 * 
 * @description
 * You are a product manager and currently leading a team to develop a new product.</br>
 * Unfortunately, the latest version of your product fails the quality check.</br>
 * Since each version is developed based on the previous version, all the versions</br>
 * after a bad version are also bad.</br>
 * Suppose you have n versions [1, 2, ..., n] and you want to find out</br>
 * the first bad one, which causes all the following ones to be bad.</br>
 * </br>
 * You are given an API bool isBadVersion(version, totalVersions) which returns 
 * whether version is bad.</br>
 * Implement a function to find the first bad version.</br>
 * You should minimize the number of calls to the API.</br>
 *
 */
public class FirstBadVersion {

	/**
	 * This map holds the data related to versions.</br>
	 * Key of this map represents total number of versions.</br>
	 * Value of this map represents first bad version.</br>
	 */
	static Map<Integer, Integer> versionMap;
	
	static {
		versionMap = new HashMap<>();
		versionMap.put(1, 1);
		versionMap.put(5, 4);
		versionMap.put(8, 2);
		versionMap.put(15, 11);
		versionMap.put(202, 175);
	}
	
	private static boolean isBadVersion(int currentVersion, int totalVersions) {
		if(versionMap.get(totalVersions) <= currentVersion) {
			return true;
		} else
			return false;
	}
	
	public static int firstBadVersion(int n) {
        int firstVersion = 1;
        int lastestVersion = n;
        
        while(firstVersion < lastestVersion) {
            int midVersion = ((lastestVersion - firstVersion) / 2) + firstVersion;
            if(isBadVersion(midVersion, n)) {
                lastestVersion = midVersion;
            } else {
                firstVersion = midVersion + 1;
            }
        }
        
        return firstVersion;
    }
	
	public static void main(String[] args) {
		for(Integer versionsCount : versionMap.keySet()) {
			System.out.println("Total Version Count: " + versionsCount);
			System.out.println("First Bad Version: " + firstBadVersion(versionsCount));
		}
	}

}
