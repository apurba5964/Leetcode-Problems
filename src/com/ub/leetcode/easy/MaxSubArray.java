package com.ub.leetcode.easy;

public class MaxSubArray {

	public static void main(String[] args) {
		
		int[] input = {-2,1,-3,4,-1,2,1,-5,4};
		
		int[] input1 = {1,2};
		
		System.out.println(maxSubArray(input));
		System.out.println(maxSubArray(input1));
		
		System.out.println(maxSubArrayDnC(input,0,input.length-1));
		System.out.println(maxSubArrayDnC(input1,0,input1.length-1));
	}
	
	//O(n) Greedy
    public static int maxSubArray(int[] nums) {
    	if(nums.length==1)
    		return nums[0];
    	
    	int maxSum = nums[0];
    	int currSum = nums[0];
    	for(int i=1;i<nums.length;i++) {
    		
    		
    		
    			
    			currSum = Math.max(nums[i], currSum + nums[i]);
    			maxSum = Math.max(maxSum, currSum);
    		
    		
    	}
    	
		return maxSum;
        
    }
    
    //Divide n Conquer O(nlogn)
    public static int maxSubArrayDnC(int[] nums,int l,int h) {
    	if(l==h)
    		return nums[l];
    	
    	int mid = (l+h)/2;
    	
    	
    	
		return Math.max(Math.max(maxSubArrayDnC(nums, l, mid),maxSubArrayDnC(nums, mid+1, h))
				,maxCrossingSum(nums, l, mid, h));
        
    }
    
    private static int maxCrossingSum(int[] nums,int l,int m,int h) {
    	int sum = 0;
    	int leftSum = Integer.MIN_VALUE;
    	for(int i=m;i>=l;i--) {
    		sum += nums[i];
    		
    		if(sum>leftSum)
    			leftSum=sum;
    		
    	}
    	
    	 sum = 0;
    	int rightSum = Integer.MIN_VALUE;
    	for(int i=m+1;i<=h;i++) {
    		sum += nums[i];
    		
    		if(sum>rightSum)
    			rightSum=sum;
    		
    		
    	}
    	return leftSum+rightSum;
    }

}
