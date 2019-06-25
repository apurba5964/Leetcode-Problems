
//https://www.geeksforgeeks.org/next-greater-element/
//https://leetcode.com/problems/remove-duplicate-letters/
package edu.ub.leetcode.linkedlist;

import java.util.HashMap;
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
	
	
	
	public int calculate(String s) {
        int n = s.length();
        int result  = 0;
        int number = 0;
        Stack<Integer> st = new Stack<>();
        int sign = 1;
        for(int i =0;i<n;i++){
            char ch = s.charAt(i);
            
            if(Character.isDigit(ch)) {
            	number= Character.getNumericValue(ch);
            	
            }else if (ch == '+') {
				result += sign * number;
				sign =1;
				number=0;
            	
			}
            else if (ch == '-') {
				result += sign * number;
				sign = -1;
				number=0;
            	
			}
            else if (ch == '(') {
				st.push(result);
				st.push(sign);
				sign =1;
				result =0;
			}
            else if (ch == ')') {
				result += sign * number;
				number = 0;
				
				result *= st.pop();
				result += st.pop();
			}
            	
            
        }
        if(number != 0) 
        	result += sign * number;
        	
        
        return result;
    }
	
	
	
	public String removeDuplicateLetters(String s) {
	       HashMap<Character,Integer> map = new HashMap<>(); 
	       for(int i = 0;i<s.length();i++){
	           map.put(s.charAt(i),i);
	       }
	        char[] result = new char[map.size()];
	        int start = 0;
	        for(int i=0;i<result.length;i++){
	            int end = getMinChar(map);
	            char min = 'z' +1;
	            for(int j=start;j<=end;j++){
	                if(map.containsKey(s.charAt(j)) && s.charAt(j)<min)
	                {
	                    min = s.charAt(j);
	                    start = j+1;
	                }
	            }
	            result[i]=min;
	            map.remove(min);
	        }
	        
	        
	        return String.valueOf(result);
	    }
	    
	    public int getMinChar(HashMap<Character,Integer> map){
	        
	        int min = Integer.MAX_VALUE;
	        for(int val : map.values()){
	            if(min>val)
	                min=val;
	        }
	        
	        return min;
	    }
	
	

}
