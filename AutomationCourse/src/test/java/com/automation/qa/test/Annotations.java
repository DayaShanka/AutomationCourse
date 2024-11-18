package com.automation.qa.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations {

	// before and after method will execute with each test
	@BeforeMethod
	void beforeM() {

		System.out.println("before metod..");
	}

	@AfterMethod
	void afterM() {
		System.out.println("after method..");
	}

	@BeforeTest
	void beforeT() {
		System.out.println("before test...");
	}

	@AfterTest
	void afterT() {
		System.out.println("after test...");
	}

	@Test(priority = 2)
	void test1() {
		System.out.println("test1 executed..");
	}

	@Test(priority = 4)
	void test2() {
		System.out.println("test2 executed..");
	}

	@Test
	void test3() {
		System.out.println("test3 executed..");
	}

	@BeforeSuite
	void beforeS() {
		System.out.println("before suit..");
	}

	@AfterSuite
	void afterS() {
		System.out.println("after suit...");
	}

//
	public class annotation2 {

		@Test(priority = 1)
		void test4ofclass2() {
			System.out.println("test 4 of class 2");
		}

		@BeforeTest
		void class2beforetest() {
			System.out.println("class 2 before test");
		}
	}
}
