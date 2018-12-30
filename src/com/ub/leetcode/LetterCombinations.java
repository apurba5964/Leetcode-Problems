package com.ub.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinations {

	public static void main(String[] args) {
		System.out.println(letterCombinations("23"));

	}

	public static List<String> letterCombinations(String digits) {

		HashMap<Character, char[]> map = new HashMap<>();
		map.put('0', new char[] {});
		map.put('1', new char[] {});
		map.put('2', new char[] { 'a', 'b', 'c' });
		map.put('3', new char[] { 'd', 'e', 'f' });
		map.put('4', new char[] { 'g', 'h', 'i' });
		map.put('5', new char[] { 'j', 'k', 'l' });
		map.put('6', new char[] { 'm', 'n', 'o' });
		map.put('7', new char[] { 'p', 'q', 'r', 's' });
		map.put('8', new char[] { 't', 'u', 'v' });
		map.put('9', new char[] { 'w', 'x', 'y', 'z' });
		ArrayList<String> result = new ArrayList<>();

		if (digits == null || digits.equals(""))
			return result;
		
		
		StringBuilder sb=new StringBuilder();
		createLetterCombinations(digits,sb,map,result);

		return result;

	}

	private static void createLetterCombinations(String digits, StringBuilder sb, HashMap<Character, char[]> map,
			ArrayList<String> result) {
		
		if(sb.length()==digits.length()) {
			result.add(sb.toString());
			return;
		}
		
		for (char ch : map.get(digits.charAt(sb.length()))) {
			 sb.append(ch);
			 createLetterCombinations(digits, sb, map, result);
			 sb.deleteCharAt(sb.length()-1); 
			
		}
		
	}

}
