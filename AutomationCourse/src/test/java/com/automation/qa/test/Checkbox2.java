package com.automation.qa.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkbox2 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://total-qa.com/checkbox-example/");
		List<WebElement> checkbox = driver.findElements(By.xpath("//input[@type=\"checkbox\"]"));
		String aa = driver.findElement(By.xpath("//div[@class='entry-content']")).getText();
		System.out.println(aa);

		checkbox.get(1).click(); // we can click with the help of indexing
		checkbox.get(3).click();

		if (aa.contains("QTP") || aa.contains("JMETER")) {
//			checkbox.get(1).click(); // we can click with the help of indexing
//			checkbox.get(3).click();
//		}
		}
	}
}