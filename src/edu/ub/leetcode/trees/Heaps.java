
//https://leetcode.com/problems/find-median-from-data-stream/
package edu.ub.leetcode.trees;

import java.util.Collections;
import java.util.PriorityQueue;

public class Heaps {

	
	class MedianFinder {

	    /** initialize your data structure here. */
	    PriorityQueue<Integer> max;
	    PriorityQueue<Integer> min;
	    
	    
	    
	    public MedianFinder() {
	        max = new PriorityQueue<>(Collections.reverseOrder());
	        min = new PriorityQueue<>();
	        
	    }
	    
	    public void addNum(int num) {
	      max.add(num);
	      min.add(max.poll());
	      if(max.size()<min.size())  
	        max.add(min.poll());  
	        
	       
	    }
	    
	    public double findMedian() {
	        if(max.size()>min.size()){
	            return max.peek();
	        }else{
	            return (max.peek()+min.peek()) * 0.5 ;
	        }
	       
	    }
	}
	
	//https://leetcode.com/problems/super-ugly-number/
	public int nthSuperUglyNumber(int n, int[] primes) {
	     
        if(n==1)
            return 1;
        
        int[] result = new int[n];
        result[0]=1;
        int index=1;
        int k = primes.length;
        int[] pindex = new int[k];
        
        for(int i=0;i<primes.length;i++)
             pindex[i]=0;
             
            
            
        while(index<n){
            int[] temp = new int[k];
            int min = Integer.MAX_VALUE;
           
            for(int i=0;i<primes.length;i++){
             temp[i]=result[pindex[i]]*primes[i];
             if(min>temp[i])
                 min=temp[i];
            }
            result[index++]=min;
            //System.out.println(min);
            for(int i=0;i<temp.length;i++){
                if(min==temp[i])
                    pindex[i]++;
            }
            
            
        }
        
        return result[n-1];
    }
}
