/*
https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
https://leetcode.com/problems/excel-sheet-column-title/
https://leetcode.com/problems/majority-element/
https://leetcode.com/problems/excel-sheet-column-number/
https://leetcode.com/problems/self-dividing-numbers/
Sort String of dates of the form dd mmm yyy
https://leetcode.com/problems/factorial-trailing-zeroes/
*/
package com.ub.leetcode.easy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;

public class TwoSumBST {
	
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }

	public static void main(String[] args) {
		System.out.println(convertToTitle(26));
		System.out.println(convertToNumber("ZY"));
		System.out.println(selfDividingNumbers(1,22));
		ArrayList<String> input = new ArrayList<>();
		input.add("12 Dec 1968");
		input.add("12 Jan 1968");
		sortDates(input);
		System.out.println(trailingZeroes(1808548329));
	}
	
    public boolean findTarget(TreeNode root, int k) {
    	
    	if(root==null)
    		return false;
    	ArrayList<Integer> list = new ArrayList<>();
    	inOrderTraversal(root,list);
    	
    	
    	
       int i=0;
 	   int j=list.size()-1;
 	   
 	   
 	   while(i<j) {
 		   int sum = list.get(i)+list.get(j);
 		   
 		   
 		   if(sum == k) 
 			   
 			   return true;
 		   
 			   
 		   if(sum>k)
 			   j--;
 		   else
 			   i++;
 	   }
 	   
 	   return false;
        
    }
    	
    	
    	
	

	private void inOrderTraversal(TreeNode root, ArrayList<Integer> list) {
		if (root == null)
            return;
		
		
		inOrderTraversal(root.left, list);
		list.add(root.val);
		inOrderTraversal(root.right, list);
		
		
	}
	
    public static String convertToTitle(int n) {
	
    	String result = "";
    	while(n!=0) {
    		result = (char) ('A'+ (n-1)%26) + result;
    		n = (n-1)/26;
    	}
	
	
	return result;
        
    }
    
    public static int convertToNumber(String s) {
    	
    	int result = 0 ;
    	char[] c = s.toCharArray();
    	for (char chars : c) {
		
    		int temp = (int)( chars % 65) + 1;
    		result = result*26+temp;
		}
	
	
	return result;
        
    }
    
    
   public static  int majorityElement(int[] nums) {
	   
       Arrays.sort(nums);
       return nums[nums.length/2];
    }
    
   
   public static List<Integer> selfDividingNumbers(int left, int right) {
	
	   ArrayList<Integer> result = new ArrayList<>();
	   
	for(int i=left;i<=right;i++) {
		int temp1 = 0,temp2 = 0;
		int number = i;
		while(number>0) {
			temp1++;
			int temp = number % 10;
			if(temp != 0) {
				if(i % temp==0)
					temp2++;
				
			}
				
			
			number = number/10;
				
		}
		if(temp1==temp2)
			result.add(i);
		
	}   
	   
	   
	return result;
       
   }
   
   
   
   public static List<String> sortDates(List<String> dates) {
	   int n = dates.size();
	   String[] list = new String[dates.size()];
	
	   
	   for(int i=0;i<dates.size();i++) {
		   list[i]=dates.get(i);
	   }
	   HashMap<String, Integer> monthsMap = new HashMap<>();
	   
	    // Order the months 
	    sort_months(monthsMap); 
	  
	    for (int t = 0; t < n- 1; t++) {
            for (int i= 0; i < n - t -1; i++) {
                if(compare(list[i+1],list[i],monthsMap)) {
                    String temp = list[i];
                    list[i] = list[i+1] ;
                    list[i+1] = temp;
                }
            }
        }
	    
	    for (String string : list) {
			System.out.println(string);
		}
	   
	return Arrays.asList(list);
	   
   }

  public static void sort_months(HashMap<String, Integer> monthsMap) {
	
	    monthsMap.put("Jan", 1); 
	    monthsMap.put("Feb", 2); 
	    monthsMap.put("Mar", 3); 
	    monthsMap.put("Apr", 4); 
	    monthsMap.put("May", 5); 
	    monthsMap.put("Jun", 6); 
	    monthsMap.put("Jul", 7); 
	    monthsMap.put("Aug", 8); 
	    monthsMap.put("Sep", 9); 
	    monthsMap.put("Oct", 10); 
	    monthsMap.put("Nov", 11); 
	    monthsMap.put("Dec", 12); 
	    
	
   }
  
   static boolean compare(String a, String b,HashMap<String, Integer> monthsMap) 
  { 

  	// Comparing the years 
	  String str1 = a.substring(7, 11); 
	  String str2 = b.substring(7, 11); 
  	if (str1.compareTo(str2) != 0) { 
  		if (str1.compareTo(str2) < 0) 
  			return true; 
  		return false; 
  	} 

  	// Comparing the months 
  	
  	String month_sub_a = a.substring(3, 6); 
  	String month_sub_b = b.substring(3, 6); 

  	
  	// Taking numeric value of months from monthsMap 
  	int month_a = monthsMap.get(month_sub_a); 
  	int month_b = monthsMap.get(month_sub_b); 
  	if (month_a != month_b) { 
  		return month_a < month_b; 
  	} 

  	// Comparing the days 
  	String day_a = a.substring(0, 2); 
  	String day_b = b.substring(0, 2); 
  	if (day_a.compareTo(day_b) < 0) 
  		return true; 
  	return false; 
  } 
   
   
   
  public static List<String> findSchedule(int workHours, int dayHours, String pattern){
	  
	  char[] worked = pattern.toCharArray();
	  ArrayList<Integer> temp = new ArrayList<>();
	  
	  int sum =0,count=0,k=0;
	  for (char c : worked) {
		  k++;
		if(c!='?') {
			sum = sum + ((int)c-48);
		}else {
			count++;
			temp.add(k);
		}
		
	  }
		
		int hoursLeft = workHours-sum;
		int[] list = new int[hoursLeft]; 
		for(int i=0;i<hoursLeft;i++) {
			list[i]=i+1;
		}	
		
		List<List<Integer>> combinations =combinationSum(list,hoursLeft);
		ArrayList<String> result = new ArrayList<>();
		
		for (List<Integer> d : combinations) {
			char[] worked1 = pattern.toCharArray();
			if(d.size()==count) {
				for(int i =0;i<temp.size();i++) {
					worked1[temp.get(i)]= (char)(d.get(i) + '0');
				}
				
			}
			result.add(worked1.toString());
		}
	
	  
	  
	return result;
}
  
  public static List<List<Integer>> combinationSum(int[] nums, int target) {
	    List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(nums);
	    backtrack(list, new ArrayList<>(), nums, target, 0);
	    return list;
	}

	private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
	    if(remain < 0) return;
	    else if(remain == 0) list.add(new ArrayList<>(tempList));
	    else{ 
	        for(int i = start; i < nums.length; i++){
	            tempList.add(nums[i]);
	            backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
	            tempList.remove(tempList.size() - 1);
	        }
	    }
	}
  
   public static int trailingZeroes(int n) {
	   
	   return n==0 ? 0: n/5 + trailingZeroes(n/5);
   }
 
   public List<List<Integer>> combinationSum1(int[] candidates, int target) {
	   
	   List<List<Integer>> result = new ArrayList<List<Integer>>();
	   Arrays.sort(candidates);
	   
	   backTrack1(result,new ArrayList<>(),candidates,target,0);
	   
		
	
	   
	   
	return result;
       
   }

private void backTrack1(List<List<Integer>> result, ArrayList<Integer> arrayList, int[] candidates, int target, int start) {
	if(target<0)
		return;
	else if(target==0)
		result.add(new ArrayList<>(arrayList));
	
	else {
		for(int i = start;i<candidates.length;i++) {
			arrayList.add(candidates[i]);
			backTrack1(result, arrayList, candidates, target-candidates[i], i);
			arrayList.remove(arrayList.size()-1);
			
		}
	}
	
}
   
}
