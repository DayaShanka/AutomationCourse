package com.qa.javaarrayprograms;

public class ReverseOrder {

	public static void main(String[] args) {
		// Array to be reversed
		int arr[] = { 100, 200, 300, 400, 500 };

		// Printing the original array
		System.out.println("Original Array: ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

		// Printing the array in reverse order
		System.out.println("Reverse Order:");
		for (int i = arr.length - 1; i >= 0; i--) {
			System.out.print(arr[i] + " ");
		}
	}
}
