package com.hans.test;

import com.hans.freeregex.FreeMatcher;
import com.hans.freeregex.FreeType;

public class Test {
	public static void main(String[] args) {
		String txtString = "ew10213asfas hasnf 10032 asdfa 12 1231254 ";
		String regexString = "\\d+";
		System.out.println(FreeMatcher.anyOf(regexString).replaceFrom(
				txtString, new FreeType() {
					public String replace(String A) {
						
						char[] charArray = A.toCharArray();
						StringBuilder sb = new StringBuilder("");
						int j = charArray.length;
						for (int i = 0; j > 0;i++) {
							if (i!=0&&i % 3 == 0) {
								sb.insert(0, ',');
							} 
								sb.insert(0, charArray[j - 1]);
								j--;
								
							
						}
						System.out.println(sb);
						return sb.toString();
					}
				}));
		/*
		 * StringBuilder sb = new StringBuilder("adfasdf"); sb.insert(0, 'z');
		 * System.out.println(sb);
		 */

	}
}
