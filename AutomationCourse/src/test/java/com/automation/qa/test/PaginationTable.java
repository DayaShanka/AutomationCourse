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

		WebElement next = driver
				.findElement(By.xpath("//div[@class='dataTables_paginate paging_simple']//a[text()='Next']"));

		// Loop until the "Next" button is disabled

		while (next.isEnabled() == true) {

			Thread.sleep(2000);

			List<WebElement> tableRow = driver.findElements(By.xpath("//tbody[@class='row-hover']//tr/td[1]"));

			int getRSize = tableRow.size();

			System.out.println("First_Name: ");

			for (int r = 1; r <= getRSize; r++) {

				WebElement rowData = driver.findElement(By.xpath("//tbody[@class='row-hover']//tr[" + r + "]//td[1]"));

				String printRow = rowData.getText();

				System.out.println(printRow);

				// System.out.println("_________page_no: "+r);

			}

			next.click();

			// Click on the "Next" button

			// printing row data

			Thread.sleep(2000);

			// Check for the next button again after the page updates

			next = driver.findElement(By.xpath("//div[@class='dataTables_paginate paging_simple']//a[text()='Next']"));

			// Add a delay to let the page load after each click

			try {

				Thread.sleep(2000); // Pause for 2 seconds to let the page load

			} catch (InterruptedException e) {

				e.printStackTrace();

			}
			

		}

	}

}