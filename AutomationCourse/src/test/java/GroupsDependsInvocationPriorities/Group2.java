package GroupsDependsInvocationPriorities;

import org.testng.annotations.Test;

class Group2 {

	@Test(groups = "smoke")
	void g4() {
		System.out.println("g4 executed");
	}

	@Test(groups = { "smoke", "sanity", "functional" })
	void g5() {
		System.out.println("g5 executed");
	}
}
