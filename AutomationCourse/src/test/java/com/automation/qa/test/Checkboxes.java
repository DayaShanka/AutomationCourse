package com.automation.qa.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkboxes {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://total-qa.com/checkbox-example/");
		List<WebElement> checkbox = driver.findElements(By.xpath("//input[@type=\"checkbox\"]"));
		for (int i = 2; i < checkbox.size(); i++) { // clicking last 2 checkbox//formula (4-2=2)
			checkbox.get(i).click();
			boolean isSelected = checkbox.get(i).isSelected(); // if checkbox is selected then only de-select
			checkbox.get(i).click();

		}
	}
}
