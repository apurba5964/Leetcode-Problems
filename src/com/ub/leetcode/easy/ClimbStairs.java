package com.ub.leetcode.easy;

public class ClimbStairs {
	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }

	public static void main(String[] args) {
		System.out.println(climbStairs(3));
		

	}
	
	
	public static int climbStairs(int n) {
		
		if(n==1)
			return 1;
		
		int[] dp = new int[n+1];
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i=3;i<=n;i++) {
			dp[i] = dp[i-1]+dp[i-2];
			
			
		}
		
		
		return dp[n];
	    }
	
	
    public static ListNode deleteDuplicates(ListNode head) {
    	
    	ListNode temp = head;
    	
    	while(temp!=null && temp.next!=null) {
    		if(temp.val==temp.next.val) {
    			temp.next = temp.next.next;
    		}else
    			temp = temp.next;
    	}
    	
		return head;
        
    }

}
