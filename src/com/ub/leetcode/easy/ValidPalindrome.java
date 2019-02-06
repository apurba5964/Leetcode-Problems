/*
https://leetcode.com/problems/valid-palindrome/
https://leetcode.com/problems/single-number/
https://leetcode.com/problems/missing-number/
https://leetcode.com/problems/linked-list-cycle/
https://leetcode.com/problems/happy-number/
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

}
