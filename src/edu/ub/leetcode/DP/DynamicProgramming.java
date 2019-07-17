package edu.ub.leetcode.DP;

import java.util.List;

public class DynamicProgramming {
	
//https://leetcode.com/problems/min-cost-climbing-stairs/	
public int minCostClimbingStairs(int[] cost) {
        
        int[] res = new int[cost.length];
        int n = res.length-1;
        res[n]=cost[n];
        res[n-1]=cost[n-1];
        n=n-2;
        while(n>=0){
            res[n]=cost[n]+Math.min(res[n+1],res[n+2]);
            n--;
        }
        
        
        
        return Math.min(res[0],res[1]);
        
    }

//https://leetcode.com/problems/house-robber-ii/
public int rob(int[] nums) {
    
    if(nums.length==0)
        return 0;
    
    if(nums.length==1)
        return nums[0];
        
    if(nums.length==2)
        return Math.max(nums[0],nums[1]);    
    
    int n = nums.length;    
    int check1 =  robIt(nums,0,n-2);
    int check2 =  robIt(nums,1,n-1);   
    
    return Math.max(check1,check2);
        
    }
    
    public int robIt(int[] nums,int start,int end) {
        
    
    
    int n = 2;
    int[] res = new int[end-start+1];
    res[0] = nums[start];
    res[1] = nums[start+1];
    
    int i=start+2;
    while(n<res.length && i<=end){
       if(n-3>=0) 
          res[n]=nums[i]+Math.max(res[n-2],res[n-3]);
       else
          res[n]=nums[i]+res[n-2];
        
       n++; 
       i++; 
    }
    
   
    
    return Math.max(res[n-1],res[n-2]);
        
    }
    
    
    //https://leetcode.com/problems/triangle/
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int[] res = new int[triangle.size()+1];
        
        
        for(int i=triangle.size()-1;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                res[j]=Math.min(res[j],res[j+1])+triangle.get(i).get(j);
            }
        }
        
        return res[0];
    }

}
