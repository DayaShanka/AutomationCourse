package GroupsDependsInvocationPriorities;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnM {

	@Test()
	void openUrl() {
		Assert.assertTrue(true);
		System.out.println("url open");
	}

	@Test(dependsOnMethods = { "openUrl" }) // depending on "openUrl", if the test fail then it will skip
	void login() {
		Assert.assertTrue(false);
		System.out.println("login");
	}

	@Test(dependsOnMethods = { "login" })
	void signup() {
		System.out.println("signup");
	}

}
