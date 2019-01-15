package com.ub.leetcode.easy;

public class SameTree {
	
	public class TreeNode {
		     int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
public boolean isSameTree(TreeNode p, TreeNode q) {
	
	if(p==null && q==null)
		return true;
	
	if(p==null || q==null)
		return false;
	
	
	
	
	if(p.val==q.val) {
		return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
	}
		
	
	return false;
        
    }

public boolean isSymmetric(TreeNode root) {
    
	if(root==null)
		return true;
	
	
	
	if(root.left==null && root.right==null)
		return true;
	
	return isSymmetricTree(root.left, root.right);


    }
    

public boolean isSymmetricTree(TreeNode root1,TreeNode root2) {
    
    if(root1==null && root2==null)
		return true;
	
	
	if(root1==null || root2==null)
		return false;    
	
	
	
	
	
	
	if(root1.val==root2.val) {
		return (isSymmetricTree(root1.left,root2.right) && isSymmetricTree(root1.right,root2.left));
	}
		
	
	return false;
        
    }

}
