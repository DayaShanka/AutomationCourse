package com.automation.qa.test;

public class Overloadings {

	Overloadings() {
		System.out.println("constructor overloading");
	}

	Overloadings(int a) {
		System.out.println("constructor overloading with parameter");
	}

	int a, b;

	void sum() {
		System.out.println(a + b);
	}

	int sum(int x) {
		this.a = x;
		System.out.println(a);
		return x;
	}

	void sum(int x, int y) {
		a = x;
		b = y;
		System.out.println(a * b);
	}

	void display() {
		a = 100;
		b = 200;
		System.out.println(a / b);
	}

	void main() {
		System.out.println("main another");
	}

	void main(String name) {
		System.out.println("main another with input");
	}

	public static void main(String[] args) {

		Overloadings obj = new Overloadings();// default
		Overloadings obj1 = new Overloadings(2); // parameterized construtor
		obj.sum();
		obj.sum(100);
		obj.sum(40, 40);
		obj.main(); // overload main method also

	}

}
