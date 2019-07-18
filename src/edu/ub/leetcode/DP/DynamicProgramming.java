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
    
    
    //https://leetcode.com/problems/predict-the-winner/
    public boolean PredictTheWinner(int[] nums) {
     
        if(nums.length==1)
            return true;
        int n = nums.length-1;
        int[][] memo = new int[n+1][n+1];
        int result = getValue(nums,0,n,memo);
        //int right = getValue(nums,0,n-1);
        
        //System.out.println(left+" "+right);
        if(result<0)
            return false;
        else
            return true;
    }
    
    
    public int getValue(int[] arr,int start,int end,int[][] memo){
        if(start==end)
            return arr[start];
        if(memo[start][end]!=0)
            return memo[start][end];
        
        int left = arr[start]-getValue(arr,start+1,end,memo);
        int right = arr[end]-getValue(arr,start,end-1,memo);
        
        memo[start][end]=Math.max(left,right);
        return Math.max(left,right);
        
    }
    
    //https://leetcode.com/problems/counting-bits/
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        if(num==0){
            res[0]=0;
            return res;
        }
            
        
        
      //  int[] res = new int[num+1];
        
        res[0]=0;
        res[1]=1;
        
        
        for(int i=2;i<=num;i=i*2){
           int start = i;
           int end = i*2; 
            if(end>=num){
            for(int j=start;j<=num;j++)
               res[j]=res[j-start]+1;
            }else{
                 for(int j=start;j<=end;j++)
               res[j]=res[j-start]+1;
            }
            
        }
     
        return res;
    }
    

}
