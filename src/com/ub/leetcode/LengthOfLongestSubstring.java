package com.ub.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class LengthOfLongestSubstring {

	
	public int lengthOfLongestSubstring(String s) {
		
		ArrayList<Integer> result=new ArrayList<>(); 
		char[] charArray=s.toCharArray();
		HashMap<Character, Character> map=new HashMap<>();
		int counter=0;
		for (char c : charArray) {
			if(!map.containsKey(c)) {
				map.put(c, c);
				++counter;
			}else {
				map.clear();
				result.add(counter);
				
				map.put(c, c);
				counter=1;
			}
			
		}
        result.add(counter);
		if(!result.isEmpty())
			return Collections.max(result);
		else
			return 0;
        
    }
	
	public int lengthOfLongestSubstring2(String s) {
	     int right = 0;
	     ArrayList<Character> list = new ArrayList<>();
	     int maxSize = 0;
	        while(right < s.length()){
	        if(!list.contains(s.charAt(right))){
	            list.add(s.charAt(right));
	            right++;
	        }else{
	            list.remove(0);
	            }
	        
	        // keeps track of the longest substring without duplicates
	        if(list.size() > maxSize) maxSize = list.size();
	    }
	    
	    
	    return maxSize;
	    }

	
}
