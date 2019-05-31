package com.ub.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ACV_Auctions {
	
	public static void main(String[] args) {
		
		
		//System.out.println(subStrings("1102021222", 2));
		
		//System.out.println(subStrings1(""));
		//test("a:z,b,c,d,e,f");
		ArrayList<Integer> input = new ArrayList<>();
		input.add(10);
		input.add(10);
		input.add(7);
		//System.out.println(minSum(input, 3));
		test();
	}
	static int max_char = 10;
	public static boolean check(int freq[],int k) {
		
		
		for (int i = 0; i < max_char; i++) 
	        if (freq[i]!=0 && freq[i] != k) 
	            return false; 
	    return true;
		
	} 
	
	public static int subStrings(String s ,int k) {
		
		int res = 0;
		
		for(int i=0;i<s.length();i++) {
			int[] frequency = new int[10];
			for (int j = i;j<s.length();j++) { 
				   
	            
	            int index = s.charAt(j) - '0'; 
				
				
	            frequency[index]++; 
	  
	            if (frequency[index] > k) 
	                break; 
	  
	           
	            else if (frequency[index] == k &&  
	                  check(frequency, k) == true) 
	                res++; 
	        } 
		}
		
		
		
		return res;
		
		
	}

	public static void test(String str) {
		System.out.println(str);
		String[] strParts = str.split(",");
		
		for (String string : strParts) {
			System.out.println(string);
		}
		String[] x = strParts[0].split(":");
		System.out.println(x[0]+" "+x[1]);
	}
	
	
public static char subStrings1(String str) {
	
	char result = ' ';  
	try {
	int size = 256; 
    int count[] = new int[size]; 
   
   
    int len = str.length(); 
    for (int i=0; i<len; i++) 
        count[str.charAt(i)]++; 
   
    int max = -1;  
    
   
    
    for (int i = 0; i < len; i++) { 
        if (max < count[str.charAt(i)]) { 
            max = count[str.charAt(i)]; 
            result = str.charAt(i); 
        } 
    } 
   
   
    
	}catch (NullPointerException ex ) {
	   
	}catch (ArrayIndexOutOfBoundsException ex ) {
		   
		}
	catch (Exception ex ) {
	   
	}
	
	 return result;
	
	
		
	}

public static char subStrings2(String str) {
    int freq[] = new int[26]; 
    
  
    int max = -1; 

   
    char result = 0; 

   
    int len = str.length(); 

    
    for (int i = 0; i < len; i++) { 
        if (str.charAt(i) != ' ') { 
            freq[str.charAt(i) - 'a']++; 
        } 
    } 


    for (int i = 0; i < 26; i++) { 
        if (max < freq[i]) { 
            max = freq[i]; 
            result = (char) (i + 'a'); 
        } 
    } 

   

    return result; 
    

}

public static int minimumMoves(List<Integer> a, List<Integer> m) {
    // Write your code here
	int result = 0;
	for(int i=0;i<a.size();i++) {
		int x = a.get(i);
		int y = m.get(i);
		
		ArrayList<Integer> op1 = getInts(x);
		ArrayList<Integer> op2 = getInts(y);
		
		for(int j =0;j<op1.size();j++) {
			int diff = Math.abs(op1.get(j)-op2.get(j));
			result+=diff;
		}
		
		
	}
	
	

	return result;
    }



public static ArrayList<Integer> getInts(int x) {
	ArrayList<Integer> result = new ArrayList<>();
	while(x>0) {
		int y = x % 10;
		result.add(y);
		x=x/10;
		
	}
	
	return result;
}

public static int minSum(List<Integer> num, int k) {
   

	int[] a = new int[num.size()];
	
	for (int l=0 ;l<num.size();l++) {
		a[l]=num.get(l);
	}
	
	Arrays.sort(a);
	int j =num.size()-1;
	while(k>0) {
		double max = a[j];
		max = Math.ceil(max/2);
		
		
		a[j]=(int)max;
		Arrays.sort(a);
		
		k--;
	}
	
	int sum =0;
	for (int i : a) {
		sum+=i;
	}
	
	return sum;
    }

public static void test() {
	
 String check = "^\"([\\w]+=[\\w]+;(\\s)*)*([\\w]+=[\\w]+)\"$";
 String test = "\"coding=helloworld; foobar=demo; random=error\"";
 
 System.out.println(test);
 System.out.println(test.matches(check));
 
}






}
