/*
https://leetcode.com/problems/length-of-last-word
https://leetcode.com/problems/plus-one/
https://leetcode.com/problems/add-binary/
https://leetcode.com/problems/sqrtx/
*/
package com.ub.leetcode.easy;

public class LengthOfLastWord {

	public static void main(String[] args) {
		
		System.out.println(lengthOfLastWord("Hello World"));
		System.out.println(lengthOfLastWord(" a "));

		int[] input = {2,1,2,9};
		int[] result = plusOne(input);
		for (int i : result) {
			System.out.print(i);
		}
		
		System.out.println(" ");
		System.out.println(addBinary("11","01"));
		
		System.out.println(mySqrt(100));
	}
	
    public static int lengthOfLastWord(String s) {
    	s=s.trim();
    	if(s.length()==0)
    		return 0;
    	
    	String[] stringArray = s.split("\\s+");
    	int n = stringArray.length;
    	
		return stringArray[n-1].length();
        
    }
    
    
    public static int[] plusOne(int[] digits) {
    	int n = digits.length;
    	
    	for(int i=n-1;i>=0;i--) {
    		if(digits[i]<9) {
    			digits[i]=digits[i]+1;
    			
    			return digits;
    		}
    			digits[i]=0;
    		
    	}
    	int[] newNumber = new int[n+1];
    	newNumber[0]=1;
        return newNumber;
    }
    
    public static String addBinary(String a, String b) {
    	
    	int s =0;
    	String result = "";
    	
    	int i = a.length()-1;
    	int j = b.length()-1;
    	
    	
    	
    	while(i>=0 || j>=0 || s==1) {
    		
    		s += ((i>=0)? a.charAt(i) - '0' : 0);
    		s += ((j>=0)? b.charAt(j) - '0' : 0);
    		
    		result = (char) (s%2+'0')+result;
    		s = s/2;
    		i--;
    		j--;
    	}
    	
    	
    	
		return result;
        
    }
    
    public static int mySqrt(int x) {
    	
    	
    	long r=x;
    	while(r*r>x) {
    	
    		r=(r+(x/r))/2;
    
    	}
    	
    	return (int)r;
    }

}
