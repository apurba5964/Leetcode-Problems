package edu.ub.leetcode.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

}
