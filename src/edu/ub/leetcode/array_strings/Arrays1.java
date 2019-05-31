

//https://www.geeksforgeeks.org/must-do-coding-questions-for-companies-like-amazon-microsoft-adobe/?ref=feed


package edu.ub.leetcode.array_strings;

import java.util.ArrayList;
import java.util.Arrays;

public class Arrays1 {

	public static void main(String[] args) {
		int[] input = {5,3,2,1,4};
		System.out.println(tripletSum(input));
		
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
	
	
	
}
