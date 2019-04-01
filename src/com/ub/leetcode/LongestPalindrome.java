package com.ub.leetcode;

public class LongestPalindrome {
	
	public static void main(String[] args) {
		/*System.out.println(count_palindromes("hellolle"));
		
		int[] input={ 2, 3, 4, 10, 40 };
		System.out.println(input.length);
		for (int i : input) {
			System.out.print(i+"\t");
		}*/
		
		System.out.println(longestPalindrome1("geekeg"));
	}
	
	 public static String longestPalindrome(String s) {
		 
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
		 System.out.println();
		 
		return s.substring(start, start+max);
	     
		 
	    }
	 
	 public static String longestPalindrome1(String s) {
	
		 int n = s.length();
		 int len =1;
		 int start = 0;
		 boolean[][] checkTable = new boolean[n][n];
		 
		 for(int i =0;i<n;i++) {
			 checkTable[i][i]=true;
		 }
		 
		 for(int i=0;i<n-1;i++) {
			if(s.charAt(i)==s.charAt(i+1)) {
				checkTable[i][i+1]=true;
				len =2;
			}else {
				checkTable[i][i+1]=false;
			 }
		 }
		 
		 for(int k = 3;k<=n;k++) {
			 for(int i=0;i<n-k+1;i++) {
				 int j = i+k-1;
				 if(s.charAt(i)==s.charAt(j)) {
					 if(checkTable[i+1][j-1]) {
						 checkTable[i][j]=true;
						 len = k;
						 start = i;
					 }
				 }
			 }
		 }
		 
		 
		 System.out.println(len);
		 return s.substring(start, start+len);
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
