package GroupsDependsInvocationPriorities;

import org.testng.annotations.Test;

public class Priorities {

	@Test(priority = 0) // execute first
	void p1() {
		System.out.println("p1 executed");
	}

	@Test(priority = 2) // execute five
	void p2() {
		System.out.println("p2 executed");
	}

	@Test(priority = 1) // execute fourth
	void p3() {
		System.out.println("p3 executed");
	}

	@Test(priority = 1) // execute third(it will go with alphabet order of test method if priority
						// match)
	void d4() {
		System.out.println("d4 executed");
	}

	@Test // execute second
	void p5() {
		System.out.println("p5 executed");
	}

}
/*
 * Execution will be this order.. p1 executed p5 executed d4 executed p3
 * executed p2 executed
 */
