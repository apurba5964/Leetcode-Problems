package com.ub.leetcode.easy;

public class BalancedBinaryTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {

	}

	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;

		int lh = maxDepth(root.left);
		int rh = maxDepth(root.right);

		if (Math.abs(lh - rh) <= 1 && isBalanced(root.left) && isBalanced(root.right))
			return true;
		else
			return false;

	}

	public int maxDepth(TreeNode root) {

		if (root == null)
			return 0;

		return Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right));

	}

	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;

		if (root.right == null)
			return minDepth(root.left) + 1;
		if (root.left == null)
			return minDepth(root.right) + 1;

		return Math.min(1 + minDepth(root.left), 1 + minDepth(root.right));
	}

	public boolean hasPathSum(TreeNode root, int sum) {
		return false;

	}

}
