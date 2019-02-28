/*
https://leetcode.com/problems/combination-sum-ii/
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
*/
package com.ub.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	
	public static void main(String[] args) {
		
	}
	
	public List<List<Integer>> combinationSum1(int[] candidates, int target) {
		   
		   List<List<Integer>> result = new ArrayList<List<Integer>>();
		   Arrays.sort(candidates);
		   
		   backTrack1(result,new ArrayList<>(),candidates,target,0);
		   
			
		
		   
		   
		return result;
	       
	   }

	private void backTrack1(List<List<Integer>> result, ArrayList<Integer> arrayList, 
			int[] candidates, int target, int start) {
		if(target<0)
			return;
		else if(target==0)
			result.add(new ArrayList<>(arrayList));
		
		else {
			for(int i = start;i<candidates.length;i++) {
				if(i>start && candidates[i]==candidates[i-1])
                    continue;
				arrayList.add(candidates[i]);
				backTrack1(result, arrayList, candidates, target-candidates[i], i+1);
				arrayList.remove(arrayList.size()-1);
				
			}
		}
		
	}
	
	
	public int[] searchRange(int[] nums, int target) {
        
		  
		   int[] result = {-1,-1};
		   int h = nums.length;
		   int lindex = mergeSort(nums,target,0,h,true);
		   
	        if (lindex == nums.length || nums[lindex] != target) {
	            return result;
	        }
	        result[0] = lindex;
	        result[1] =  mergeSort(nums,target,0,h,false)-1;
	        
	        return result;
	    
	    }
	    
	    private int mergeSort(int[] nums, int target, int low, int high,boolean check) {
		
		
		
		while(high>low) {   
		int mid = (low+high)/2;
		if(nums[mid] > target || (check && target == nums[mid]))
			high  = mid;
	    else
	        low = mid + 1;
		
		}
		return low;
	    
	    }

}
