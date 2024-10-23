package com.automation.qa.test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AirDatePicker {

	public static void main(String[] args) throws InterruptedException {

		// Set up WebDriver
		WebDriver driver = new ChromeDriver();
		driver.get("https://air-datepicker.com/");

		// Explicit wait to ensure date picker loads
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		// Open the date picker
		driver.findElement(By.xpath("//div[@class='air-datepicker-nav--title']")).click();

		// Desired month and year
		String desiredMonth = "Apr";
		String desiredYear = "2021";
		String desiredDate = "21";

		// Navigate to the correct year
		driver.findElement(By.xpath("//div[@class='air-datepicker-nav--title']")).click();
		wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='air-datepicker-cell -year-']")));

		List<WebElement> yearList = driver.findElements(By.xpath("//div[@class='air-datepicker-cell -year-']"));
		for (WebElement yr : yearList) {
			if (yr.getText().equals(desiredYear)) {
				yr.click();
				break;
			}
		}

		// Wait for the month elements to load
		wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='air-datepicker-cell -month-']")));

		// Get all months and select the desired one
		List<WebElement> monthList = driver.findElements(By.xpath("//div[@class='air-datepicker-cell -month-']"));
		for (WebElement month : monthList) {
			if (month.getText().equals(desiredMonth)) {
				month.click();
				break;
			}
		}

		List<WebElement> allDates = driver.findElements(By
				.xpath("//div[@class=\"air-datepicker-cell -day-\" or @class='air-datepicker-cell -day- -weekend-']"));

		for (WebElement dt : allDates) {
			if (dt.getText().equals(desiredDate)) {
				dt.click();
			}

		}

		// Close the driver
		// driver.quit();
	}
}
