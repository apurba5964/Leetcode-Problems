/*
https://leetcode.com/problems/valid-palindrome/
https://leetcode.com/problems/single-number/
*/
package com.ub.leetcode.easy;

public class ValidPalindrome {

	public static void main(String[] args) {

		
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		int[] input = {4,1,2,1,2};
		System.out.println(singleNumber(input));
	}

	public static boolean isPalindrome(String s) {
		if(s.isEmpty())
			return true;
		
		s=s.trim().toLowerCase().replaceAll("\\s+", "").replaceAll("[^A-Za-z0-9]", "");;
		StringBuilder sbuild = new StringBuilder(s);
		
		String temp=sbuild.reverse().toString().toLowerCase();
		
		
		if(temp.equalsIgnoreCase(s))
			return true;
		else
			return false;

	}
	
	 public static int singleNumber(int[] nums) {
		
		 int result = 0;
		 for(int i=0;i<nums.length;i++) {
		 
			 result = result ^ nums[i];
		 }
		 
		 
		return result;
	        
	    }

}
