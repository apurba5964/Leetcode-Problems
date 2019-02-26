/*
https://leetcode.com/problems/combination-sum-ii/

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

}
