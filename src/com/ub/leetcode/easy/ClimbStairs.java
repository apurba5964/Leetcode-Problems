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
    
    
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    	int[] nums3=new int[m+n];
    	
    	int i=0,j=0,k=0;
    	while(i<nums3.length && j<m && k<n) {
    		if(nums1[j]<nums2[k]) {
    			nums3[i]=nums1[j];
    			i++;
    			j++;
    		}else {
    			nums3[i]=nums2[k];
    			i++;
    			k++;
    			
    		}
    		
    	}
    	
    	while(k<n) {
    		nums3[i]=nums2[k];
    		i++;
    		k++;
    	}
    	
    	while(j<m) {
    		nums3[i]=nums1[j];
    		i++;
    		j++;
    	}
	 
	 nums1 = nums3;
	 
        
    }
    
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
    	int k =m+n-1;
    	int i=m-1;
    	int j=n-1;
    	
    	while(i>=0 && j>=0 ) {
    		
    		if(nums1[i]>nums2[j]) {
    			nums1[k]=nums1[i];
    			i--;k--;
    			
    		}else {
    			nums1[k]=nums2[j];
    			j--;k--;
    		}
    		
    		
    		
    	}
    	
    	while(j>=0) {
			nums1[k]=nums2[j];
			k--;j--;
		}
    	
    	
    	
    }

}
