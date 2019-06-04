

//https://leetcode.com/problems/minimum-window-substring/


package edu.ub.leetcode.array_strings;

import java.util.HashMap;

public class String1 {
	public static void main(String[] args) {
		
		String str = "abcd";
		
		//permutataions(str,"");
		//permutations1(str, 0, str.length()-1);
		System.out.println(minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd"));
		//"cabwefgewcwaefgcf"
		//"cae"
		//"aaaaaaaaaaaabbbbbcdd"
		//"abcdd"
		
	}

	private static void permutataions(String str,String prefix) {
		
		if(str.length()==0)
			System.out.println(prefix);
		for(int i=0;i<str.length();i++) {
			String rem = str.substring(0, i) + str.substring(i+1);
			permutataions(rem, prefix+str.charAt(i));
		}
		
		
	}
	
	private static void permutations1(String str , int l, int r) {
		if(l==r)
			System.out.println(str);
		else {
			for (int i = l; i <= r; i++) {
				str = swap(str,l,i);
				permutations1(str, l+1, r);
				str = swap(str,l,i);
			}
		}
		
	}

	private static String swap(String str, int i, int j) {
		char[] chars = str.toCharArray();
		char temp = chars[i];
		chars[i] = chars[j];
		chars[j] = temp;
		
		return String.valueOf(chars);
	}
	
   public static String minWindow(String s, String t) {
	   if (s.length() == 0 || t.length() == 0) {
	          return "";
	      }
	   
	   int left =0 ,right =0,n=s.length()-1,start =0,end =0,diff=Integer.MAX_VALUE;
	   HashMap<Character, Integer> reqMap =  new HashMap<>();
	   for(char ch : t.toCharArray()) {
		   if(reqMap.containsKey(ch))
			   reqMap.put(ch,reqMap.get(ch)+1);
		   else
			   reqMap.put(ch, 1);
		   
	   }
	   int count =0;
	   String result = "";
	   HashMap<Character, Integer> currWinMap =  new HashMap<>();
	   while(right<=n) {
		   
		   char ch = s.charAt(right);
		   if(currWinMap.containsKey(ch))
			   currWinMap.put(ch,currWinMap.get(ch)+1);
		   else
			   currWinMap.put(ch, 1);
		   
		   if(reqMap.containsKey(ch) && currWinMap.get(ch)==reqMap.get(ch)) {
			   count++;
		   }
		  // if(count==reqMap.size()) {
			   
			   while(left<=right && count==reqMap.size()) {
				   start=left;
				   end=right;
				   if(diff>=(end-start+1)) {
					   result = s.substring(start, end+1);
					   diff = end-start+1;
				   }
				   
				   
				   
				   if(reqMap.containsKey(s.charAt(left))) {
					
					currWinMap.put(s.charAt(left),currWinMap.get(s.charAt(left))-1);
				   }
				   
				   if(reqMap.containsKey(s.charAt(left)) && 
						   currWinMap.get(s.charAt(left))<reqMap.get(s.charAt(left))) 
					   count--;
					   
				   
				   left++;
				   
			   }
			   
			   
		  // }
		      
		   right++;
		   
		   
		   
		   
		   
	   }	   
		   
		   
	   
	   
	return result.length() == -1 ? "" : result;
	
        
    }
	
	
	
	

}
