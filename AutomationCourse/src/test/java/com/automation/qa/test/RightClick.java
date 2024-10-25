package com.automation.qa.test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RightClick {

	public static void main(String[] args) throws InterruptedException {

		// Initialize WebDriver
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); // Maximize the browser window

		// Open the webpage
		driver.get("https://www.softwaretestingmentor.com/automation-practice-page-right-click-demo/");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Locate the element for right-clicking
		WebElement rightClickElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[@class='wp-block-columns is-layout-flex wp-container-core-columns-is-layout-1 wp-block-columns-is-layout-flex']")));

		// Initialize Actions class for performing mouse actions
		Actions action = new Actions(driver);

		// Add a brief wait
		Thread.sleep(2000);

		// Perform right-click (context-click) on the element
		action.contextClick(rightClickElement).build().perform();

		// Add a brief wait

		// Locate the 'Follow Us' option after right-click
		WebElement followUsOption = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Follow Us']")));

		// Move to the 'Follow Us' option and click
		action.moveToElement(followUsOption).click().perform();

		// Handle multiple windows
		Set<String> multiWindowIds = driver.getWindowHandles();
		System.out.println("All window IDs: " + multiWindowIds); // Print IDs of both windows

		// Convert the set of window IDs to a list
		List<String> windowIds = new ArrayList<>(multiWindowIds);

		// Switch to the new window (child window)
		String childWindowId = windowIds.get(1);
		driver.switchTo().window(childWindowId);
		System.out.println("Switched to child window with ID: " + childWindowId);

		// Perform any further actions on the child window (if needed)
		// ...

		// Close the child window
		Thread.sleep(3000);
		driver.close();

		// Switch back to the parent window
		driver.switchTo().window(windowIds.get(0));

		// Close the browser
		driver.quit();
	}
}
