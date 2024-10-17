package com.automation.qa.test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SuggestedDropdown {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver;
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("selenium");
		List<WebElement> optionsInDropdown = wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@role='listbox']//li//div[@role='option']"))); // explicity
																												// wait
//		List<WebElement> optionsInDropdown = driver
//				.findElements(By.xpath("//ul[@role='listbox']//li//div[@role='option']"));
		System.out.println("Size of all visible elements are: " + optionsInDropdown.size());

		for (WebElement option : optionsInDropdown) {

			System.out.println(option.getText());

			if (option.getText().contains("selenium")) {
				option.click(); // clicking on suggested value

			}
		}

	}

}
