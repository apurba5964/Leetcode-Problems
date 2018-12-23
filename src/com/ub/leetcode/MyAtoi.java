package com.ub.leetcode;

public class MyAtoi {

	public static void main(String[] args) {
		
		System.out.println(myAtoi("-87"));
		
		
	}
	public static int myAtoi(String str) {
		
		int number=0,result=0,sign=1;
		
		if(str.length()==0)
			return 0;
		
		if(str.charAt(0) <= '0' || str.charAt(0) >= '9')
			if(str.charAt(0)!=' ' && str.charAt(0)!='-')
			   return 0;
		
		for(int i=0;i<str.length();i++) {
			
			
			if(str.charAt(i)!=' ') {
				
				if(str.charAt(i) == '-' || str.charAt(i) == '+'){
		            sign = str.charAt(i) == '-'?-1 : 1;
		            
		        }else {
		        	
		            if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
		        	number=str.charAt(i)-'0';
				    result=result*10+number;
				    
				    if(result > Integer.MAX_VALUE){
		                if(sign ==1)
		                    return Integer.MAX_VALUE;
		                else
		                    return Integer.MIN_VALUE;
		            }
				    
		            }
		        }
				
			    
			}
		}
		
		
		
		return result*sign;

	}

}
