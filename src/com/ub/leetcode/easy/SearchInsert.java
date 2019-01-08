/*
https://leetcode.com/problems/search-insert-position/
*/
package com.ub.leetcode.easy;

public class SearchInsert {

	public static void main(String[] args) {
	
		int[] nums= {1,3,5,6};
		int target = 7;
		System.out.println(searchInsert(nums, target));
		System.out.println(searchInsertLog(nums, target));
	}
	
	
    public static int searchInsert(int[] nums, int target) {
    	
    	int i=0;
    	
    	for(;i<nums.length;i++) {
    		
    		if(nums[i]==target)
    			return i;
    		else if (nums[i]<target){
    			continue;
    		}else
    			return i;
    	}
    	
    	
		return i;
        
    }
//O(Logn )time	
public static int searchInsertLog(int[] nums, int target) {
    	
    	int l =0;
    	int h =nums.length;
    	
    	
    	
    	
    	
    	
    	while(l<h) {
    		int mid = (l+h)/2;
    		if(nums[mid]<target)
    			l=mid+1;
    		else
    			h=mid;
    	}
        
    	return l;
    }
	
	
	
}
