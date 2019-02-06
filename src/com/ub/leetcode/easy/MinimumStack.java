/*

https://leetcode.com/problems/min-stack/

*/

package com.ub.leetcode.easy;

import java.util.ArrayList;

public class MinimumStack {

	ArrayList<Integer> stack = new ArrayList<>();
	int min=Integer.MAX_VALUE;
	public MinimumStack() {
		
	}
	
	
    public void push(int x) {
        if(x<min)
        	min=x;
        
    	stack.add(x);
    }
    
    public void pop() {
    	if(stack.size()>0)
    	stack.remove(stack.size()-1);
    	
    	int temp=Integer.MAX_VALUE;
    	for (Integer integer : stack) {
			if(integer<temp)
				temp=integer;
		}
    	min=temp;
        
    }
    
    public int top() {
		return stack.get(stack.size()-1);
        
    }
    
    public int getMin() {
		return min;
        
    }
}
