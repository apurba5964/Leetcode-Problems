/*
https://leetcode.com/problems/3sum/
*/
package com.ub.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

public static void main(String[] args) {
	//int[] input = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
	int[] input = {-1,0,1,2,-1,-4};
	System.out.println(threeSum(input));
	
	int[] input2 = {0,1,2};
	int target=0;
	
	//System.out.println(threeSumClosest(input2,target));
}	
	

public static List<List<Integer>> threeSum(int[] nums) {
	List<List<Integer>> result = new ArrayList<List<Integer>>();
	Arrays.sort(nums);
	
	
	for(int i=0;i<nums.length;i++) {
		
	    int j=i+1;
	    int sum=0;
	    int k= nums.length-1;
	    if (i > 0 && nums[i] == nums[i - 1]) {          
            continue;
        }

		while(j<k) {
			List<Integer> sumList = new ArrayList<Integer>();
			sum = nums[i]+nums[j]+nums[k];
			
			if(sum==0) {
				
				sumList.add(nums[i]);
				sumList.add(nums[j]);
				sumList.add(nums[k]);
				result.add(sumList);
				j++;
				k--;
			}
			
			if(sum<0)
				j++;
			if(sum>0)
				k--;
			
				
		}
		
	}
	
	
	
	
	
	return result;
    
    
}




public static int threeSumClosest(int[] nums, int target) {
	
	Arrays.sort(nums);
	int min=Integer.MAX_VALUE;
	int min_sum = 0;
	
	for(int i=0;i<nums.length;i++) {
		
	    int j=i+1;
	    int sum=0;
	    int k= nums.length-1;
	    
	    

		while(j<k) {
		
			sum = nums[i]+nums[j]+nums[k];
			
			int diff = Math.abs(target-sum);
			
			if(diff==0)
				return target;
			
			if(diff < min) {
				min=diff;
				min_sum=sum;
			}
			
		
			if(sum < target)
				j++;
			else
				k--;
			
				
		}
		
	}
	
	
	
	
	
	return min_sum;
    
    
}

}
