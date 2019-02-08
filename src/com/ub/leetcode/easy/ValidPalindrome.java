/*
https://leetcode.com/problems/valid-palindrome/
https://leetcode.com/problems/single-number/
https://leetcode.com/problems/missing-number/
https://leetcode.com/problems/linked-list-cycle/
https://leetcode.com/problems/happy-number/
https://leetcode.com/problems/intersection-of-two-linked-lists/
https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
*/
package com.ub.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;

public class ValidPalindrome {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static void main(String[] args) {

		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		int[] input = { 4, 1, 2, 1, 2 };
		int[] input1 = { 9, 6, 4, 2, 3, 5, 7, 0, 1 };
		System.out.println(singleNumber(input));
		System.out.println(missingNumber(input1));
		System.out.println(isHappy(19));
	}

	public static boolean isPalindrome(String s) {
		if (s.isEmpty())
			return true;

		s = s.trim().toLowerCase().replaceAll("\\s+", "").replaceAll("[^A-Za-z0-9]", "");
		;
		StringBuilder sbuild = new StringBuilder(s);

		String temp = sbuild.reverse().toString().toLowerCase();

		if (temp.equalsIgnoreCase(s))
			return true;
		else
			return false;

	}

	public static int singleNumber(int[] nums) {

		int result = 0;
		for (int i = 0; i < nums.length; i++) {

			result = result ^ nums[i];
		}

		return result;

	}

	public static int missingNumber(int[] nums) {
		Arrays.sort(nums);
		if (nums[nums.length - 1] != nums.length) {
			return nums.length;
		} else if (nums[0] != 0) {
			return 0;
		}

		int index = 0;

		for (int i = nums.length - 1; i > 0; i--) {
			System.out.println(nums[i]);
			if (nums[i] - nums[i - 1] != 1) {
				index = i;
				break;
			}
		}

		return nums[index] - 1;

	}

	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null)
			return false;
		ListNode fast = head, slow = head;
		while (fast != null && fast.next != null && slow != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow)
				return true;
		}
		return false;
	}
	
   public static  boolean isHappy(int n) {
	if(n==0)
		return false;
	   
	if(n == 1 || n == 7) return true;
    if(n>1 && n<10)
		return false;
		
	int sum = 0;
	
    while(n>0) {
    	int temp = n % 10;
    	sum = sum + temp*temp;
    	n=n/10;
    	}
    System.out.println(sum);
    if(sum==1)
    	return true;
    else
    	return isHappy(sum);
    
    
   
	   
	
        
    }
   
   public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	 
	   if(headA == null || headB == null) return null;
	   ListNode tempA = headA;
	   ListNode tempB = headB;
	   
	   while(tempA!=tempB) {
		   
		   
		   
		   if(tempA==null)
			   tempA=headB;
		   else
			   tempA=tempA.next;
		   
		   if(tempB==null)
			   tempB=headA;
		   else
			   tempB=tempB.next;
		   
	   }
	   
	      
	   
	return tempA;
       
   }
   
   public int[] twoSum(int[] numbers, int target) {
	   
	   int i=0;
	   int j=numbers.length-1;
	   int [] result = new int[2];
	   
	   while(i<j) {
		   int sum = numbers[i]+numbers[j];
		   
		   if(sum == target) {
			   result[0]=i;
			   result[1]=j;
			   return result;
		   }
			   
		   if(sum>target)
			   j--;
		   else
			   i++;
	   }
	   
	   return result;
       
   }

}
