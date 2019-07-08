package edu.ub.leetcode.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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

}
