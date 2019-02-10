/*
https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
https://leetcode.com/problems/excel-sheet-column-title/
https://leetcode.com/problems/majority-element/
*/
package com.ub.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;

public class TwoSumBST {
	
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }

	public static void main(String[] args) {
		System.out.println(convertToTitle(26));
	}
	
    public boolean findTarget(TreeNode root, int k) {
    	
    	if(root==null)
    		return false;
    	ArrayList<Integer> list = new ArrayList<>();
    	inOrderTraversal(root,list);
    	
    	
    	
       int i=0;
 	   int j=list.size()-1;
 	   
 	   
 	   while(i<j) {
 		   int sum = list.get(i)+list.get(j);
 		   
 		   
 		   if(sum == k) 
 			   
 			   return true;
 		   
 			   
 		   if(sum>k)
 			   j--;
 		   else
 			   i++;
 	   }
 	   
 	   return false;
        
    }
    	
    	
    	
	

	private void inOrderTraversal(TreeNode root, ArrayList<Integer> list) {
		if (root == null)
            return;
		
		
		inOrderTraversal(root.left, list);
		list.add(root.val);
		inOrderTraversal(root.right, list);
		
		
	}
	
    public static String convertToTitle(int n) {
	
    	String result = "";
    	while(n!=0) {
    		result = (char) ('A'+ (n-1)%26) + result;
    		n = (n-1)/26;
    	}
	
	
	return result;
        
    }
    
    
   public static  int majorityElement(int[] nums) {
	   
       Arrays.sort(nums);
       return nums[nums.length/2];
    }
    
   
}
