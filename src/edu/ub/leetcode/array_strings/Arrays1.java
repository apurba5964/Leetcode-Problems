

//https://www.geeksforgeeks.org/must-do-coding-questions-for-companies-like-amazon-microsoft-adobe/?ref=feed
//https://leetcode.com/problems/find-peak-element/

package edu.ub.leetcode.array_strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class Arrays1 {

	public static void main(String[] args) {
		int[] input = {-5,3,2,1,-4};
		//System.out.println(tripletSum(input));
		//System.out.println(kdaneAlgo(input));
		//int[] result =  distributeCandies(60,4);
		//for (int i : result) {
		//	System.out.print(i+" ");
		//}
		System.out.println(parseBoolExpr("!(&(!(&(f)),&(t),|(f,f,t)))"));
		
		
	}
	
	
	public static int tripletSum(int[] n) {
		
		Arrays.sort(n);
		int count=0;
		
		for(int i = n.length-1;i>=0;i--) {
			int j=0;
			int k = i-1;
			
			while(j<k) {
				if(n[j]+n[k]==n[i]) {
					count++;
					break;
				}
				else if(n[j]+n[k]<n[i])
					j++;
				else
					k--;
			}
			
			
		}
		
		
		return count;
	}
	
	public static int kdaneAlgo(int[] array) {
		int tmax =0;
		int max=0;
		
		for(int i=0;i<array.length;i++) {
			max = max+ array[i];
			if(max<0)
				max=0;
			if(tmax<max)
				tmax = max;
			
		}
		
		return tmax;
	}
	
	public int findPeakElement(int[] nums) {
        int l =0,r= nums.length-1;
        while(l<r){
            int mid = l+((r-l)/2);
            if(nums[mid]>nums[mid+1])
                r=mid;
            else
                l=mid+1;
                
        }
        
        return l;
    }
	
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
		List<Integer> arr1 = new ArrayList<Integer>();
		
		for (int i : arr)
		{
			arr1.add(i);
		}
        
        int l = 0;
        int h = arr1.size()-k;
        while(l<h) {
        	int mid = l + (h-l)/2;
        	if(x - arr1.get(mid) > arr1.get(mid+k)-x) {
        		l= mid+1;
        	}else
        		h=mid;
        	
        }
        
        
        return arr1.subList(l, l+k);
    }
	
	
	public static int[] distributeCandies(int candies, int num_people) {
		
        int[] result = new int[num_people];
        for(int i=0;i<num_people;i++)
            result[i]=0;
        
        int index = 0;
        int n = 0;
        while(candies>0){
            
                if(n+1 < candies)
                    result[index]+=n+1;
                else
                    result[index]+=candies;
            
            
            candies = candies-(n+1);
            n++;
            
            index=(index+1)%num_people;
            
        }
        return result;
    }
	
	
	public static  boolean parseBoolExpr(String expression) {
		PriorityQueue<Integer> res = new PriorityQueue<>();
		//res.remove(1);
		
        char result = 'f';
        Stack<Character> op = new Stack<>();
        
        Stack<Character> exp = new Stack<>();
        for(int i=0;i<expression.length();i++){
            char ch = expression.charAt(i);
            if(ch!=','){
                if(ch=='!' || ch=='&' || ch=='|')
                    op.push(ch);
                if(ch=='t' || ch=='f' || ch=='(')
                    exp.push(ch);
                
                if(ch==')'){
                    //op.pop();
                    char op1 = op.pop();
                    int n = exp.size();
                    
                    
                    
                        
                        if(op1=='&'){
                        	result = 't';
                            while(exp.peek()!='('){
                            char exp1 = exp.pop();
                            
                            if(exp1=='f'){
                            	result = 'f';
                            	break;
                              }
                            
                            
                        }
                           
                            
                            exp.pop();
                            exp.push(result); 
                        }
                        
                        if(op1=='|'){
                            while(exp.peek()!='('){
                            char exp1 = exp.pop();
                            if(exp1=='t'){
                                result = 't';
                                break;
                                }
                        }
                            exp.pop();
                            exp.push(result); 
                        }
                    if(op1=='!'){
                        char temp = exp.pop();
                        if(temp=='t')
                            exp.push('f');
                        else
                            exp.push('t');
                    }
                    
                   
                }
                
            }
            
        }
        if(exp.peek()=='t')
            return true;
        else
            return false;
        
        
    }
	
	


	//https://leetcode.com/problems/longest-well-performing-interval/
	public int longestWPI(int[] hours) {
	    
	    int max=0;
	    for(int i=0;i+max<hours.length;i++){
	        int t=0;
	        int nt=0;
	        int k=i;
	        int c=0;
	        while(k<hours.length){
	            if(hours[k]>8)
	                t++;
	            else
	                nt++;
	            
	            k++;
	            c++;
	            if(t>nt)
	                max=Math.max(max,c);
	            
	        }
	        //int temp = c;
	       // System.out.println(max);
	        
	    }
	    
	    return max;
	}
	
	
	
}
