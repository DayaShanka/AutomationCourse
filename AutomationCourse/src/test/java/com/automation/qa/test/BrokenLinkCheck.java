package com.automation.qa.test;

import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinkCheck {

	public static void main(String[] args) {
		int noOfBrokenLinks = 0;
		WebDriver driver = new ChromeDriver();

		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		TakesScreenshot ts = (TakesScreenshot) driver; // to taking screenshort

		List<WebElement> bknLinks = driver.findElements(By.xpath("//div[@id='broken-links']//a[@class='link']"));
		WebElement brokenLinkArea = driver.findElement(By.xpath("//div[@id='broken-links']")); // to take screenshort

		File source = brokenLinkArea.getScreenshotAs(OutputType.FILE);
		File flocation = new File(System.getProperty("user.dir") + "//Screenshorts//brokenlink.png");
		source.renameTo(flocation);

		for (WebElement bLinks : bknLinks) {
			js.executeScript("arguments[0].scrollIntoView();", bLinks);
			String linkValue = bLinks.getAttribute("href");

			if (linkValue == null || linkValue.isEmpty()) {
				System.out.println("Cannot check link (no href found): " + bLinks.getText());
				continue;
			}

			try {
				URL linkURL = new URL(linkValue); // Convert to URL format
				HttpURLConnection conURL = (HttpURLConnection) linkURL.openConnection();
				conURL.setRequestMethod("HEAD");
				conURL.connect();

				if (conURL.getResponseCode() >= 400) {
					System.out.println("Broken Link ===> " + linkValue);
					noOfBrokenLinks++;
				} else {
					System.out.println("Valid Link ===> " + linkValue);
				}
			} catch (Exception e) {
				System.out.println("Error checking link: " + linkValue + " - " + e.getMessage());
			}
		}

		System.out.println("Number of Broken Links: " + noOfBrokenLinks);
		driver.quit();

	}
}
