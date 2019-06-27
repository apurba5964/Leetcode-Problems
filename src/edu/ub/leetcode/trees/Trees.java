package edu.ub.leetcode.trees;

public class Trees {
	
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	
	
	public boolean isValidBST(TreeNode root) {
        
	     
        return checkBST(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean checkBST(TreeNode root,long low,long high) {
        if(root==null)
            return true;
        
        if(low>=root.val || high<=root.val)
            return false;
        else
            return (checkBST(root.left,low,root.val) && checkBST(root.right,root.val,high)); 
        
     
        
    }

}
