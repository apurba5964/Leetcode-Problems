/*

https://leetcode.com/problems/reverse-nodes-in-k-group/
*/
package com.ub.leetcode;

public class ReverseKGroup {
	
	
	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }

	
    
	public  ListNode reverseKGroup(ListNode head, int k) {
		
		ListNode temp1 =new ListNode(0);
		temp1.next = head;
		
		ListNode pre = temp1;
		ListNode curr = temp1;
		
		while(curr!=null) {
			for(int i=0;i<k;i++) {
				if (curr == null || curr.next == null) return temp1.next;
				curr = curr.next;
			}
			
			ListNode nxt = pre.next;
			pre.next = reverse(nxt, curr.next);
			pre = nxt;
			curr = nxt;
			
		}
		
		
		
		
		
		
		
	
	
	return temp1.next;
        
    }
	
	
	public static ListNode reverse(ListNode node1,ListNode node2) {
		
		if (node1 == node2 || node1.next == node2) 
			return node1;
		
		
		ListNode prev = node1;
		ListNode curr = node1.next;
		
		while(curr!=node2) {
			
			ListNode nxt = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nxt;
		}
		
		
		
		return prev;
        
		    
			
		
		
        
    }
}
