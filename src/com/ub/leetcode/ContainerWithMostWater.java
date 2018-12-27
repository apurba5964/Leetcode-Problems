/*
 * https://leetcode.com/problems/container-with-most-water/submissions/
*/
package com.ub.leetcode;

public class ContainerWithMostWater {
	

public static void main(String[] args) {
	int[] input ={1,8,6,2,5,4,8,3,7}; 
	System.out.println(maxArea(input));
}	
	
public static int maxArea(int[] height) {
	
	int maxArea=0;
	for(int i=0;i<height.length;i++) {
		for(int j=i+1;j<height.length;j++) {
			int area=0;
			area=Math.min(height[i], height[j]) * (j-i);
			if(area>maxArea) {
				maxArea=area;
			}
			
			
		}
	}
	
	
	
	return maxArea;
        
    }

}
