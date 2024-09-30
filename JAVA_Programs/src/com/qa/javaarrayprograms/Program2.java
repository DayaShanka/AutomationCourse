package com.qa.javaarrayprograms;

public class Program2 {

	public static void main(String[] args) {

		// Find duplicate element from an array how many times repeated
		int arr[] = { 10, 20, 10, 30, 40, 10 };
		int duplicate_value = 10;
		int count = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == duplicate_value) {
				count++;
			}
		}
//Enhanced loop
//		for (int array : arr) {
//			if (array == duplicate_value) {
//				count++;
//			}
//		}
		System.out.println("Count of repeated value is: " + count);
		System.out.println("Duplicate Value is: " + duplicate_value);
	}

}
