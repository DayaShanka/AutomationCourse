package com.automation.qa.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkbox3 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://total-qa.com/checkbox-example/");
		List<WebElement> checkbox = driver
				.findElements(By.xpath("//input[@type='checkbox' and normalize-space()=\"\"]"));

	}

}
