package com.automation.qa.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToCart {
	// Method to retrieve the required username
	static String retrieveUserName(WebDriver driver) {

		WebElement loginCredentialsDiv = driver.findElement(By.id("login_credentials"));

		// Get the full text content of the div
		String allText = loginCredentialsDiv.getText();
		// System.out.println(allText);

		// Split the text based on new lines to get individual usernames
		String[] usernames = allText.split("\n");
		System.out.println("Available userNames:");

		// Start loop from the second line (skip the header)
		for (int i = 1; i < usernames.length; i++) {
			String trimmedUsernames = usernames[i].trim();
			System.out.println(trimmedUsernames);
			if (trimmedUsernames.equals("standard_user")) {
				return trimmedUsernames;

			}
		}
		return allText;

	}

	// Method to retrieve the required password
	static String retrievePassword(WebDriver driver) {
		WebElement getPassword = driver.findElement(By.xpath("//div[text()='secret_sauce']"));
		String[] password = getPassword.getText().split("\n");
		String trimmedPassword = password[1].trim();

		System.out.println("Available Password:");
		return trimmedPassword;
	}

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		String uName = retrieveUserName(driver);
		WebElement userNameTextBox = driver.findElement(By.xpath("//input[@id='user-name']"));
		userNameTextBox.sendKeys(uName);

		String uPassword = retrievePassword(driver);
		WebElement passwordTextBox = driver.findElement(By.xpath("//input[@id='password']"));
		passwordTextBox.sendKeys(uPassword);
		System.out.println(uPassword);
		// click on login
		WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
		loginButton.click();

	}

}
