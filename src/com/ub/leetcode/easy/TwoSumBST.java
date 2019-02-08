/*
https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

*/
package com.ub.leetcode.easy;

import java.util.ArrayList;

public class TwoSumBST {
	
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }

	public static void main(String[] args) {
		
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
    
   
}
