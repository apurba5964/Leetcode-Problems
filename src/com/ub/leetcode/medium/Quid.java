package com.ub.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Quid {

	public static void main(String[] args) {
		
		
		System.out.println(calculateScore("engine", "raven", "ginkgo"));

	}
	
	public static String calculateScore(String text,String prefixString,String suffixString) {
		
		String temp1 = text;
		String temp2 = text;
		
		
		String reverseSuffix = new StringBuilder(suffixString).reverse().toString();
		
		
		int prefixScore = getScore(temp1,prefixString);
		
		
		int suffixScore = getScore(temp2,reverseSuffix);
		
		//System.out.println(prefixScore);
		//System.out.println(suffixScore);
        //System.out.println(reverseSuffix);
		String pref = prefixString.substring(prefixString.length()-prefixScore, prefixString.length());
		String suff = suffixString.substring(0, suffixScore);
		//System.out.println(pref);
		//System.out.println(suff);
		
		
		
		
		return pref+suff;
		
		
		
		
	}

	private static int getScore(String text,String checkString) {
		
		//System.out.println(checkString);
		
		int n = checkString.length()-1;
		int c = n;
		int score = 0 ;
		while(n >= 0) {
			char curr = checkString.charAt(n);
			if(text.toLowerCase().contains(String.valueOf(curr)) && c==n){
				//System.out.println(curr);
				score++;
				c--;
				
			}
			n--;
			
			
		}
		
		
		return score;
	}
	
	
	
	public static int findBestPath(int n, int m, int max_t, List<Integer> beauty, 
			List<Integer> u, List<Integer> v, List<Integer> t) {
		
		for(int j=0;j<m;j++) {
			int k = u.get(j);
			int l = v.get(j);
			int o = t.get(j);
			
			int checkIndex = v.get(k);
			
			
		}
		
		
		return max_t;
	    

	    }

}
