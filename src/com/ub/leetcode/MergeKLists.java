/*
https://leetcode.com/problems/merge-k-sorted-lists/
*/
package com.ub.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MergeKLists {

	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	
	public static void main(String[] args) {
		

	}
	
public ListNode mergeKLists(ListNode[] lists) {
	
	if(lists==null || lists.length==0)
		return null;
	
	
	return divideLists(lists,0,lists.length-1);
        
    }

private ListNode divideLists(ListNode[] lists, int start, int end) {
	if(start==end)
		return lists[start];
	
	
	if(start < end) {
		
		int mid = (start + end)/2;
		ListNode left = divideLists(lists, start, mid);
		ListNode right = divideLists(lists, mid+1, end);
		
		return mergeLists(left,right);
		
	}
	return null;
	
	
	
	
	
	
}

private ListNode mergeLists(ListNode left, ListNode right) {
	
	ListNode head = new ListNode(0);
	ListNode temp = head;
	
	ListNode temp1 = left;
	ListNode temp2 = right;
	
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
