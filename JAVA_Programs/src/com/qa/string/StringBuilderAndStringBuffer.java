package com.qa.string;

public class StringBuilderAndStringBuffer {

	public static void main(String[] args) {

		StringBuffer s = new StringBuffer("welcome"); // mutable

		System.out.println(s.append(" hello")); // concat
		System.out.println(s.charAt(0));
		System.out.println("substring: " + s.substring(0, 5));
		StringBuffer rev = s.reverse();
		System.out.println(rev);

		StringBuilder s1 = new StringBuilder("welcome"); // mutable

		System.out.println(s1.append(" hello")); // concat
		System.out.println(s1.charAt(0));
		StringBuilder revs = s1.reverse();
		System.out.println("After reverse :" + revs); // reversing the string with inbuild method
		System.out.println(s1.toString());

	}

}
