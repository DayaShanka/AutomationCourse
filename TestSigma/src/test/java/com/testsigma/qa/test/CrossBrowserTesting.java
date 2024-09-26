package com.testsigma.qa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.testsigma.qa.base.Base;

public class CrossBrowserTesting extends Base {
	WebDriver driver;

	@Test
	@Parameters({ "URL", "BrowserType" })
	public void accessTestProjectBlog(String url, String browserType) {
		if (browserType.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserType.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else {
			System.out.println("Not A Valid Browser");
		}

		driver.manage().window().maximize();
		driver.get(url);

		System.out.println("\n" + "Open " + browserType);
		System.out.println("   " + driver.getTitle());
		System.out.println("   " + driver.findElement(By.cssSelector("div.join-us h3")).getText());
		System.out.println("Close " + browserType + "\n");

		driver.quit();
	}
}