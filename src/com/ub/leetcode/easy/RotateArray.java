/*https://leetcode.com/problems/rotate-array/

*/

package com.ub.leetcode.easy;

public class RotateArray {
	
	public static void main(String[] args) {
		
	}
	
    
	
	public static void rotate(int[] nums, int k) {
		if(nums.length==1)
			return;
		
		int n =nums.length;
        
		for(int i=0;i<k;i++) {
			
			int temp = nums[0];
			nums[0]=nums[n-1];
			int j=n-1;
			while(j>1) {
				nums[j]=nums[j-1];
				j--;
			}
			nums[1]=temp;
		}
		
		
    }

}
