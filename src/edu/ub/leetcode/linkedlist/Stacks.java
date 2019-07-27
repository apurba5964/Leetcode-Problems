
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
	
	    
	    
	    
//https://leetcode.com/problems/largest-rectangle-in-histogram/	    
	    public int largestRectangleArea(int[] heights) {
	        if(heights.length<=0)
	            return 0;
	     
	        Stack<Integer> st = new Stack<>();
	        //st.push(heights[0]);
	        int max=0;
	        int area=0;
	        int i;
	        for(i=0;i<heights.length;){
	           
	            if(st.isEmpty() || heights[i]>=heights[st.peek()]){
	                   st.push(i);
	                   i++;
	                //System.out.println(i);
	                }
	            else{
	            
	               
	               
	                int poll = st.pop();
	                
	                
	                if(st.isEmpty())
	                    area=heights[poll]*i;
	                else{
	                    area=heights[poll]*(i-st.peek()-1);
	                }
	                
	                max=Math.max(area,max);
	                //System.out.println(area+" max "+max+" poll "+poll);
	                
	            }
	            }
	              
	        while(!st.isEmpty()){
	               
	                int poll = st.pop();
	                
	                
	                if(st.isEmpty())
	                    area=heights[poll]*i;
	                else{
	                    area=heights[poll]*(i-st.peek()-1);
	                }
	                
	                max=Math.max(area,max);
	               // System.out.println(area+" max "+max+" poll "+poll);
	                
	            }
	        
	        
	        return max;
	    }
	

	    
//https://leetcode.com/problems/maximal-rectangle/	    
	    public int maximalRectangle(char[][] matrix) {
	        
	        
	        if(matrix.length==0)
	            return 0;
	        
	        int m=matrix.length;
	        int n=matrix[0].length;
	        int areaR=0;
	        int maxR=0;
	        
	        int[] memo =new  int[n];
	     
	        for(int i=0;i<m;i++){
	            for(int j=0;j<n;j++){
	               int x = Character.getNumericValue(matrix[i][j]);
	               if(x>0) 
	                    memo[j] += x; 
	                else
	                    memo[j] = 0;
	                //System.out.print(memo[j]+" ");
	                //System.out.println(" ");
	            }
	            areaR = largestRectangleArea(memo);
	            maxR=Math.max(maxR,areaR);
	        }
	        
	        return maxR;
	    }
	    
	    
	    
	    
//https://leetcode.com/problems/gas-station/	    
	    public int canCompleteCircuit(int[] gas, int[] cost) {
	        int g=0,c=0;
	        int n = gas.length;
	        for(int i=0;i<gas.length;i++){
	            g+=gas[i];
	            c+=cost[i];
	        }
	        if(g<c)
	            return -1;
	        
	        int index=-1;
	        
	        for(int i=0;i<gas.length;i++){
	            int start = i;
	            if(gas[start]>=cost[start]){
	              // System.out.println(start);
	                int j=(start+1)%n;
	                int fuel=gas[start];
	                while(true){
	                    
	                    int prev = j-1;
	                    if(prev<0)
	                        prev=n-1;
	                    
	                    fuel = fuel-cost[prev]+gas[j];
	                    
	                    if(fuel<cost[j]){
	                        i=start+1;
	                        break;
	                    }
	                  //  System.out.println(j+" "+fuel);
	                    j++;
	                    if(j>=n)
	                        j=j%n;
	                    
	                   if(j==start){
	                       index=start;
	                      return index;
	                   }
	                       
	                }
	                
	                    
	               // System.out.println(index);
	                
	            }
	        }
	        
	        return index;
	    }
	    	    
		
}
