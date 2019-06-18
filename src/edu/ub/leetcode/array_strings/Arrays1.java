

//https://www.geeksforgeeks.org/must-do-coding-questions-for-companies-like-amazon-microsoft-adobe/?ref=feed
//https://leetcode.com/problems/find-peak-element/

package edu.ub.leetcode.array_strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Arrays1 {

	public static void main(String[] args) {
		int[] input = {-5,3,2,1,-4};
		//System.out.println(tripletSum(input));
		System.out.println(kdaneAlgo(input));
		
	}
	
	
	public static int tripletSum(int[] n) {
		
		Arrays.sort(n);
		int count=0;
		
		for(int i = n.length-1;i>=0;i--) {
			int j=0;
			int k = i-1;
			
			while(j<k) {
				if(n[j]+n[k]==n[i]) {
					count++;
					break;
				}
				else if(n[j]+n[k]<n[i])
					j++;
				else
					k--;
			}
			
			
		}
		
		
		return count;
	}
	
	public static int kdaneAlgo(int[] array) {
		int tmax =0;
		int max=0;
		
		for(int i=0;i<array.length;i++) {
			max = max+ array[i];
			if(max<0)
				max=0;
			if(tmax<max)
				tmax = max;
			
		}
		
		return tmax;
	}
	
	public int findPeakElement(int[] nums) {
        int l =0,r= nums.length-1;
        while(l<r){
            int mid = l+((r-l)/2);
            if(nums[mid]>nums[mid+1])
                r=mid;
            else
                l=mid+1;
                
        }
        
        return l;
    }
	
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
		List<Integer> arr1 = new ArrayList<Integer>();
		for (int i : arr)
		{
			arr1.add(i);
		}
        
        int l = 0;
        int h = arr1.size()-k;
        while(l<h) {
        	int mid = l + (h-l)/2;
        	if(x - arr1.get(mid) > arr1.get(mid+k)-x) {
        		l= mid+1;
        	}else
        		h=mid;
        	
        }
        
        
        return arr1.subList(l, l+k);
    }
	
	
	
	
}
