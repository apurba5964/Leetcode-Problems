/*
https://leetcode.com/problems/rotate-array/
https://leetcode.com/problems/reverse-bits/
https://leetcode.com/problems/number-of-1-bits/solution/
https://leetcode.com/problems/remove-linked-list-elements/submissions/
*/

package com.ub.leetcode.easy;

import java.util.List;

public class RotateArray {
	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	
	public static void main(String[] args) {
		
		
	}
	
    
	
	public static void rotate(int[] nums, int k) {
		if(nums.length==1)
			return;
		
		int n =nums.length;
        
		for(int i=0;i<k;i++) {
			
			int temp = nums[0];
			nums[0]=nums[n-1];
			int j=n-1;
			while(j>1) {
				nums[j]=nums[j-1];
				j--;
			}
			nums[1]=temp;
		}
		
		
    }
	
	public static int reverseBits(int n) {
		
		String s = Integer.toBinaryString(n);
		StringBuilder sb = new StringBuilder(s);
		String reverse = sb.reverse().toString();
		for(int i = 0; i < 32-s.length(); i++)
			reverse= reverse + "0";
    	
		
		
        return Integer.valueOf(reverse);
    }
	
   public int hammingWeight(int n) {
	   int bits = 0;
	   int mask = 1;
	   for(int i=0;i<32;i++) {
		   if((n & mask)!=0)
			   bits++;
		   mask = mask<<1;
	   }
	   
	return bits;
        
    }

	public ListNode removeElements(ListNode head, int val) {
		ListNode temp = new ListNode(-1);
		temp.next = head;
		ListNode curr = head, prev = temp;
		while (curr != null) {
			if (curr.val == val) {
				prev.next = curr.next;
			} else {
				prev = prev.next;
			}
			curr = curr.next;
		}
		return temp.next;
	}
	
    public int countPrimes(int n) {
    	boolean[] notPrime = new boolean[n];
    	int count =0;
    	for(int i = 2;i<n; i++ ) {
    		if(!notPrime[i]) {
    			count++;
    			for(int j=2;i*j<n;j++) {
    				notPrime[i*j]=true;
    				
    			}
    		}
    			
    		
    	}
    	
    	
		return count;
            
    }

}
