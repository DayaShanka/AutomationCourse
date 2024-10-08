package com.qa.string;

public class CheckForPalindrome {

	public static void main(String[] args) {

		String s = "otto"; // start with 0 index and last of the value start with -1 (Welcome
		// Home)-(-1,-2,-3...length)
		String rev = "";

		for (int i = s.length() - 1; i >= 0; i--) {
			rev = rev + s.charAt(i); // concat and store in rev var
		}
		// another method
		boolean isPalindrome = s.equals(new StringBuilder(s).reverse().toString());

		if (s.equals(rev)) {
			System.out.println("This is Palindrome");
		} else {
			System.out.println("This is not Palindrome");
		}

		System.out.println("After Reverse: " + rev);
		System.out.println(isPalindrome);
	}

}
