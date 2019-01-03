/*
https://leetcode.com/problems/remove-duplicates-from-sorted-array/
https://leetcode.com/problems/remove-element/
*/
package com.ub.leetcode;

public class RemoveDuplicatesInPlace {

	public static void main(String[] args) {
		
		int[] input = {0,1,2,2,3,0,4,2};
		System.out.println(removeElement(input, 2));
		
				
	}
	
	
public static int removeDuplicates(int[] nums) {
       
	if(nums.length==0)
		return 0;
	
	int i=0;
	for(int j=1;j<nums.length;j++) {
	
		if(nums[i]!=nums[j]) {
			i++;
			nums[i]=nums[j];
		}
		
	}
       return i+1;
    }


public static int removeElement(int[] nums, int val) {
	if(nums.length==0)
		return 0;
	
	int i=0;
	for(int j=0;j<nums.length;j++) {
		
		if(nums[j]!=val) {
			 {
				//i++;	
			nums[i]=nums[j];
			i++;
			}
			
		}
		
	}
	
	
	return i;
    
}
	
}
