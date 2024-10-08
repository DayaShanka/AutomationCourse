package com.qa.string;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {
	public static void main(String[] args) {

		// Approach 1
		String s = "hello";
		String result = removeDuplicates(s);
		System.out.println(result); // Output: "helo"
	}

	public static String removeDuplicates(String s) {
		Set<Character> set = new LinkedHashSet<>();
		for (char c : s.toCharArray()) {
			set.add(c);
		}
		StringBuilder sb = new StringBuilder();
		for (char c : set) {
			sb.append(c);
		}
		return sb.toString();
	}
}
//Approach 2
/*
 * public class RemoveDuplicates { public static void main(String[] args) {
 * String input = "programming"; String result = removeDuplicates(input);
 * System.out.println("Original String: " + input);
 * System.out.println("String after removing duplicates: " + result); }
 * 
 * public static String removeDuplicates(String str) { StringBuilder result =
 * new StringBuilder(); boolean[] seen = new boolean[256]; // To track
 * characters already seen
 * 
 * for (int i = 0; i < str.length(); i++) { char c = str.charAt(i); if
 * (!seen[c]) { // If character is not already seen result.append(c); seen[c] =
 * true; // Mark the character as seen } }
 * 
 * return result.toString(); } }
 */