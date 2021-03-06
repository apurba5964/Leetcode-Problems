package edu.ub.leetcode.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.TreeMap;

import edu.ub.leetcode.linkedlist.LinkedList.ListNode;

public class Trees {
	
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	
	
	public boolean isValidBST(TreeNode root) {
        
	     
        return checkBST(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean checkBST(TreeNode root,long low,long high) {
        if(root==null)
            return true;
        
        if(low>=root.val || high<=root.val)
            return false;
        else
            return (checkBST(root.left,low,root.val) && checkBST(root.right,root.val,high)); 
        
     
        
    }
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result= new ArrayList<>();
   		
   		int height = maxDepth(root);
   		boolean check = false;
   		for(int i=0;i<height;i++) {
   			ArrayList<Integer> nodes = new ArrayList<>();
   			zigzagLevelOrder(root, i,nodes,0,check);
   			result.add(nodes);
               check = !check;
   		}

   		return result;
           
       }
       
       public void zigzagLevelOrder(TreeNode root, int level, ArrayList<Integer> nodes,int count,boolean check) {
   		
   		if(root==null)
   			return;
   		if(level==count) {
   			nodes.add(root.val);
   			
   		}
   			
   		
   		if(level>count && check==false) {
   			zigzagLevelOrder(root.left, level,nodes,count+1,check);
   			zigzagLevelOrder(root.right, level,nodes,count+1,check);
   			
   		}
           
           if(level>count && check==true) {
   			zigzagLevelOrder(root.right, level,nodes,count+1,check);
   			zigzagLevelOrder(root.left, level,nodes,count+1,check);
   			
   		}
   		
   		
   		
   		
   	}
       
       
       public int maxDepth(TreeNode root) {

   		if (root == null)
   			return 0;

   		return Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right));

   	}
       
       
       //build tree from pre and in
       HashMap<Integer,Integer> map = new HashMap<>();
       public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        for(int i = 0 ;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
           
           
           return build(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
       }
       
       
       public TreeNode build(int[] pre, int[] in,int pstart,int pend,int istart,int iend){
           if(pstart>pend || istart>iend)
               return null;
           
           TreeNode root = new TreeNode(pre[pstart]);
           int newIstart = map.get(pre[pstart]);
           int newPEnd = newIstart - istart;
           
           root.left = build(pre,in,pstart+1,pstart+newPEnd,istart,newIstart);
           root.right = build(pre,in,pstart+newPEnd+1,pend,newIstart+1,iend);
           
           return root;
       }
       
       //return paths from root to leaf which sum to given number
       public List<List<Integer>> pathSum(TreeNode root, int sum) {
           List<List<Integer>> result = new ArrayList<>();
           List<Integer> current = new ArrayList<>();
           hasPathSum(root, sum,result,current);
           return result;
       }
       
       public void hasPathSum(TreeNode root, int sum,List<List<Integer>> result,
                                List<Integer> current) {
          
   		
   		if(root==null)
               return;
   	
   	sum = sum - root.val;
       current.add(root.val);    
   	
   	if(root.left==null && root.right == null && sum==0){
           result.add(new ArrayList(current));
           current.remove(current.size()-1);
           return;
       }
   		
   	
   	if(root.left==null && root.right == null && sum!=0){
           current.remove(current.size()-1);
           return;
       }
   		
   	
   	
   	 hasPathSum(root.left, sum,result,current);
        
        hasPathSum(root.right, sum,result,current);
           
        current.remove(current.size()-1);   
   	
   	

   	
       }
       
       //Lowest common ancestor
       public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
           
           int anc = getAnc(root,p,q);
           return new TreeNode(anc);
       }
       
       public int getAnc(TreeNode root, TreeNode p, TreeNode q) {
           if (root == null)
               return -1;
           
           if(root.val==p.val || root.val==q.val)
               return root.val;
           
           
           int x = getAnc(root.left,p,q);
           int y = getAnc(root.right,p,q);
           
           if ((x==p.val && y==q.val) || (y==p.val && x==q.val))
               return root.val;
           if(x==-1 && y!=-1)
               return y;
           if(x!=-1 && y==-1)
               return x;
        
           return -1;
       }
       
       
       //https://leetcode.com/problems/delete-nodes-and-return-forest/
       public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    	     List<TreeNode> res = new ArrayList<>();
    	     HashSet<Integer> delSet = new HashSet<>();   
    	     for(int val:to_delete){
    	         delSet.add(val);
    	     }
    	        delete(root,res,delSet);
    	        if(!delSet.contains(root.val))
    	            res.add(root);
    	        
    	        return res;
    	    }
    	    
    	    public TreeNode delete(TreeNode root,List<TreeNode> res,HashSet<Integer> delSet){
    	        
    	       if(root==null)
    	           return null;
    	        root.left = delete(root.left,res,delSet);
    	        root.right = delete(root.right,res,delSet);
    	        
    	        if(delSet.contains(root.val)){
    	            if(root.left!=null)
    	                res.add(root.left);
    	            if(root.right!=null)
    	                res.add(root.right);
    	            return null;
    	        }
    	        
    	        
    	        return root;
    	    }
    	    
    	    //https://leetcode.com/problems/binary-tree-maximum-path-sum/
    	    int max = Integer.MIN_VALUE;
    	    public int maxPathSum(TreeNode root) {
    	 
    	        if(root==null)
    	            return 0;
    	        
    	       
    	       getSum(root); 
    	       return max;
    	    }
    	    
    	    public int getSum(TreeNode root){
    	        if(root==null)
    	            return 0;
    	        
    	        int left = Math.max(getSum(root.left),0);
    	        int right = Math.max(getSum(root.right),0);
    	        
    	        max = Math.max(max,left+right+root.val);
    	        return root.val+Math.max(left,right);
    	    } 	 
    	    
    	    //https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
    	    public TreeNode sortedListToBST(ListNode head) {
    	        if(head==null)
    	            return null;
    	        
    	       
    	        ListNode mid = getMiddleElement(head);
    	        TreeNode root = new TreeNode(mid.val);
    	        if(head==mid)
    	            return root;
    	        root.left = sortedListToBST(head);
    	      
    	        root.right = sortedListToBST(mid.next);
    	    
    	        return root;
    	    }
    	    
    	    public ListNode getMiddleElement(ListNode head){
    	        
    	        ListNode fast = head;
    	        ListNode slow = head;
    	        ListNode prev = null;
    	        
    	        while(fast!=null && fast.next!=null){
    	            prev=slow;
    	            slow=slow.next;
    	            fast=fast.next.next;
    	           
    	            
    	        }
    	        if (prev != null) {
    	                prev.next = null;
    	            }
    	        return slow;
    	    }
    	    
    	    
    	    
   //https://leetcode.com/problems/unique-binary-search-trees-ii/ 	    
    	    
    	    public List<TreeNode> generateTrees(int n) {
    	        if(n==0)
    	            return new ArrayList<TreeNode>();
    	            
    	    
    	        return genTree(1,n);
    	        
    	    }
    	    
    	    public List<TreeNode> genTree(int start,int end){
    	        System.out.println(start+" "+end);
    	        List<TreeNode> res = new ArrayList<>();
    	        
    	        if(start>end){
    	             res.add(null);
    	             return res;
    	        }
    	        if(start==end){
    	            res.add(new TreeNode(start));
    	            return res;
    	        }
    	           
    	        for(int i=start;i<=end;i++){
    	            List<TreeNode> leftTree = genTree(start,i-1);
    	            List<TreeNode> rightTree = genTree(i+1,end);
    	            
    	            for(TreeNode left : leftTree){
    	                for(TreeNode right : rightTree){
    	                    TreeNode root = new TreeNode(i);
    	                    root.left=left;
    	                    root.right=right;
    	                    res.add(root);
    	                }
    	            }
    	            
    	           
    	        }
    	        
    	        
    	        return res;
    	    }
    	    
    	    
    	    
//https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/    	    
    	    public int mctFromLeafValues(int[] arr) {
    	        
    	        ArrayList<Integer> res = new ArrayList<>();
    	        
    	        int sum=0;
    	         
    	        for(int i=0;i<arr.length;i++)
    	            res.add(arr[i]);
    	              
    	        
    	        
    	        
    	        while(res.size()>1){
    	            
    	            int min=0,check = Integer.MAX_VALUE;
    	            for(int i=0;i<res.size();i++){
    	            if(res.get(i)<check){
    	                
    	                check=res.get(i);
    	                min=i;
    	            }
    	                
    	        }
    	            
    	            int left = min-1;
    	            int right = min+1;
    	            if(left<0)
    	                sum+=res.get(min)*res.get(right);
    	            else if(right==res.size())
    	                sum+=res.get(min)*res.get(left);
    	            else{
    	                if(res.get(left)<res.get(right)){
    	                    sum+=res.get(min)*res.get(left);
    	                }else
    	                    sum+=res.get(min)*res.get(right);
    	            }
    	            
    	            res.remove(min);
    	        }
    	     
    	        return sum;
    	    }
  //https://leetcode.com/problems/binary-tree-coloring-game/
    	    
    	    
    	    int lcount=0;
    	    int rcount=0;
    	    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
    	        if(root==null)
    	            return false;
    	        
    	        getCount(root,x);
    	        //System.out.println(lcount+" "+rcount);
    	        if(lcount+rcount<n/2)
    	            return true;
    	        if(lcount>n/2 || rcount>n/2)
    	            return true;
    	        
    	        return false;
    	    }
    	    
    	    
    	    public int getCount(TreeNode root,int x){
    	        
    	        if(root==null)
    	            return 0;
    	        int left = getCount(root.left,x);
    	        int right = getCount(root.right,x);
    	        
    	        
    	        if(root.val==x){
    	            lcount = left;
    	            rcount = right;
    	        }
    	        //System.out.println(left+" "+right);
    	        return 1 + left + right;
    	    }
}





class SnapshotArray {

    int[] input;
    int snap=0;
    TreeMap<Integer,int[]> map = new TreeMap<>();
    
    
    public SnapshotArray(int length) {
        input = new int[length];
    }
    
    public void set(int index, int val) {
        input[index] = val;
    }
    
    public int snap() {
    	
        snap++;
        map.put(snap-1,input);
        int [] newI= input.clone();
        return snap-1;
    }
    
    public int get(int index, int snap_id) {
        int[] check = map.get(snap_id);
        return check[index];
    }
}



class Trie {

    
    
    class Node {
		 char ch;
        HashMap<Character,Node> map;
		 
        Node(char c) {
			ch = c;
           map = new HashMap<>(); 
		 }
   }
   Node root,curr;
   /** Initialize your data structure here. */
   public Trie() {
       root = new Node('1');
       
   }
   
   /** Inserts a word into the trie. */
   public void insert(String word) {
       curr=root;
       for(int i=0;i<word.length();i++){
           if(curr.map.containsKey(word.charAt(i))){
             curr=curr.map.get(word.charAt(i));
               
           }else{
               Node node = new Node(word.charAt(i));
               curr.map.put(word.charAt(i),node);
               curr=node;
           }
       }
       curr.map.put('0',null);
       
   }
   
   /** Returns if the word is in the trie. */
   public boolean search(String word) {
       curr=root;
       for(int i=0;i<word.length();i++){
           if(curr.map.containsKey(word.charAt(i))){
             curr=curr.map.get(word.charAt(i));
             continue;  
           }else{
               return false;
           }
       }
       if(curr.map.containsKey('0'))
           return true;
       else
           return false;
   }
   
   /** Returns if there is any word in the trie that starts with the given prefix. */
   public boolean startsWith(String word) {
    curr=root;
       for(int i=0;i<word.length();i++){
           if(curr.map.containsKey(word.charAt(i))){
             curr=curr.map.get(word.charAt(i));
             continue;  
           }else{
               return false;
           }
       }
       return true;
        
   }
}

/**
* Your Trie object will be instantiated and called as such:
* Trie obj = new Trie();
* obj.insert(word);
* boolean param_2 = obj.search(word);
* boolean param_3 = obj.startsWith(prefix);
*/