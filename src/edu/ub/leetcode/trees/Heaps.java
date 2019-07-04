
//https://leetcode.com/problems/find-median-from-data-stream/
package edu.ub.leetcode.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	
	
	
	//https://leetcode.com/problems/top-k-frequent-elements/
	public List<Integer> topKFrequent(int[] nums, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if(nums.length==1){
            result.add(nums[0]);
            return result;
            }
        
        
        HashMap<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<Map.Entry<Integer,Integer>>((m1,m2) -> m2.getValue()-m1.getValue());
        
        
        
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        
        pq.addAll(map.entrySet());
        
        
        for(int i=0;i<k;i++){
            result.add(pq.poll().getKey());
        }
            
        
        return result;
    }
	
	//https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix
	
	
	public int kthSmallest(int[][] matrix, int k) {

        int n = matrix.length;
        int len = n*n;
        int low=0;
        int high=len-1;
       // k=n-k;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i =low;i<n;i++){
            for(int j=low;j<n;j++){
                if(pq.size()==k){
                    if(pq.peek()>matrix[i][j]){
                        pq.poll();
                        pq.add(matrix[i][j]);
                    }
                        
                }else
                    pq.add(matrix[i][j]);
            }
        }
        
        return pq.peek();
    }
}
