package com.ub.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

	public static void main(String[] args) {
		System.out.println(generateParenthesis(3));

	}

public static List<String> generateParenthesis(int n) {
	
	
	
	List<String> result = new ArrayList<>();
	
	generate(result,"",0,0,n);
	
	
	
	
	return result;
        
    }

public static void generate(List<String> result, String str, int open, int close, int n) {
	
	
	if(str.length()==n*2) {
		result.add(str);
		return;
	}
	
	if(open<n)
		generate(result, str+"(", open+1, close, n);
	if(close<open)
		generate(result, str+")", open, close+1, n);
	
	
}
}
