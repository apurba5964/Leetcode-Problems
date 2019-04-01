
/*
https://leetcode.com/problems/powx-n/

https://www.geeksforgeeks.org/counting-inversions/
*/
package com.ub.leetcode.medium;

public class Pow {

	public static void main(String[] args) {
		//System.out.println(pow(2,-1));
		int arr[] = new int[] { 1, 20, 6, 4, 5 };
		System.out.println(countInversions(arr));
	}
	
	public static double pow(double x, int m) {
        
		double temp=1;
        if(m==0)
        return 1;
        
        temp=pow(x,m/2);
        
        if(m%2==0)
        return temp*temp;
        else 
        {
        if(m > 0)
            return x*temp*temp;
        else
            return (temp*temp)/x;
        }
	
}
	
	
	public static int countInversions(int[] arr) {
		
		int n = arr.length;
		int l = 0;
		
		int[] temp = new int[arr.length];
		int count = mergeSort(arr,temp,l,n-1);
		return count;
	}

	private static int mergeSort(int[] arr, int[] temp, int l, int r) {
		int inv_cnt = 0;
		
		if(r>l) {
		int mid = (l+r)/2;
		
		inv_cnt = mergeSort(arr, temp, l, mid);
		inv_cnt += mergeSort(arr, temp, mid+1, r);
		
		
		inv_cnt += merge(arr,temp,l,mid+1,r);
		
		}
		
		
		return inv_cnt;
	}

	private static int merge(int[] arr, int[] temp, int l, int mid, int r) {
		int inv_cnt =0;
		int i = l;
		int j =mid;
		int k=l;
		while(i<mid && j<=r) {
			if(arr[i]<arr[j]) {
				temp[k++] = arr[i++];
				
			}else {
				inv_cnt += mid-i;
				temp[k++] = arr[j++];
				
			}
			
		}
		while(i<mid) {
			temp[k++]=arr[i++];
		}
		while(j<=r) {
			temp[k++]=arr[j++];
		}
		
		for (i = l; i <= r; i++) 
            arr[i] = temp[i];
		
		
		return inv_cnt;
	}
	
}
