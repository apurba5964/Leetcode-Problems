package com.ub.leetcode;

import java.util.ArrayList;

public class TwoSum {

	public static void main(String[] args) {
		int[] input = {2, 7, 11, 15};
		System.out.println(twoSum(input, 18));

	}
	
public static ArrayList<Integer> twoSum(int[] nums, int target) {
	ArrayList<Integer> result = new ArrayList<>();
	
	for(int i=0;i<nums.length-1;i++) {
		
		for(int j=i+1;j<nums.length;j++) {
			if(nums[i]+nums[j]==target) {
				result.add(i);
				result.add(j);
				break;
			}
				
			
			
		}
	}
	
	
	return result;
        
    }

}
