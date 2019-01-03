/*
 https://leetcode.com/problems/divide-two-integers/

*/

package com.ub.leetcode;

public class DivideTwoIntegers {

	public static void main(String[] args) {
		System.out.println(divide(2147483647, 2));
		
		
	}

	public static int divide(int dividend, int divisor) {
		boolean isNegative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0) ? true : false;
		
		
		
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		


		
	      long result =0;
	      while(dividend>=divisor) {
	    	  long temp =divisor,count =1;
	    	  
	    	  while(temp<=dividend) {
	    		  temp<<=1;
	    		  count<<=1;
	    	  }
	    	  
	    	  result += count >> 1;
	          dividend -= temp >> 1;  
	    	  
	      }
			

			return isNegative ? (int) ~result + 1 : result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) result;

		

	}

	

}
