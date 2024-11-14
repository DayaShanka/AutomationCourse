package com.automation.qa.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PaginationTable {

	public static void main(String[] args) throws InterruptedException {

		// Setup WebDriver and navigate to the page
		WebDriver driver = new ChromeDriver();
		driver.get("https://tablepress.org/demo/");
		driver.manage().window().maximize();

		// Define a locator for the "Next" button
		WebElement next = driver.findElement(By.xpath("//button[@data-dt-idx=\"next\"]"));

		System.out.println("First_Name: ");
		// Loop until the "Next" button is disabled
		while (next.isEnabled()) {
			Thread.sleep(2000);

			// Locate all rows on the current page
			List<WebElement> tableRows = driver
					.findElements(By.xpath("//tbody[@class='row-striping row-hover']//tr/td[1]"));

			// Print the first name in each row on the current page
			for (WebElement rowData : tableRows) {
				System.out.println(rowData.getText());
			}

			// Click "Next" and re-assign the "Next" button element
			next.click();
			Thread.sleep(2000); // Pause to allow the next page to load

			// Re-locate the "Next" button to check if it’s enabled on the new page
			next = driver.findElement(By.xpath("//button[@data-dt-idx=\"next\"]"));
		}

		System.out.println("No more pages to display.");
		driver.quit();
	}
}
