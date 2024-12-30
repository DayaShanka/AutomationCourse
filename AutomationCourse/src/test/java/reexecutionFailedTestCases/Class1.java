package reexecutionFailedTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Class1 {
	// @Test(retryAnalyzer = RetryFailedTestCases.class) // using this because want
	// to retry
	@Test
	public void test1() {
		System.out.println("method 1 is " + Thread.currentThread().getId());
		Assert.assertTrue(false);
	}

	@Test
	public void test2() {
		System.out.println("method 2 is " + Thread.currentThread().getId());
		Assert.assertTrue(false);
	}

	@Test
	public void test3() {
		System.out.println("method 3 is " + Thread.currentThread().getId());
	}

	@Test
	public void test4() {
		System.out.println("method 4 is " + Thread.currentThread().getId());
	}

	@Test
	public void test5() {
		System.out.println("method 5 is " + Thread.currentThread().getId());
	}
}