package com.automation.qa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClick {

	public static void main(String[] args) throws InterruptedException {

		// Initialize WebDriver
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); // Maximize the browser window

		// Open the webpage
		driver.get("https://www.softwaretestingmentor.com/automation-practice-page-right-click-demo/");

		// Locate the element for right-clicking
		WebElement rightClickElement = driver.findElement(By.xpath("//h2[normalize-space()='Right Click Demo']"));

		// Initialize Actions class for performing mouse actions
		Actions action = new Actions(driver);

		// Add a brief wait
		Thread.sleep(2000);

		// Perform right-click (context-click) on the element
		action.contextClick(rightClickElement).perform();

		// Add a brief wait
		Thread.sleep(2000);

		// Locate the 'Follow Us' option after right-click
		WebElement followUsOption = driver.findElement(By.xpath("//a[normalize-space()='Follow Us']"));

		// Move to the 'Follow Us' option and click
		action.moveToElement(followUsOption).click().perform();

		// Close the browser after a short wait
		Thread.sleep(3000);

		driver.quit();
	}
}
