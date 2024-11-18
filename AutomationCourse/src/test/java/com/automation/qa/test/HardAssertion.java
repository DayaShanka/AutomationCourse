package com.automation.qa.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertion {

	String expectedName = "java";
	String actualName = "java";

	@Test
	void m1() {
		Assert.assertEquals(expectedName, actualName);
		System.out.println("m1 executed..");
	}

	@Test
	void m2() {
		Assert.assertTrue(false);

		System.out.println("getting true..");
	}

	@Test
	void m3() {
		Assert.assertFalse(true);
		System.out.println("getting false..");
	}

	@Test
	void m4() {
		Assert.assertNotEquals(expectedName, actualName);
		System.out.println("not matched..");
	}

}
