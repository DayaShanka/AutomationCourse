package com.automation.qa.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class uploadMultiFile {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/FileUpload.html");
		driver.manage().window().maximize();

		WebElement browseButton = driver.findElement(By.xpath("//input[@id='input-4']"));

		String file1 = "C:\\Users\\admin\\OneDrive\\Documents\\DSC05001.JPG";
		String file2 = "C:\\\\Users\\\\admin\\\\OneDrive\\\\Documents\\\\DSC05009.JPG";
		browseButton.sendKeys(file1 + "\n" + file2);
		Thread.sleep(5000);

		List<WebElement> uploadedFile = driver
				.findElements(By.xpath("//div[@class='file-preview-frame krajee-default  kv-preview-thumb']"));
		System.out.println("Count of uploaded file: " + uploadedFile.size());

		driver.quit();
	}

}
