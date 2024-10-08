package com.qa.string;

import java.util.Arrays;

public class AnagramCheck { // they contain the same characters in a different order
	public static void main(String[] args) {
		String s1 = "listen";
		String s2 = "Silent";
		s1 = s1.toLowerCase(); // convert in lower case
		s2 = s2.toLowerCase();
		boolean isAnagram = areAnagrams(s1, s2);
		if (isAnagram == true) { // checking is true or false
			System.out.println("Anagram");
		} else {
			System.out.println("Not Anagram");
		}
		System.out.println(isAnagram); // Output: true
	}

	public static boolean areAnagrams(String s1, String s2) {
		char[] arr1 = s1.toCharArray();
		char[] arr2 = s2.toCharArray();
		if (s1.length() != s2.length()) { // Check if lengths are different
			return false;
		}
		Arrays.sort(arr1);
		Arrays.sort(arr2);

		return Arrays.equals(arr1, arr2);
	}
}
