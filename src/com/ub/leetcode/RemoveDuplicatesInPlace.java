/*
https://leetcode.com/problems/remove-duplicates-from-sorted-array/
*/
package com.ub.leetcode;

public class RemoveDuplicatesInPlace {

	public static void main(String[] args) {
		
	}
	
	
public static int removeDuplicates(int[] nums) {
       
	if(nums.length==0)
		return 0;
	
	int i=0;
	for(int j=1;j<nums.length;j++)
	
		if(nums[i]!=nums[j]) {
			i++;
			nums[i]=nums[j];
		}
		
	
       return i+1;
    }
	
	
}
