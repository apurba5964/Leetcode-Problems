

/*
https://leetcode.com/problems/permutations/

*/
package com.ub.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Backtracking {
	
	
	public static void main(String[] args) {
		
		
	}
	
	
    public List<List<Integer>> subsets(int[] nums) {
    
    	List<List<Integer>> result = new ArrayList<>();
    	
    	Arrays.sort(nums);
    	
    	bactrackSubsets(result,new ArrayList<>(),nums,0);
    	
    	return result;
    }
	
	
	 private void bactrackSubsets(List<List<Integer>> result, ArrayList<Integer> arrayList, int[] nums, int start) {
		result.add(new ArrayList<>(arrayList));
		
		for(int i =start;i<nums.length;i++) {
			arrayList.add(nums[i]);
			bactrackSubsets(result,arrayList,nums,i+1);
			arrayList.remove(arrayList.size()-1);
			
		}
		
		 
		 
		
	}


	public void bactrackPermute(List<List<Integer>> result, ArrayList<Integer> arrayList, int[] nums) {
		
		if(arrayList.size() == nums.length)
		result.add(new ArrayList<>(arrayList));
	else{
	for(int i =0;i<nums.length;i++) {
        if(arrayList.contains(nums[i]))
        	continue;
		arrayList.add(nums[i]);
		bactrackPermute(result,arrayList,nums);
		arrayList.remove(arrayList.size()-1);
	}
    }
        }

}
