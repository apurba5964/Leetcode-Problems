//https://leetcode.com/problems/rotate-list/
//https://leetcode.com/problems/partition-list/
	
	
package edu.ub.leetcode.linkedlist;



public class LinkedList {
	
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

}
	
	
	
	
	public static ListNode rotateRight(ListNode head, int k) {
        ListNode temp1 = head.next;ListNode prev =null;
        
        while(k>0) {
        	while(temp1.next!=null) {
        		prev=temp1;
        		temp1=temp1.next;
        	}
        	prev.next=null;
        	temp1.next=head.next;
        	head.next=temp1;
        	k--;
        	
        }
		
		
		return head;
    }
	
	 public  ListNode partition(ListNode head, int x) {
	        
		 if(head==null || head.next==null)
			 return head;
		 
		 ListNode temp1_head = new ListNode(0);
		 ListNode temp2_head = new ListNode(0);
		 ListNode temp1 = temp1_head;
		 ListNode temp2 = temp2_head;
		 
		 
		 while(head!=null) {
			 
			 
			 if(head.val<x) {
				 temp1.next=head;
				 temp1 = temp1.next;
				 
			 }else {
				 temp2.next=head;
				 temp2=temp2.next;
				 
			 }
			 head = head .next;
			
			 
			 
		 }
		 temp2.next=null;
		 temp1.next= temp2_head.next;
		 
		 
		 return temp1_head.next;
	    }
	
	
	
}
