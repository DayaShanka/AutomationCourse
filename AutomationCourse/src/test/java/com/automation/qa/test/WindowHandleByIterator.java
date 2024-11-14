package com.automation.qa.test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowHandleByIterator {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Click on an hotel element to open new window
		driver.findElement(By.xpath("//span[@class='allcircle circletwo']")).click();
		// Get all window handles
		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> it = windowIds.iterator();

		String parentId = it.next();
		String childId = it.next();
		System.out.println("window ids: " + parentId + " " + childId);
		// Switch to child window
		driver.switchTo().window(childId);
		Thread.sleep(2000);
		try {
			// Locate and click on 'Bus Tickets' link in the child window
			WebElement busTicketsLink = driver.findElement(By.xpath("//a[@title='Bus Tickets']"));
			busTicketsLink.click();
		} catch (NoSuchElementException e) {
			System.out.println("Bus Tickets link not found: " + e.getMessage());
		}

		// Get the updated set of window handles after clicking Bus Tickets
		windowIds = driver.getWindowHandles();
		it = windowIds.iterator();

		// Skip parent and child and locate sub-child window
		it.next(); // parent
		it.next(); // child
		System.out.println("again window ids: " + parentId + " " + childId);
		String subChildId = it.next();

		// Switch to sub-child window
		driver.switchTo().window(subChildId);

		// Get the title of the sub-child window and print it
		String getTitle = driver.getTitle();
		System.out.println("Title of the current page(subchild): " + getTitle);

		// Clean up by closing all windows
		driver.quit();
	}
}
