
//https://www.geeksforgeeks.org/next-greater-element/

package edu.ub.leetcode.linkedlist;

import java.util.Stack;

public class Stacks {
	
	
	public static void main(String[] args) {
		
		int[] input = {4,5,2,25};
		printNBE(input);
	}
	
	
	public static void printNBE(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		stack.push(arr[0]);
		
		
		for(int i=1;i<arr.length;i++) {
			
			int next = arr[i];
			if(!stack.isEmpty()) {
				
				int curr = stack.pop();
				
				
					while(next >curr) {
						System.out.println(curr+","+next);
						if(stack.isEmpty())
							break;
						curr = stack.pop();
					}
				
				
				if(next<curr)
					stack.push(curr);
				
				
			}
			
			stack.push(next);
		}
		while(!stack.isEmpty()) {
			System.out.println(stack.pop()+","+ -1);
		}
		
	}

}
