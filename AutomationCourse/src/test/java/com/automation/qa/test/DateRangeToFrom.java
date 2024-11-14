package com.automation.qa.test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DateRangeToFrom {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://allenpreprod.thinkexam.com/admin");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		// Login process
		driver.findElement(By.id("loginId")).sendKeys("ds@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.id("loginSubmit")).click();

		driver.findElement(By.xpath("//li[@id='mainmenu_Reports']//a")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Absent % Report']")).click();
		WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("filterField")));
		Select select = new Select(option);
		select.selectByVisibleText("Advanced Search");

		// fromdate
		driver.findElement(By.xpath("//input[@id='fromdate1']")).click();
		WebElement monthSelectionFrom = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		Select selectFromDropdown = new Select(monthSelectionFrom);
		selectFromDropdown.selectByValue("7");// august

		WebElement yearSelection = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select selectFromDropdown1 = new Select(yearSelection);
		selectFromDropdown1.selectByValue("2019");// 2019

		List<WebElement> allDates = driver.findElements(By.xpath("//table[@class=\"ui-datepicker-calendar\"]//td//a"));

		for (WebElement dt : allDates) {
			String dateText = dt.getText();
			if (dateText.equals("20")) {
				dt.click();

			}

		}

		// todate
		driver.findElement(By.xpath("//input[@id='todate1']")).click();
		WebElement monthSelection = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		Select selectMDropdown = new Select(monthSelection);
		selectMDropdown.selectByValue("5");// june

		WebElement yearSelectionTo = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select selectYearDropdown = new Select(yearSelectionTo);
		selectYearDropdown.selectByValue("2020");// 2020

		List<WebElement> allDatesTo = driver
				.findElements(By.xpath("//table[@class=\"ui-datepicker-calendar\"]//td//a"));

		for (WebElement dt : allDatesTo) {
			String dateText = dt.getText();
			if (dateText.equals("10")) {
				dt.click();

			}

		}
		System.out.println("Expected date selected");
		driver.quit();
	}

}
