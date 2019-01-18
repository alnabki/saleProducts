package com.mohamad.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternDemo {
	
	   
	   private static  String INPUT ;
	   private static  String REPLACE;

	   public static String main( String REGEX) {
	      Pattern pattern = Pattern.compile(Pattern.quote(REGEX));
	      
	      // get a matcher object
	      Matcher matcher = pattern.matcher(INPUT); 
	      INPUT = matcher.replaceAll(REPLACE);
	      System.out.println(INPUT);
		return INPUT;
	   }

}
