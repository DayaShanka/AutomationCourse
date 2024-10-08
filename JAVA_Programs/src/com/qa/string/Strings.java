package com.qa.string;

import java.util.Arrays;

public class Strings {

	public static void main(String[] args) {

		String s = new String("welcome"); // immutable
		String s1 = "h  ello";
		String s2 = "abc@gmail";
		String s3 = "  welcome  ";
		System.out.println(s.length());
		System.out.println(s.charAt(2));
		System.out.println(s.concat(" hello"));
		System.out.println(s.equals("Welcome")); //// case sensitive
		System.out.println(s.replace("e", "q"));
		System.out.println(s3.trim());
		System.out.println(s1.replace("  ", ""));
		String[] a = s2.split("@"); // store in array
		System.out.println(Arrays.toString(a));
		System.out.println(a[0]); // printing indexing wise
		System.out.println(a[1]);
		System.out.println(s.equalsIgnoreCase("Welcome")); // case sensitive ignored
		s.contains("Welcome");
	}

}
