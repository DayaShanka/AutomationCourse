package com.qa.javaarrayprograms;

public class MultidimensionalArray {

	public static void main(String[] args) {
		// Multi dimensional arrays
		// Approach 1
		int a[][] = new int[2][3]; // 2 row and 3 columns
		a[0][0] = 100;
		a[0][1] = 200;
		a[0][2] = 300;
		a[1][0] = 400;
		a[1][1] = 500;
		a[1][2] = 600;
		// System.out.println(a[0][1]);

		for (int r = 0; r < a.length; r++) {
			for (int c = 0; c < a[r].length; c++) {
				System.out.println(a[r][c]);
			}
		}

		// Approach 2
		int x[][] = { { 100, 300 }, { 500, 600 } };

		// Outer loop to iterate over the rows
		for (int row = 0; row < x.length; row++) {
			// Inner loop to iterate over the columns in the current row
			for (int col = 0; col < x[row].length; col++) {
				System.out.print(x[row][col] + " ");
			}
			System.out.println(); // Move to the next line after each row
		}
	}
}
