/*
https://leetcode.com/problems/search-in-rotated-sorted-array/
*/
package com.ub.leetcode;

public class SearchRotatedSortedArray {

	public static void main(String[] args) {
		int[] input = {1,3,5};
		System.out.println(search(input, 0, input.length-1, 1));
	}

	
public static int search(int[] nums,int l,int h, int target) {
	
	int pivot = findPivot(nums,l,h);
	
	
	if(pivot == -1)
		return binarySearch(nums, l, h, target);
	
	if(nums[pivot]==target)
		return pivot;
	
	
	if(nums[0]<=target)
		return binarySearch(nums, 0, pivot-1, target);
	
	return binarySearch(nums, pivot+1, h, target);
	
		
	
	
	
}

private static int binarySearch(int[] nums,int l,int h,int target) {
	
	
	
	if(h<l)
		return -1;
	int mid = (l+h)/2;
	
	if(nums[mid]==target)
		return mid;
	
	if(nums[mid]>target)
		return binarySearch(nums, l, mid-1, target);
	else
		return binarySearch(nums, mid+1, h, target);
	
	
}

private static int findPivot(int[] nums,int l,int h) {
	
	if(h<l)
		return -1;
	if(h==l)
		return l;
	
	int mid = (l+h)/2;
	
	if(l==mid && nums[l]<=nums[h])
		return -1;
	
	if(l==mid && nums[l]>=nums[h])
		return l;
		
	
	if(nums[mid]>nums[mid+1] && mid < h)
		return mid;
	if(nums[mid]<nums[mid-1] && mid > l )
		return mid-1;
	
	if(nums[l]>=nums[mid])
		return findPivot(nums, l, mid-1);
	
	else
	return findPivot(nums, mid+1,h);
	
	
	
	
}
 
	
}
