package edu.ub.leetcode.DP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

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
    
    
public int coinChange(int[] coins, int amount) {
	TreeMap<Integer,Integer> map = new TreeMap<>();
	
	
	
        if(coins.length==0)
            return -1;
        
        if(amount<1)
            return amount;
        
        int[] memo = new int[amount+1];
        return getChange(coins,amount,memo);
    }
    
    
    public int getChange(int[] coins,int amt,int[] memo){
        if(amt<0)
            return -1;
        if(amt==0)
            return 0;
        
        if(memo[amt]!=0)
            return memo[amt];
        
        int min = Integer.MAX_VALUE;
        for(int coin : coins){
            int rem = amt-coin;
         
            int res = getChange(coins,rem,memo);
            
            if(res>=0 && res<min)
                min = 1 + res;
        }
        
        if(min==Integer.MAX_VALUE)
            memo[amt]= -1;
        else
            memo[amt]=min;
        
        return memo[amt];
    }
    
    //https://leetcode.com/problems/minimum-cost-for-tickets/
    TreeMap<Integer,Integer> map = new TreeMap<>();
    public int mincostTickets(int[] days, int[] costs) {
        if(days.length==0 || costs.length==0)
            return 0;
        
        int[] memo = new int[366];
        
        
        for(int day : days)
            map.put(day,day);
        
        return getCost(costs,memo,days[0]);
        
        
    }
    
    
    int getCost(int[] costs,int[] memo,int currDay){
        
        
       // System.out.println(currDay);
        if(currDay==-1)
            return 0;
        
        if(memo[currDay]!=0)
            return memo[currDay];
        
       // int min = Integer.MAX_VALUE;
       
        
            
            
            int d1,d2,d3;
            if(map.higherKey(currDay)!=null)
                d1=map.higherKey(currDay);
            else
                d1 =-1;
            int curr2 = currDay+6;
            
            if(map.higherKey(curr2)!=null)
                d2=map.higherKey(curr2);
            else
                d2 =-1;
            
            int curr3 = currDay+29;
            
            if(map.higherKey(curr3)!=null)
                d3=map.higherKey(curr3);
            else
                d3 =-1;
            
            
            int cost1 = costs[0] + getCost(costs,memo,d1);
            int cost2 = costs[1] + getCost(costs,memo,d2);
            int cost3 = costs[2] + getCost(costs,memo,d3);
            
            int min=Math.min(Math.min(cost1,cost2),cost3);
            
            memo[currDay]=min;
        //System.out.println(cost);
        return min;
    }
  //https://leetcode.com/problems/longest-increasing-subsequence/  
    public int lengthOfLIS(int[] nums) {
        
        int n=nums.length;
        if(n==0)
            return 0;
        
        int[] res = new int[nums.length];
        res[0]=1;
        
        for(int i=0;i<n;i++){
            
                int temp =0;
                for(int j=i-1;j>=0;j--){
                    if(nums[j]<nums[i] ){
                       // min=nums[i]-nums[j];
                        if(res[j]>temp)
                            temp=res[j];
                        //break;
                    }
                }
                res[i]=temp+1;
            //System.out.println(nums[i]+" "+res[i]);
                
        }
        Arrays.sort(res);
        
        return res[n-1];
    }
    
    //https://leetcode.com/problems/maximum-length-of-repeated-subarray/
    //LCS
    public int findLength(int[] a, int[] b) {
        if(a.length==0)
            return b.length;
        if(b.length==0)
            return a.length;
        
        int min = Math.min(a.length,b.length);
        int[][] memo = new int[b.length][a.length];
        
            
        
       
        int max=0;
        
         
            for(int i=0;i<b.length;i=i+1){
            for(int j=0;j<a.length;j=j+1){
                
                if(b[i]==a[j] ){
                    memo[i][j]=1;
                    if(i-1>=0 && j-1>=0){
                    memo[i][j]=memo[i-1][j-1]+1;
                    }
                    max= Math.max(memo[i][j],max);   
                }    
            }
        }
           
        
        
        return max;
    }
    
//https://leetcode.com/problems/delete-operation-for-two-strings/
//LCS(Subsequence)    
public int minDistance(String a, String b) {
        
        if(a.length()==0)
            return b.length();
        if(b.length()==0)
            return a.length();
        
        
        int[][] memo = new int[b.length()][a.length()];
        
            
        
       
        int max=0;
        HashMap<int[],Integer> map = new HashMap<int[],Integer>();
        
        
            for(int i=0;i<b.length();i=i+1){
            for(int j=0;j<a.length();j=j+1){
                
                if(b.charAt(i)==a.charAt(j) ){
                    memo[i][j]=1;
                    if(i-1>=0 && j-1>=0){
                     int temp=0;
                    for(int l=0;l<=i-1;l++){    
                    for(int k=0;k<=j-1;k++){
                        if(memo[l][k]>temp)
                            temp=memo[l][k];
                    }    
                    }
                    memo[i][j]=temp+1;
                    }
                    max= Math.max(memo[i][j],max);   
                }    
            }
        }
        //System.out.println(max);   
        int res = (a.length()-max)+(b.length()-max);
        
        return res;
    }

//https://leetcode.com/problems/edit-distance/submissions/

public int minDistance1(String a, String b) {
    
    if(a.length()==0 || b.length()==0)
        return Math.max(a.length(),b.length());
    
    if(a.equals(b))
        return 0;
    
    
    int[][] memo = new int[b.length()+1][a.length()+1];
    for(int i=0;i<memo[0].length;i++)
        memo[0][i]=i;
    
    for(int i=0;i<memo.length;i++)
        memo[i][0]=i;
    
    for(int i=1;i<=b.length();i++){
        for(int j=1;j<=a.length();j++){
            if(a.charAt(j-1)!=b.charAt(i-1)){
                memo[i][j]=Math.min(Math.min(memo[i-1][j-1],
                                             memo[i][j-1]),memo[i-1][j])+1;
                
            }else
                memo[i][j]=memo[i-1][j-1];
            
        }
    }
    
    
    
    return memo[b.length()][a.length()];
    
}
}
