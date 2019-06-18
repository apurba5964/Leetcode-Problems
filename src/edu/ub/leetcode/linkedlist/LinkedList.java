//https://leetcode.com/problems/rotate-list/

package edu.ub.leetcode.linkedlist;



public class LinkedList {
	
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

}
	
	
	public static void main(String[] args) {
		
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
	
	
	
}
