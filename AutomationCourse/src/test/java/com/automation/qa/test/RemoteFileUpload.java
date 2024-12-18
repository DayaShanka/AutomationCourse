package com.automation.qa.test;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteFileUpload {
	public static void main(String[] args) throws Exception {
		// Connect to the remote WebDriver server (e.g., Selenium Grid)
		RemoteWebDriver driver = new RemoteWebDriver(new URL("https://letcode.in/file"), new ChromeOptions());

		// Enable file detection
		driver.setFileDetector(new LocalFileDetector());

		// Navigate to a file upload form
		driver.get("https://letcode.in/file");

		// Find the file upload input element
		WebElement uploadElement = driver.findElement(By.className("file-label"));

		// Specify the file path on your local machine
		String filePath = "C:\\path\\to\\your\\file.txt";

		// Upload the file
		uploadElement.sendKeys(filePath);

		// Submit or perform further actions
		driver.findElement(By.id("uploadButton")).click();

		// Close the driver
		driver.quit();
	}
}
