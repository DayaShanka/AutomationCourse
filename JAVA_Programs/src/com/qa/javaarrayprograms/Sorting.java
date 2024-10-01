package com.qa.javaarrayprograms;

import java.util.Arrays;

public class Sorting {

	public static void main(String[] args) {

		// Sorting an array
		int arr[] = { 100, 500, 400, 600, 200 };

		// Printing the original array
		System.out.println("Original Array: " + Arrays.toString(arr));

		// Sorting the array in ascending order
		Arrays.sort(arr);

		// Printing the sorted array
		System.out.println("Sorted Array: " + Arrays.toString(arr));

		// Printing each element of the sorted array in DESC
		for (int i = arr.length - 1; i >= 0; i--) {
			System.out.println(arr[i]);

		}

	}
}
