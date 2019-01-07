
/*
https://leetcode.com/problems/next-permutation/submissions/

*/
package com.ub.leetcode;

import java.util.Arrays;

public class NextPermutation {

	public static void main(String[] args) {
		
		int[] input = {3,2,1};
		nextPermutation(input);

	}

	public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
        
        for (int j = 0; j < nums.length; j++) {
			System.out.println(nums[j]);
		}
    }

    private static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
