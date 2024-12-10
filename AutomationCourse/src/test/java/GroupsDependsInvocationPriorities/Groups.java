package GroupsDependsInvocationPriorities;

import org.testng.annotations.Test;

public class Groups {

	@Test(groups = "sanity")
	void g1() {
		System.out.println("g1 executed");
	}

	@Test(groups = "sanity")
	void g2() {
		System.out.println("g2 executed");
	}

	@Test(groups = "smoke")
	void g3() {
		System.out.println("g3 executed");
	}

}
