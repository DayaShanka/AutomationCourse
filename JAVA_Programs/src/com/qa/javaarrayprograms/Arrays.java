package com.qa.javaarrayprograms;

public class Arrays {

	public static void main(String[] args) {
		// single dimensional array
		// Approach 1
		int a[] = new int[5]; // 5 memory allocate in the array
		a[0] = 10;
		a[1] = 20;
		a[2] = 30;
		a[3] = 40;
		System.out.println(a[2]);
		System.out.println("Length of an array: " + a.length);

		// Approach 2
		int x[] = { 100, 200, 300, 400, 500, 600 }; //
		for (int i = 0; i <= x.length - 1; i++) {
			System.out.println(x[i] + " ");
		}
		// enhanced for loop or each for loop
//		for (int a1 : x) {
//			System.out.println(a1);
//		}

		// System.out.println(x[3]);
		// System.out.println(x.length);
	}

}
