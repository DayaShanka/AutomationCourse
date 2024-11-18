package com.automation.qa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {

	int a = 10;
	int b = 10;

	SoftAssert sa = new SoftAssert();

	@Test
	void m1() {
		sa.assertEquals(a, b);
		System.out.println("m1 executed..");

	}

	@Test
	void m2() {
		sa.assertEquals(4, 6);
		System.out.println("m2 executed..");

		sa.assertAll();
		System.out.println("m3 executed..");

	}

	@Test
	void m4() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		boolean textDispla = driver.findElement(By.xpath("//h1[normalize-space()='Automation Testing Practice']"))
				.isDisplayed();
		sa.assertTrue(textDispla);
		System.out.println("text visible");

		sa.assertAll();
	}

	@Test
	void m5() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.findElement(By.className("wikipedia-search-input")).sendKeys("java" + Keys.ENTER);
//		Actions ac = new Actions(driver);
//		ac.keyDown(Keys.ENTER).perform();

	}
}
