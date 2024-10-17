package com.automation.qa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tooltip {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver;

		driver = new ChromeDriver();
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=11.0_1");
		Thread.sleep(3000);
		WebElement clickOnButton = driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
		clickOnButton.click(); // after click on it, required element will be visible in DOM
		WebElement getTextOfTooltip = driver.findElement(
				By.xpath("//div[@class='tooltip-inner' and contains(text(),'A Tooltip with default direction')]"));  //visible in DOM
		System.out.println("Text is visible " + getTextOfTooltip.getText());

	}

}
