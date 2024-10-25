package com.automation.qa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DragTheRange {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://allenpreprod.thinkexam.com/admin");
		driver.manage().window().maximize();

		// Target percentage to compare
		String per = "80%";

		// Login process
		driver.findElement(By.id("loginId")).sendKeys("ds@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.id("loginSubmit")).click();
		Thread.sleep(5000);

		// Navigate to report
		driver.findElement(By.xpath("//li[@id='mainmenu_Reports']//a")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Absent % Report']")).click();
		Thread.sleep(3000);

		// Select Advanced Search
		WebElement option = driver.findElement(By.name("filterField"));
		Select select = new Select(option);
		select.selectByVisibleText("Advanced Search");
		Thread.sleep(1000);

		// Locate the actual range slider input element
		WebElement rangeSlider = driver.findElement(By.xpath("//input[@id='percentageRanges']"));

		// Set the slider value using JavaScriptExecutor
		setRangeSliderValue(driver, rangeSlider, 80); // Set to 80%

		// Wait for the slider to update and get the displayed percentage
		Thread.sleep(2000);
		WebElement percentageDisplay = driver.findElement(By.xpath("//span[@id='percentageValue']"));
		String displayedPercentage = percentageDisplay.getText();
		System.out.println("Slider percentage value displayed: " + displayedPercentage);

		// Compare the displayed percentage with the `per` variable
		if (displayedPercentage.equals(per)) {
			System.out.println("The displayed percentage matches the target percentage: " + per);
		} else {
			System.out.println("The displayed percentage does not match the target. Displayed: " + displayedPercentage
					+ ", Expected: " + per);
		}

		driver.quit();
	}

	// JavaScriptExecutor to set the slider value
	public static void setRangeSliderValue(WebDriver driver, WebElement slider, int value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = arguments[1];", slider, value);
	}
}
