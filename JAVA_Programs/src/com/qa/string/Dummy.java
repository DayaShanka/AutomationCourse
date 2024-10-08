package com.qa.string;

import java.util.Arrays;

public class Dummy {

	public static void main(String[] args) {

		String s1 = "madam";
		String s2 = "mamda";
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();
		boolean isanagram = areAnagram(s1, s2);
		System.out.println(isanagram);

	}

	public static boolean areAnagram(String s1, String s2) {
		char[] arr1 = s1.toCharArray();
		char[] arr2 = s2.toCharArray();
		if (arr1.length != arr2.length) {
			return false;

		}
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		return Arrays.equals(arr1, arr2);

	}

}
