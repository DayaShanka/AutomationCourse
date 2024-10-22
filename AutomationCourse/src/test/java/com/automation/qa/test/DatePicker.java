package com.automation.qa.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker {

	static void selectExpectedDates(WebDriver driver, String date, String month, String year)
			throws InterruptedException {

		while (true) {

			String getMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String getYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

			if (getMonth.equals(month) && getYear.equals(year)) {

				break;
			}
			// WebElement next = driver.findElement(By.xpath("//span[@class='ui-icon
			// ui-icon-circle-triangle-e']"));
			WebElement previous = driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']"));
			Thread.sleep(1000);
			// next.click();
			previous.click();

		}
		// get the alldates from calendar
		List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td//a"));
		Thread.sleep(1000);
		for (WebElement dt : dates) {
			dt.getText();

			if (dt.getText().equals(date)) {

				dt.click();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/datepicker/");
		// click on box
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();

		selectExpectedDates(driver, "15", "December", "2023"); // expected dates with the help of method

	}
}
