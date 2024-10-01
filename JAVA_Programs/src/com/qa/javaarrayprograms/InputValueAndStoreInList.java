package com.qa.javaarrayprograms;

import java.util.Arrays;
import java.util.Scanner;

public class InputValueAndStoreInList {

	public static void main(String[] args) {

		int arr[] = new int[4]; // allocate 4 memory
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Enter a value of index " + i + ":");
			arr[i] = sc.nextInt();
			System.out.println("Filling Each of Index as per Value Entered by User" + Arrays.toString(arr));

		}

	}

}
