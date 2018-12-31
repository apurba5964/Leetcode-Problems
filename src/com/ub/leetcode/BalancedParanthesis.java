/*
https://leetcode.com/problems/valid-parentheses/
*/
package com.ub.leetcode;

import java.util.Stack;

public class BalancedParanthesis {

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


}
