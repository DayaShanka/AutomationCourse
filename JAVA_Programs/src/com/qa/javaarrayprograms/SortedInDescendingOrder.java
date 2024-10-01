package com.qa.javaarrayprograms;

import java.util.Arrays;
import java.util.Collections;

public class SortedInDescendingOrder {

	public static void main(String[] args) {

		// Sorting an array in descending order
		Integer arr[] = { 100, 500, 400, 600, 200 };

		// Printing the original array
		System.out.println("Original Array: " + Arrays.toString(arr));

		// Sorting the array in descending order
		Arrays.sort(arr, Collections.reverseOrder());

		// Printing the sorted array
		System.out.println("Sorted Array (Descending): " + Arrays.toString(arr));

		// Printing each element of the sorted array
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
