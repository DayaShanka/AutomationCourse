package TryCatchFinally;

import java.util.Scanner;

//we can not add try block only whithout add catch or finally
public class TryFinally {

	public static void main(String[] args) {

		String s = "100";
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("enter string");
			s = sc.nextLine();
			Integer.parseInt(s);
			System.out.println("Entered value: " + s);
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		} finally { // finally will be add only once with try block
			System.out.println("finally executed");
		}
	}

}
