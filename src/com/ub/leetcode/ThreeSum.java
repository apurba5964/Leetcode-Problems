/*
https://leetcode.com/problems/3sum/
*/
package com.ub.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

public static void main(String[] args) {
	int[] input = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
	System.out.println(threeSum(input));
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
				while (j<k && nums[j] == nums[j+1]) j++;
                while (j<k && nums[k] == nums[k-1]) k--;
				sumList.add(nums[i]);
				sumList.add(nums[j]);
				sumList.add(nums[k]);
				result.add(sumList);
			}
			
			if(sum<0)
				j++;
			else
				k--;
			
				
		}
		
	}
	
	
	
	
	
	return result;
    
    
}


}
