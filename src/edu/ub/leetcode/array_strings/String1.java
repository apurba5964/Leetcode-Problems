package edu.ub.leetcode.array_strings;

public class String1 {
	public static void main(String[] args) {
		
		String str = "abcd";
		
		//permutataions(str,"");
		permutations1(str, 0, str.length()-1);
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
	
	

}
