package com.qa.javaarrayprograms;

public class Program1 {

	public static void main(String[] args) {

		// Search element from an array
		int arr[] = { 10, 20, 30, 40, 50 };
		int search_value = 30;
		boolean status = false;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == search_value) {
				System.out.println("Element Found: " + arr[i]);
				status = true;
				break;
			}

		}
		if (status == false) {
			System.out.println("Element not Found");
		}

	}

}
