/*
 * https://leetcode.com/problems/longest-common-prefix/
*/
package com.ub.leetcode;

import java.util.Arrays;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		String[] input= {"abc","abcde","abcd"};
		System.out.println(longestCommonPrefix(input));
	}
	
public static String longestCommonPrefix(String[] strs) {
	if (strs.length == 0) return "";
	StringBuilder result = new StringBuilder();
	
	if(strs.length>0 && strs!=null) {
	Arrays.sort(strs);
	
	char[] start = strs[0].toCharArray(); 
	char[] end = strs[strs.length-1].toCharArray();
	
	
	for(int i=0;i<start.length;i++) {
		if(start[i]==end[i])
			result.append(start[i]);
		else
			return result.toString();
		
	}
	
	
	
	}
	return result.toString();
     
        
    }
}
