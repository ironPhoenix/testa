package com.hans.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
	public static void main(String[] args) {
		/*String txtString = "10213asfas hasnf 10032 asdfa 12 1231254 fsdafsd";
		String regexString = "\\d+";
		System.out.println(FreeMatcher.anyOf(regexString).replaceFrom(
				txtString, new FreeReplacement() {
					public String replacementMethod(String original) {
						
						char[] charArray = original.toCharArray();
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

					
				}));*/
		/*
		 * StringBuilder sb = new StringBuilder("adfasdf"); sb.insert(0, 'z');
		 * System.out.println(sb);
		 */
		String regexA = "\\d";
		String regexB = "[a-zA-Z]";
		Pattern p1 = Pattern.compile(regexA);
		Pattern p2 = Pattern.compile(regexB);
		System.out.println(Pattern.matches(p1.pattern()+"|"+p2.pattern(), "d"));
		

	}
}
