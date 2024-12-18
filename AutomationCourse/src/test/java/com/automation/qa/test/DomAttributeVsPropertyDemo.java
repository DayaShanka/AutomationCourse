package com.automation.qa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DomAttributeVsPropertyDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://practice-automation.com/form-fields/");
		driver.manage().window().maximize();
// Example: Checkbox
		WebElement checkbox = driver.findElement(By.id("drink4")); // Replace with an actual checkbox ID

		// Retrieve DOM attribute and property values for the checkbox
		String checkboxAttribute = checkbox.getDomAttribute("value");
		System.out.println("Checkbox DOM Attribute (checked): " + checkboxAttribute);

		String checkboxProperty = checkbox.getDomProperty("value");
		System.out.println("Checkbox DOM Property (checked): " + checkboxProperty);

		// Example: Input field
		WebElement inputField = driver.findElement(By.id("message")); // Replace with an actual input field ID

		// Retrieve DOM attribute and property values for the input field
		String inputValueAttribute = inputField.getDomAttribute("placeholder");
		System.out.println("Input Field DOM Attribute (value): " + inputValueAttribute);

		String inputValueProperty = inputField.getDomProperty("placeholder");
		System.out.println("Input Field DOM Property (value): " + inputValueProperty);

		// Simulate interaction: change the input field value
		inputField.sendKeys("Test Automation");

		// Retrieve the property again after interaction
		String updatedInputValueProperty = inputField.getDomProperty("value");
		System.out.println("Updated Input Field DOM Property (value): " + updatedInputValueProperty);

		driver.quit();
	}
}
