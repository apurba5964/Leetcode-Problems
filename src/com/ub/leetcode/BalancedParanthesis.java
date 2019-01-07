/*
https://leetcode.com/problems/valid-parentheses/
https://leetcode.com/problems/longest-valid-parentheses/
*/
package com.ub.leetcode;

import java.util.Stack;

public class BalancedParanthesis {

	public static void main(String[] args) {
		System.out.println(longestValidParentheses("()(()"));
	}
	
public boolean isValid(String s) {
	
	Stack<Character> st = new Stack<>();
	
	char[] paraArray = s.toCharArray();
	
	for (char c : paraArray) {
		if(c == '(' || c == '{' || c== '[') {
			st.push(c);
			
		}
		
		if(c == ')' || c == '}' || c== ']') {
			if(st.isEmpty())
				return false;
			
			else if(!balanced(st.pop(), c)) {
				return false;
			}
			

			
		}
	}
	
	
	if(st.isEmpty())
		return true;
	else
		return false;
        
    }


public static boolean balanced(char ch1,char ch2) {
	
	if(ch1 =='(' && ch2 == ')')
		return true;
	
	if(ch1 =='{' && ch2 =='}') 
		return true;
	
	if(ch1 =='[' && ch2 ==']') 
		return true;
	
	
	return false;
	
}


public static int longestValidParentheses(String s) {
	int max=0;
	char[] input = s.toCharArray();
	Stack<Character> st = new Stack<>();
	
	for(int i=0;i<s.length();i++) {
		
		for(int j=i+2;j<=s.length();j+=2) {
			
			if(isValidPara(s.substring(i, j))){
				max = Math.max(max, j-i);
				
			}
		}
		
		
	}
	
	
	
	
	return max;
    
    
}

private static boolean isValidPara(String s) {
	Stack<Character> st=new Stack<>();
	char[] para = s.toCharArray();
	
	for(int i=0;i<para.length;i++) {
		if(para[i]=='(') {
			st.push(para[i]);
		}else if(!st.isEmpty() && st.peek()=='(') {
			
			st.pop();
		}else
			st.push(para[i]);
		
	}
	
	
	
	return st.empty();
}



}
