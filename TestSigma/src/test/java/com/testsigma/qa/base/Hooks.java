package com.testsigma.qa.base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Hooks extends Base {
	@BeforeSuite(alwaysRun = true)
	public void setUp() throws Exception {
		initilizeBrowser("chrome");
		setUpWait(driver, 20);
	}

	@AfterSuite(alwaysRun = true)
	public void cleanUp() {
		if (driver != null) {
//            driver.quit(); // Uncomment to close the WebDriver instance after the Test method is completed
		}
	}
}
