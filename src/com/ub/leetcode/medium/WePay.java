package com.ub.leetcode.medium;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javafx.util.converter.LocalDateStringConverter;

public class WePay {

	public static void main(String[] args) {
	
		System.out.println(ada(1932));
		
	/*	ArrayList<Integer> input = new ArrayList<>();
		input.add(100);
		input.add(100);
		input.add(100);
		input.add(100);
		input.add(100);
		input.add(100);
		input.add(100);
		input.add(100);
		
		System.out.println(alert(input, 2, (float) 1.5));*/
	}
	
	
	public static int ada(int year) {

		int x = 0 ;
		if(year>1970) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, Calendar.OCTOBER);
		cal.setFirstDayOfWeek(Calendar.SUNDAY);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
		cal.set(Calendar.WEEK_OF_MONTH,2);
		return cal.getTime().getDate();
		}
		else {
			
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, 1970);
			
			cal.set(Calendar.MONTH, Calendar.OCTOBER);
			cal.setFirstDayOfWeek(Calendar.SUNDAY);
			cal.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
			cal.set(Calendar.WEEK_OF_MONTH,2);
			x= cal.getTime().getDate();
			System.out.println(x);
			int diff = 1970-year; 
			for(int i=1;i<=diff;i++) {
				boolean flag = false;
		        if(year % 400 == 0)
		        {
		            flag = true;
		        }
		        else if (year % 100 == 0)
		        {
		            flag = false;
		        }
		        else if(year % 4 == 0)
		        {
		            flag = true;
		        }
		        else
		        {
		            flag = false;
		        }
		        if(flag)
		        {
		        	if(x>1)
		            x = x-2;
		        	else {
		        		x = 30;
		        		x = x-2;
		        	}
		        }
		        else
		        {
		        	if(x>1)
		            x = x-1;
		        	else {
		        		x = 30;
		        		x = x-1;
		        	}
		        	
		        }
				
			}
			
			
			
			/*LocalDateStringConverter date = new LocalDateStringConverter();
			date.
			System.out.println(date);
		
			
			Calendar cal = new GregorianCalendar();
			
			cal.set(Calendar.YEAR, year-1970);
			cal.set(Calendar.MONTH, Calendar.OCTOBER);
			cal.setFirstDayOfWeek(Calendar.SUNDAY);
			cal.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
			cal.set(Calendar.WEEK_OF_MONTH,2);
			return cal.getTime().getDate();*/
		}
		//return 0;
		return x;
    }
	
	
	
	static boolean alert(List<Integer> inputs, int windowSize, float allowedIncrease) {

		
		ArrayList<Boolean> boolList =  new ArrayList<>();
		
		int count=0;
		
		for(int i=0;i<inputs.size()-windowSize;i++) {
			int sum = 0;
			int max = 0;
			for(int j=i;j<windowSize;j++) {
				
				sum+=inputs.get(j);
				if(inputs.get(j)>max)
					max=inputs.get(j);
				
			}
			float avg = sum/windowSize;
			
			
			
			if(max > (allowedIncrease * avg))
				boolList.add(true);
			else
				boolList.add(false);
				
		}
		
		for (Boolean boolean1 : boolList) {
			
			if(boolean1)
				count++;
		}
		
		if(count==boolList.size())
			return true;
		else if(count > 1)
			return true;
		else
			return false;
		
		
		
		
		

		
    }
	
	
	
	
	
	
}
