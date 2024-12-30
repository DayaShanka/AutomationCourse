package GroupsDependsInvocationPriorities;

import org.testng.annotations.Test;

public class InvocationCountWithEnabled {

	// ForignoringthetestcaseWecanuseonemethodcalledEnabled
	// Whenweuseenabled=false,Itwillskiptheparticulartestcase

	@Test(invocationCount = 5, enabled = false) // it will skip when passed as false and true for enabled
	void t1() {
		System.out.println("test 1 passed");
	}

	@Test
	void t2() {
		System.out.println("test 2 passed");
	}
}
