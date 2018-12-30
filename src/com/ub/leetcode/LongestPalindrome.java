package com.ub.leetcode;

public class LongestPalindrome {
	
	public static void main(String[] args) {
		System.out.println(count_palindromes("hellolle"));
		
		int[] input={ 2, 3, 4, 10, 40 };
		System.out.println(input.length);
		for (int i : input) {
			System.out.print(i+"\t");
		}
	}
	
	 public String longestPalindrome(String s) {
		 
		 int n=s.length();
		 
		 if(n==0)
			 return "";
		 
		 boolean table[][] = new boolean[n][n]; 
		 
		 int max =1;
		 for(int i=0;i<n;i++) {
			 table[i][i]=true;
		 }
		 
		 int start =0;
		 for(int i=0;i<n-1;i++) {
			 if(s.charAt(i)==s.charAt(i+1)) {
				 table[i][i+1]=true;
				 start=i;
				 max=2;
			 }else {
				 table[i][i+1]=false;
			 }
		 }
		 
		 for(int k=3;k<=n;k++) {
			 for(int i=0;i<n-k+1;i++) {
				 int j=i+k-1;
				 
				 if(table[i+1][j-1] && s.charAt(i)==s.charAt(j)) {
					 table[i][j]=true;
					 start =i;
					 max=k;
				 }
				 
			 }
		 }
		 
		 
		return s.substring(start, start+max);
	     
		 
	    }
	 
	 
	 public static int count_palindromes(String s) {
		 
		 
		 
		    String temp = ""; 
	        StringBuffer temp_string; 
	        int count = 0; 
	       
	        for (int i = 0; i < s.length(); i++) { 
	            for (int j = i + 1; j <= s.length(); j++) { 
	                
	                temp = s.substring(i, j); 
	                  
	                    
	                if (temp.length() >= 2) { 
	                    
	                	temp_string = new StringBuffer(temp); 
	                	temp_string.reverse(); 
	                    
	                    if (temp_string.toString().compareTo(temp) == 0) 
	                        count++; 
	                } 
	            } 
	        } 
	        
	        return count+s.length(); 
		 
	 }

}
