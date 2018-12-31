/*
https://leetcode.com/problems/merge-two-sorted-lists/

*/
package com.ub.leetcode;

public class MergeTwoLists {

	
	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	 
	
	
	public static void main(String[] args) {
		

	}
	
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	
	ListNode head = new ListNode(0);
	ListNode temp = head;
	
	ListNode temp1 = l1;
	ListNode temp2 = l2;
	
	while(temp1 !=null && temp2 != null) {
		
		if(temp1.val < temp2.val) {
			temp.next=temp1;
			temp1=temp1.next;
		}else {
			temp.next=temp2;
			temp2=temp2.next;
			
		}
		
		temp=temp.next;
	}
	
	
	if(temp1!=null) {
		temp.next=temp1;
		
	}
	
	if(temp2!=null) {
		temp.next=temp2;
	}
			
	
	
	return head.next;
        
    }

}
