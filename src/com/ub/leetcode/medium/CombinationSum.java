/*
https://leetcode.com/problems/combination-sum-ii/
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
https://leetcode.com/problems/rotate-image/
https://leetcode.com/problems/spiral-matrix-ii/
*/
package com.ub.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class CombinationSum {

	public static void main(String[] args) {

		//char[] input = { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
		// System.out.println(compress(input));
		//String input1 = "aabbbc";
		//System.out.println(compress1(input1));
		// compress2(input1);
		
		String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
		groupAnagrams(input);
	}

	public List<List<Integer>> combinationSum1(int[] candidates, int target) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);

		backTrack1(result, new ArrayList<>(), candidates, target, 0);

		return result;

	}

	private void backTrack1(List<List<Integer>> result, ArrayList<Integer> arrayList, int[] candidates, int target,
			int start) {
		if (target < 0)
			return;
		else if (target == 0)
			result.add(new ArrayList<>(arrayList));

		else {
			for (int i = start; i < candidates.length; i++) {
				if (i > start && candidates[i] == candidates[i - 1])
					continue;
				arrayList.add(candidates[i]);
				backTrack1(result, arrayList, candidates, target - candidates[i], i + 1);
				arrayList.remove(arrayList.size() - 1);

			}
		}

	}

	public int[] searchRange(int[] nums, int target) {

		int[] result = { -1, -1 };
		int h = nums.length;
		int lindex = mergeSort(nums, target, 0, h, true);

		if (lindex == nums.length || nums[lindex] != target) {
			return result;
		}
		result[0] = lindex;
		result[1] = mergeSort(nums, target, 0, h, false) - 1;

		return result;

	}

	private int mergeSort(int[] nums, int target, int low, int high, boolean check) {

		while (high > low) {
			int mid = (low + high) / 2;
			if (nums[mid] > target || (check && target == nums[mid]))
				high = mid;
			else
				low = mid + 1;

		}
		return low;

	}

	public static char[] compress(char[] chars) {

		// System.out.println(s);
		int i = 0, j = 0;
		while (i < chars.length) {

			char curr = chars[i];
			int c = 0;

			while (i < chars.length && chars[i] == curr) {

				i++;
				c++;

			}
			chars[j++] = curr;
			if (c != 1)
				for (char count : Integer.toString(c).toCharArray())
					chars[j++] = count;

			// System.out.println(c);
			// s.replaceAll(s.substring(i+1, j), String.valueOf(c));
			// System.out.println(s.substring(i+1, j));

		}
		System.out.println(j);

		return chars;

	}

	public static void compress2(String message) {

		char[] result = compress(message.toCharArray());

		for (char c : result) {
			System.out.print(c);
		}

	}

	public static String compress1(String message) {

		char[] messageCharArray = message.toCharArray();
		int i = 0, j = 0;
		while (i < message.length()) {

			char currChar = message.charAt(i);
			int c = 0;

			while (i < message.length() && message.charAt(i) == currChar) {

				i++;
				c++;

			}
			messageCharArray[j++] = currChar;
			if (c != 1) {
				for (char count : Integer.toString(c).toCharArray())
					messageCharArray[j++] = count;
			}

		}
		String result = String.copyValueOf(messageCharArray).substring(0, j);

		return result;

	}

	public static List<String> checkIp(List<String> ip_array) {
		final String ipv4_pattern = "(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])";
		final String ipv6_pattern = "([0-9a-f]{1,4}:){7}([0-9a-f]){1,4}";

		ArrayList<String> result = new ArrayList<>();

		Pattern VALIDALTE_IPV4 = Pattern.compile(ipv4_pattern, Pattern.CASE_INSENSITIVE);
		Pattern VALIDALTE_IPV6 = Pattern.compile(ipv6_pattern, Pattern.CASE_INSENSITIVE);

		for (String string : ip_array) {
			String check = checkIpAddress(string, VALIDALTE_IPV4, VALIDALTE_IPV6);
			result.add(check);
		}

		return result;

	}

	public static String checkIpAddress(String ipAddress, Pattern VALIDALTE_IPV4, Pattern VALIDALTE_IPV6) {

		Matcher m1 = VALIDALTE_IPV4.matcher(ipAddress);
		if (m1.matches()) {
			return "IPv4";
		}
		Matcher m2 = VALIDALTE_IPV6.matcher(ipAddress);

		if (m2.matches()) {
			return "IPv6";
		}

		return "Neither";
	}
	
   public static  void rotate(int[][] matrix) {
	   
	   for(int i=0;i<matrix.length;i++) {
		   for(int j=i;j<matrix[0].length;j++) {
			   int temp = matrix[i][j];
			   matrix[i][j] = matrix[j][i];
			   matrix[j][i] = temp;
		   }
	   }
	   String s="";
	   
	   
	   int n = matrix.length;
	   
	   for(int i=0;i<matrix.length;i++) {
		   for(int j = i;j < n/2 ; j++) {
			   
			   int temp = matrix[i][j];
			   matrix[i][j] = matrix[i][n-j-1];
			   matrix[i][n-j-1] = temp;
		   }
		   
		   
	   }
        
    }
   
   
   public static int[][] generateMatrix(int n) {
       int[][] result = new int[n][n];
       int num =0;
       int left =0,right = n-1,down=n-1,top=0;
       
       while(left <= right) {
       for(int i=left;i<=right;i++) {
    	   result[left][i]=++num;
       }
       top++;
       for(int i=top;i<=down;i++) {
    	   result[i][down]=++num;
       }
       right--;
       for(int i=right;i>=left;i--) {
    	   result[down][i]=++num;
       }
       down--;
       
       for(int i=down;i>=top;i--) {
    	   result[i][left]=++num;
       }
       left++;
       
       }
       
       return result;
   }
   
   public List<Integer> spiralOrder(int[][] matrix) {
	ArrayList<Integer> result = new ArrayList<>();
	int n =matrix.length;
	int left =0,right = n-1,down=n-1,top=0;
    
    while(left <= right) {
    for(int i=left;i<=right;i++) {
 	   result.add(matrix[left][i]);
    }
    top++;
    for(int i=top;i<=down;i++) {
    	result.add(matrix[i][down]);
 	  
    }
    right--;
    for(int i=right;i>=left;i--) {
    	result.add(matrix[down][i]);
 	   
    }
    down--;
    
    for(int i=down;i>=top;i--) {
    	result.add(matrix[i][left]);
 	  
    }
    left++;
    
    }
    
    return result;
	   
	   
	
       
   }
   
   
   
   public static List<List<String>> groupAnagrams(String[] strs) {
	   
	   
	   
	   
	   HashMap<String,List<String>> map = new HashMap<>();
	   
	   for (String str : strs) {
		   char [] ch = str.toCharArray();
		   Arrays.sort(ch);
		   
		   if(!map.containsKey(String.valueOf(ch))) {
			   ArrayList<String> inter = new ArrayList<>();
			   inter.add(str);
			   map.put(String.valueOf(ch), inter);
		   }else {
			   map.get(String.valueOf(ch)).add(str);
		   }
		
	}
	  
	 /*  for (String str : strs) {
		System.out.println(str);
	}*/
	   
	   
	   
	   return new ArrayList<>(map.values());
       
   }

}
