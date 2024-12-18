package com.automation.qa.test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollSlowlyByLoop {

	public static void main(String[] args) throws InterruptedException {

		// Set up WebDriver
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.kapruka.com/online/electronics/price/mobile_phones"); // Replace with your target URL

		// JavaScript Executor
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scroll page in steps
		for (int i = 0; i < 1000; i += 50) { // Adjust "1000" for total height, "50" for step size
			js.executeScript("window.scrollBy(0, 50)"); // Scroll down by 50 pixels
			Thread.sleep(100); // Pause to make the scrolling appear smooth
		}
		System.out.println("Scrolling Completed..");

		// Close browser
		driver.quit();
	}
}
