package com.ub.leetcode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Node;

public class SameTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isSameTree(TreeNode p, TreeNode q) {

		if (p == null && q == null)
			return true;

		if (p == null || q == null)
			return false;

		if (p.val == q.val) {
			return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
		}

		return false;

	}

	public boolean isSymmetric(TreeNode root) {

		if (root == null)
			return true;

		if (root.left == null && root.right == null)
			return true;

		return isSymmetricTree(root.left, root.right);

	}

	public boolean isSymmetricTree(TreeNode root1, TreeNode root2) {

		if (root1 == null && root2 == null)
			return true;

		if (root1 == null || root2 == null)
			return false;

		if (root1.val == root2.val) {
			return (isSymmetricTree(root1.left, root2.right) && isSymmetricTree(root1.right, root2.left));
		}

		return false;

	}

	public int maxDepth(TreeNode root) {

		if (root == null)
			return 0;

		return Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right));

	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		
		List<List<Integer>> result= new ArrayList<>();
		
		int height = maxDepth(root);
		
		for(int i=height;i>0;i--) {
			ArrayList<Integer> nodes = new ArrayList<>();
			levelOrder(root, i,nodes);
			result.add(nodes);
		}

		return result;
	}

	public void levelOrder(TreeNode root, int level, ArrayList<Integer> nodes) {
		
		if(root==null)
			return;
		if(level==1) {
			nodes.add(root.val);
			
		}
			
		
		if(level>1) {
			levelOrder(root.left, level-1,nodes);
			levelOrder(root.right, level-1,nodes);
			
		}
		
		
		
		
	}
	
	
    public TreeNode sortedArrayToBST(int[] nums) {
    	
    	
    	
    	
		return createBST(nums,0,nums.length-1);
     
        
        
    }

	private TreeNode createBST(int[] nums, int low,int high) {
		
		
		if(low>high) 
			return null;
		
		
		int mid =  (low+high)/2;
		TreeNode node = new TreeNode(mid);
		
		node.left = createBST(nums, low, mid-1);
		node.right = createBST(nums, mid+1, high);
		
	
		
		return node;
	}

}
