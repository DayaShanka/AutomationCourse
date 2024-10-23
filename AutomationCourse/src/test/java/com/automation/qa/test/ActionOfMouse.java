package com.automation.qa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionOfMouse {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Datepicker.html");

		// Find the 'SwitchTo' and 'Windows' elements
		WebElement switchTo = driver.findElement(By.xpath("//a[@href=\"SwitchTo.html\" and text()='SwitchTo']"));
		WebElement windows = driver.findElement(By.xpath("//a[@href=\"Windows.html\" and text()='Windows']"));

		// Create Actions object to handle mouse actions
		Actions action = new Actions(driver);

		// Hover over the 'SwitchTo' menu to make the 'Windows' option visible
		action.moveToElement(switchTo).perform();
		Thread.sleep(2000); // Add a delay to ensure the menu is visible

		// Now try to get the text of the 'Windows' element after hovering
		String windowsText = windows.getText();
		System.out.println("Text of the 'Windows' option: " + windowsText);

		// Click on the 'Windows' option
		action.moveToElement(windows).click().perform();

		driver.quit();
	}

}
