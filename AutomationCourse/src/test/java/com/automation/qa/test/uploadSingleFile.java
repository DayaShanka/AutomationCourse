package com.automation.qa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class uploadSingleFile {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/FileUpload.html");
		driver.manage().window().maximize();

		// Locate the actual file input field
		WebElement browseButton = driver.findElement(By.xpath("//input[@id='input-4']"));

		// Pause for demonstration purposes
		Thread.sleep(2000);

		// Provide the file path to the input field
		String imgPath = "C:\\Users\\admin\\OneDrive\\Documents\\Daya.jpg";
		browseButton.sendKeys(imgPath);

		String[] splitValue = driver.findElement(By.xpath("(//div[@title='Daya.jpg'])[1]")).getText().split("\n");
		String expectedValue = splitValue[0]; // get the value from 0 index Daya.jpg
		if (expectedValue.equals("Daya.jpg")) {
			System.out.println("File Uploaded" + expectedValue);
		}

		// Add a wait to see the result before closing the driver (for testing purposes)
		Thread.sleep(5000);

		driver.quit();
	}
}
