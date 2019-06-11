package com.interview.Hackerrank;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class ConvertingStringtoGivenPhoneNumberFormat {

	public static void main(String[] args) {

		String S = "555372654";//555372654 //0 - 22 1985--324
		String[] words = S.split("[- ]");
		
		S = S.replaceAll("\\s+","").replaceAll("-", "");
		
		System.out.println(S);
		
		StringBuilder sb = new StringBuilder();
		String dash = "-";
		for(int i = 0; i< S.length();) {
			if(i+2 < S.length() && ((S.length() - i) > 4 )  || (S.length() - i) ==3 ){
				sb.append(S.charAt(i))
				.append(S.charAt(i+1))
				.append(S.charAt(i+2)).append(dash);
				i = i+3;
			}else if(i+1 < S.length() ) {
				sb.append(S.charAt(i))
				.append(S.charAt(i+1)).append(dash);
				i = i+2;
			}
			
		}
		String str = sb.toString();
		
		System.out.println(str);
		System.out.println(str.substring(0, str.toString().length()-1));
		
		//System.out.println(Arrays.toString(words));
		
		
	}

}
