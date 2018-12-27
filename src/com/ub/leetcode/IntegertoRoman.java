/*
https://leetcode.com/problems/integer-to-roman/
https://leetcode.com/problems/roman-to-integer/
*/
package com.ub.leetcode;

public class IntegertoRoman {

	public static void main(String[] args) {
		System.out.println(intToRoman(58));
		System.out.println(romanToInt("LVIII"));

	}

	
public static String intToRoman(int num) {
	
	
	String m[] = {"", "M", "MM", "MMM"}; 
    String c[] = {"", "C", "CC", "CCC", "CD", "D",  
                        "DC", "DCC", "DCCC", "CM"}; 
    String x[] = {"", "X", "XX", "XXX", "XL", "L",  
                        "LX", "LXX", "LXXX", "XC"}; 
    String i[] = {"", "I", "II", "III", "IV", "V",  
                        "VI", "VII", "VIII", "IX"};
    
    String th = m[num/1000];
    String hund = c[(num%1000)/100];
    String tens = x[(num%100)/10];
    String ones = i[(num%10)];
    
    
    String roman = th +hund+tens+ones;
    
    
	return roman;

	
    }

public static int romanToInt(String s) {
	
	int number=0;
	for(int i=0;i<s.length();i++) {
		int s1=value(s.charAt(i));
	
		if(i+1<s.length()) {
		
		int s2=value(s.charAt(i+1));
		if(s1>=s2) {
			
			number=number+s1;
		}else {
			number=number+s2-s1;
			i++;
		}
		}else {
			number=number+s1;
			i++;
		}
	}
	
	return number;
	
    
}


static int value(char r) 
{ 
    if (r == 'I') 
        return 1; 
    if (r == 'V') 
        return 5; 
    if (r == 'X') 
        return 10; 
    if (r == 'L') 
        return 50; 
    if (r == 'C') 
        return 100; 
    if (r == 'D') 
        return 500; 
    if (r == 'M') 
        return 1000; 
    return -1; 
}

}
