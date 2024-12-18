package com.automation.qa.test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollSlowlyUpToDown {
	public static void main(String[] args) throws InterruptedException {
		// Set up WebDriver
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Open the webpage
		driver.get("https://www.kapruka.com/online/electronics/price/mobile_phones"); // Replace with the URL of the
																						// target webpage

		// Cast the driver to JavascriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Get the total height of the webpage
		long pageHeight = (long) js.executeScript("return document.body.scrollHeight");
		System.out.println("Page Height: " + pageHeight);

		// Scroll the page in increments
		int scrollStep = 100; // Pixels to scroll per step
		int scrollPause = 200; // Pause between scrolls in milliseconds

		for (int currentPosition = 0; currentPosition < pageHeight; currentPosition += scrollStep) {
			js.executeScript("window.scrollBy(0, arguments[0]);", scrollStep);
			Thread.sleep(scrollPause); // Pause to create a "slow" scrolling effect
		}

		// Optional: Scroll back to the top
		js.executeScript("window.scrollTo(0, 0);");

		System.out.println("Scrolling completed.");
		driver.quit();
	}
}
