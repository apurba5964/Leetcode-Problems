package com.ub.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

	public static void main(String[] args) {
		int[] input = {1, 0, -1, 0, -2, 2};
		int target =0;
		System.out.println(fourSum(input, target));

	}
	
	
public static List<List<Integer>> fourSum(int[] nums, int target) {
	
	ArrayList<List<Integer>> result =new ArrayList<>();
	Arrays.sort(nums);
	
	
	for(int i=0;i<nums.length-3;i++) {
		
		for(int j=0;j<nums.length-2;j++) {
			int k=j+1;
			int n=nums.length-1;
			int sum=0;
			sum=nums[i]+nums[j]+nums[k]+nums[n];
			
			while(k<n) {
			if(sum==target) {
				while (k<n && nums[k] == nums[k+1]) k++;
                while (k<n && nums[n] == nums[n-1]) n--;
				result.add(Arrays.asList(nums[i],nums[j],nums[k],nums[n]));
				k++;
				n--;
			}
			
			if(sum<target)
				k++;
			else
				n--;
			
			
			}
			
			
			
		}
	}
	
	
	return result;
        
    }

}
