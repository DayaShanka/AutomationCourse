package com.qa.string;

public class CountVowelsandConsonants {
	public static void main(String[] args) {
		String s = "hEllo world";
		s = s.toLowerCase(); // converting lower case for ignore case sensitive
		int vowels = 0, consonants = 0;
//		for (char c : s.toCharArray()) {  //enhanced loop
//			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
//				vowels++;
//			} else if (c >= 'a' && c <= 'z') {
//				consonants++;
//			}
//		}
//Approach 2
		for (int i = 0; i < s.length(); i++) {
			char cr = s.charAt(i);
			if (cr == 'a' || cr == 'e' || cr == 'i' || cr == 'o' || cr == 'u') {
				vowels++;
			} else if (cr >= 'a' && cr <= 'z') {
				consonants++;
			}
			// System.out.println(cr);
		}

		System.out.println("Main String: " + s);
		System.out.println("Vowels Count: " + vowels); // Output: Vowels: 3
		System.out.println("Consonants Count: " + consonants); // Output: Consonants: 7
	}
}
