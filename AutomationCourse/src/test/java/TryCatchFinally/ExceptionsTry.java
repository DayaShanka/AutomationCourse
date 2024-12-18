package TryCatchFinally;

import java.util.Scanner;

public class ExceptionsTry {

	public static void main(String[] args) {

		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter any number");
			int i = sc.nextInt();
			System.out.println(100 / i);
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
