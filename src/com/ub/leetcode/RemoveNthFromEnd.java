
/*
https://leetcode.com/problems/remove-nth-node-from-end-of-list/
*/

package com.ub.leetcode;

public class RemoveNthFromEnd {
	
	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	
	

	public static void main(String[] args) {
		
	}
	
public ListNode removeNthFromEnd(ListNode head, int n) {
	
	if(head==null)
		return null;
	
	int len=0;
	ListNode temp=head;
	
	while(temp!=null) {
		len++;
		temp=temp.next;
		
	}
	int fromStart= len-n+1;
	if(fromStart==1)
		return head.next;
	
	temp=head;
	int i=0;
	while(temp!=null) {
		i++;
		if(i==fromStart-1) {
			temp.next=temp.next.next;
			
		}
		temp=temp.next;
	}
	
	
	return head;
        
    }

}
