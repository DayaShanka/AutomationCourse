package com.automation.qa.test;

public class Polymorphism {

	// overloading(we can create many method with same name but )
	int a, b = 10;

	void sum() {

	}

	void sum(int a, int b) {
		System.out.println(a + b);

	}

	void sum(double a, int b) {
		System.out.println(a * b);
	}

	void sum(int a, double b) {
		System.out.println(a / b);
	}

	public static void main(String[] args) {

		Polymorphism p = new Polymorphism();
		// As per use variable value the method will call accordingly
		p.sum(10, 5);

	}

}
