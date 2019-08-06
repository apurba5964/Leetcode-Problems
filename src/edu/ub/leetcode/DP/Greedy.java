package edu.ub.leetcode.DP;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.TreeMap;

public class Greedy {

//	https://leetcode.com/problems/previous-permutation-with-one-swap/
public int[] prevPermOpt1(int[] a) {
        
        int n = a.length;
        int j = n-2;
        
        
        int index = -1;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        int maxIndex = -1;
        boolean check = false;
        while(j>=0 && !check) {
            int k = j+1;
            if(a[j]>a[k]){
                
            while(k<n){
                
                    if(a[k]>min && a[j]>a[k]){
                        min=a[k];
                        index=k;    
                    }
                    
                   k++; 
                }
                System.out.println(index);
                int temp = a[j];
                a[j]=a[index];
                a[index]=temp;
                check=!check;
            }
            
            
            j--;
        }
      
        
        
            
            
            return a;
        
        
    }

//https://leetcode.com/problems/car-pooling/
public boolean carPooling(int[][] trips, int capacity) {
    
    TreeMap<Integer,Integer> map = new TreeMap<>();
    
    for(int[] trip : trips){
        map.put(trip[1],map.getOrDefault(trip[1],0)+trip[0]);
        map.put(trip[2],map.getOrDefault(trip[2],0)-trip[0]);
    }
    
    for(int cap : map.values()){
        capacity-=cap;
        if(capacity<0)
            return false;
    }
    
    
    return true;
}


//https://leetcode.com/problems/queue-reconstruction-by-height/
public int[][] reconstructQueue(int[][] people) {
    
    Arrays.sort(people,(a,b) -> 
                {
               
                    if(a[0]==b[0])
                        return Integer.compare(a[1],b[1]);
                    else
                        return Integer.compare(b[0],a[0]);
                }
               );
    
    LinkedList<int[]> list = new LinkedList<>();
    
    for(int[] p : people){
        
        list.add(p[1], p);    
    }
        //System.out.println(p[0]+" "+p[1]);
    int[][] result = new int[people.length][2];
    
    int i=0;
    for(int[] peep:list)
        result[i++]=peep;
    
    return result;
}



//https://leetcode.com/problems/non-overlapping-intervals/
public int eraseOverlapIntervals(int[][] intervals) {
    
    if(intervals.length<=1)
        return 0;
    
    Arrays.sort(intervals,(a,b) -> {
        
        return Integer.compare(a[1],b[1]);
    });
    
    int count = 0;
    int end = intervals[0][1];
    
    for(int i=1;i<intervals.length;i++){
        if(intervals[i][0]<end)
            count++;
        else
            end = intervals[i][1];
            
        
    }
    
    
    
    return count;
}


public boolean isSubsequence(String s, String t) {
    int fromIndex = 0;
    for (char c : s.toCharArray()) {
        fromIndex = t.indexOf(c, fromIndex);
        if (fromIndex++ < 0) {
            return false;
        }
    }
    return true;
}


}
