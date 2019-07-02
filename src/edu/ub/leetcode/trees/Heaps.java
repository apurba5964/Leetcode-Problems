
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
}
