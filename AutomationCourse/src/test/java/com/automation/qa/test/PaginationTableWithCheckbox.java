package com.automation.qa.test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PaginationTableWithCheckbox {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Scroll to the pagination table
		WebElement scrollElement = driver.findElement(By.xpath("//h2[text()='Pagination Web Table']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", scrollElement);

		// Print column headers
		List<WebElement> columnNames = driver.findElements(By.xpath("//table[@id='productTable']//th"));
		for (WebElement columnName : columnNames) {
			System.out.print(columnName.getText() + "\t\t");
		}
		System.out.println();

		// Print rows for the current page
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='productTable']//tr"));
		for (int r = 1; r <= rows.size(); r++) { // Start from row 1 to skip the header
			List<WebElement> cells = driver.findElements(By.xpath("//table[@id='productTable']//tr[" + r + "]//td"));
			for (WebElement cell : cells) {
				System.out.print(cell.getText() + "\t\t");

				if (cell.getText().equals("$5.99")) {
					WebElement select = driver
							.findElement(By.xpath("//table[@id='productTable']//tr[" + r + "]//input"));
					select.click();

				}

			}
			System.out.println();

		}

	}
}
