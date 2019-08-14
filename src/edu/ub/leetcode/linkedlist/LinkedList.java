//https://leetcode.com/problems/rotate-list/
//https://leetcode.com/problems/partition-list/
	
	
package edu.ub.leetcode.linkedlist;

import java.util.HashMap;

public class LinkedList {
	
	public class ListNode {
		public int val;
		public ListNode next;

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




class LRUCache {
    int cap=0,curr_cap=0;
    HashMap<Integer,ListNode> map;
    
     class ListNode {
		 int key;
         int val;
		 ListNode left;
         ListNode right;

		ListNode(int x,int y) {
			key = x;val=y;
		}
    }
    ListNode head,tail;
    public LRUCache(int capacity) {
        cap=capacity;
        map = new HashMap<>();
        head = new ListNode(-1,-1);
        tail = new ListNode(-1,-1);
    }
    
    public int get(int key) {
        if(map.get(key)==null)
            return -1;
        else{
            ListNode node = map.get(key);
            deleteNode(node);
            addNodeToTail(node);
            return node.val;
        }
            
    }
    
    public void put(int key, int value) {
       
        ListNode node = new ListNode(key,value);
        if(curr_cap==0){
            
            head.right=node;
            tail.left=node;
            node.right=tail;
            node.left=head;
            map.put(node.key,node);
            curr_cap++;
            return;
        }
        
        if(curr_cap<cap){
        if(map.get(key)==null){
             addNodeToTail(node);
             
        }else{
            ListNode node1 = map.get(key);
            deleteNode(node1);
            addNodeToTail(node);
        }
        }else{
            if(map.get(key)!=null){
            ListNode node1 = map.get(key);
            deleteNode(node1);
            addNodeToTail(node);
         }else{
            deleteNodeFromHead();
            addNodeToTail(node);
            }
            
        }
     
        // System.out.println(map.size());
    }
    
    public void addNodeToTail(ListNode node){
           ListNode left = tail.left;
           left.right=node;
           node.left=left;
           node.right=tail;
           tail.left=node;
           curr_cap++;
           map.put(node.key,node);
    }
    
    public void deleteNode(ListNode node){
           ListNode left = node.left;
           ListNode right = node.right;
           left.right=right;
           right.left=left;
           
           map.remove(node.key);
           curr_cap--;
          // node = null;
    }
    
    public void deleteNodeFromHead(){
        ListNode node = head.right;
        head.right = node.right;
        node.right.left=head;
        map.remove(node.key);
        curr_cap--;
        node=null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
