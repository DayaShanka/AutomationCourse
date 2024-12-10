package GroupsDependsInvocationPriorities;

import org.testng.annotations.Test;

public class InvocationCount {

	@Test(invocationCount = 5) // run 5 times
	void t1() {
		System.out.println("test 1 passed");
	}

}
