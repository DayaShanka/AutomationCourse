package com.zepto.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zepto.utilities.CommonUtills;

public class FailedTestCaseScreenShort {

	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {

		driver = new ChromeDriver();
		driver.get("https://allendigitaluat.thinkexam.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void myTest() {

		String title = driver.getTitle();
		Assert.assertEquals(title, "Allen Digital");
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {

		if (ITestResult.FAILURE == result.getStatus()) {
			String testName = result.getName();

//			File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//			FileUtils.copyFile(source, new File("./screenshort/" + testName + ".png"));

			CommonUtills.takeScreenshort(driver, testName);

		}

	}
}
