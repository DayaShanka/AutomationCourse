package com.qa.string;

public class Program1 {

	public static void main(String[] args) {
		// Approach 1
		String s = "Welcome Home"; // start with 0 index and last of the value start with -1 (Welcome
									// Home)-(-1,-2,-3...length)
		String rev = "";

		for (int i = s.length() - 1; i >= 0; i--) {
			// System.out.println(i); // geting index last to first
			System.out.println(s.charAt(i)); // printing each of index value
			rev = rev + s.charAt(i); // concat and store in rev var

		}
		System.out.println("After Reverse: " + rev);

		// Approach 2
		StringBuffer sb = new StringBuffer("Welcome Home");
		String reversed = new StringBuilder(sb).reverse().toString(); // another
		// method
		StringBuffer revs = sb.reverse();
		System.out.println("After Reverse with String Buffer : " + reversed);

		// Approach 3
		StringBuilder sbr = new StringBuilder("Welcome Home");
		StringBuilder revse = sbr.reverse();
		System.out.println("After Reverse with String Builder : " + revse);

	}

}
