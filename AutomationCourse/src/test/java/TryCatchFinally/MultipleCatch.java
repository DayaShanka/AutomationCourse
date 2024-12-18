package TryCatchFinally;

import java.util.Scanner;

public class MultipleCatch {

	public static void main(String[] args) {
		int[] arr = new int[4]; // Declare an array of size 4
		Scanner sc = new Scanner(System.in);

		try {
			System.out.print("Enter an integer value for the array index: ");
			int index = sc.nextInt(); // Read an integer for the array index

			System.out.print("Enter a value to store at index " + index + ": ");
			arr[index] = sc.nextInt(); // Store the input value in the array

			System.out.println("Value at index " + index + ": " + arr[index]);
		} catch (ArrayIndexOutOfBoundsException e) { // we can add catch block multiple time with single try block
			System.out.println(
					"Error: Array index is out of bounds. Please enter a valid index." + "-->" + e.getMessage());
		} catch (NumberFormatException e) {
			System.out.println("Error: Invalid number format. Please enter an integer." + "-->" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error: An unexpected error occurred: " + e.getMessage());

		}
	}
}
