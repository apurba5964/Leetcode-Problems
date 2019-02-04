/*
https://leetcode.com/problems/pascals-triangle/
https://leetcode.com/problems/pascals-triangle-ii/submissions/
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
*/
package com.ub.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {

	public static void main(String[] args) {
		List<List<Integer>> x =generatePascalsTriangle(5);
		for (List<Integer> list : x) {
			for (int result : list) {
				System.out.print(result);
			}
			System.out.println(" ");
		}
		
		
		for(int y : getPascalRow(3)) {
			System.out.print(y);
		}
		
		int[] prices = {7,1,5,3,6,4};
		System.out.println(" ");
		System.out.println(maxProfit(prices));
		System.out.println(maxProfit2(prices));
	}
	
	    public static List<List<Integer>> generatePascalsTriangle(int numRows) {
			
	    	List<List<Integer>> result = new ArrayList<>();
	    	
	    	if(numRows==0)
	    		return result;
	    	
	    	result.add(Arrays.asList(1));
	    	

	    	if(numRows==1)
	    		return result;
	    	
	    	result.add(Arrays.asList(1,1));
	    	
	    	
	    	
	    	
	    	int n = 2;
	    	while(n < numRows) {
	    		List<Integer> pascal = new ArrayList<>();
	    		pascal.add(1);
	    		for(int k = 1;k<n;k++) {
	    			pascal.add(result.get(n-1).get(k)+result.get(n-1).get(k-1));
	    		}
	    		pascal.add(1);
	    		result.add(pascal);
	    		n++;
	    		
	    	}
	    	
	    	
	    	
	    	
	    	
	    	return result;
	        
	    }
	    
	    
	    public static List<Integer> getPascalRow(int rowIndex) {
			
	    	List<List<Integer>> result = new ArrayList<>();
	    	
	    	if(rowIndex==0)
	    		return result.get(rowIndex);
	    	
	    	result.add(Arrays.asList(1));
	    	

	    	if(rowIndex==1)
	    		return result.get(rowIndex);
	    	
	    	result.add(Arrays.asList(1,1));
	    	
	    	
	    	
	    	
	    	int n = 2;
	    	while(n <= rowIndex) {
	    		List<Integer> pascal = new ArrayList<>();
	    		pascal.add(1);
	    		for(int k = 1;k<n;k++) {
	    			pascal.add(result.get(n-1).get(k)+result.get(n-1).get(k-1));
	    		}
	    		pascal.add(1);
	    		result.add(pascal);
	    		n++;
	    		
	    	}
	    	
	    	
	    	
	    	
	    	
	    	return result.get(rowIndex);
	        
	    }
	    
	    
	    public static int maxProfit(int[] prices) {
	    	
	    	int minPrice = Integer.MAX_VALUE,max=0;
	    	
	    	for (int price : prices) {
				minPrice=Math.min(minPrice, price);
				max= Math.max(max, price-minPrice);
	    		
	    		
			}
	    	
	    	
	    	
			return max;
	    	
	    	
	    	
	    }
	    
       public static int maxProfit2(int[] prices) {
	    	
	    	int max=0;
	    	
	    	
	    	
	    	for(int i=1;i<prices.length;i++) {
	    		
	    		if(prices[i]>prices[i-1]) {
	    			max=max+(prices[i]-prices[i-1]);
	    			
	    		}
	    	}
	    	
	    	
	    	
			return max;
	    	
	    	
	    	
	    }
	    
}
