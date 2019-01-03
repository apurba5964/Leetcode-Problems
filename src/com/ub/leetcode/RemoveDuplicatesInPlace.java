/*
https://leetcode.com/problems/remove-duplicates-from-sorted-array/
https://leetcode.com/problems/remove-element/
https://leetcode.com/problems/implement-strstr/
*/
package com.ub.leetcode;

public class RemoveDuplicatesInPlace {

	public static void main(String[] args) {
		
		int[] input = {0,1,2,2,3,0,4,2};
		System.out.println(removeElement(input, 2));
		
		System.out.println(indexOf("hello", "ll"));
		System.out.println(indexOf("a", "a"));
		System.out.println(indexOf("aaaaa", "bba"));
		System.out.println(indexOf("mississippi", "issi"));
		
		
				
	}
	
	
public static int removeDuplicates(int[] nums) {
       
	if(nums.length==0)
		return 0;
	
	int i=0;
	for(int j=1;j<nums.length;j++) {
	
		if(nums[i]!=nums[j]) {
			i++;
			nums[i]=nums[j];
		}
		
	}
       return i+1;
    }


public static int removeElement(int[] nums, int val) {
	if(nums.length==0)
		return 0;
	
	int i=0;
	for(int j=0;j<nums.length;j++) {
		
		if(nums[j]!=val) {
			 {
				//i++;	
			nums[i]=nums[j];
			i++;
			}
			
		}
		
	}
	
	
	return i;
    
}

public static int indexOf(String haystack, String needle) {
	boolean flag =false;
	
	if(needle.isEmpty())
		return 0;
	
	int l1 = haystack.length();
	int l2 = needle.length();
	int n=0;
	
	while(n<l1) {
		
		//System.out.println(haystack.substring(n, n+l2));
		//System.out.println(n+l2);
		if(n+l2 <= l1) {
			
		if(haystack.substring(n, n+l2).equalsIgnoreCase(needle)) {
			flag = true;
			return n;
		}
		}
		n=n+1;
		
	}
	
	if(!flag)
		return -1;
	
	
	return 0;
    
}
	
}
