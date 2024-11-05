package com.automation.qa.test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) {

		int noOfBrokenLinks = 0; // storing the broken links
		int noOfNonBrokenLinks = 0;

		WebDriver driver = new ChromeDriver();
		driver.get("https://practice-automation.com/broken-links/");
		driver.manage().window().maximize();

		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		int sizeOfAllLinks = allLinks.size();
		System.out.println("Size of all href links: " + sizeOfAllLinks);

		for (WebElement allLink : allLinks) {
			String hrefAttValue = allLink.getAttribute("href");
			// System.out.println(hrefAttValue);

			if (hrefAttValue == null || hrefAttValue.isEmpty()) {
				System.out.println("href attribute value is empty so not possible to check");
				continue;
			}

			// heat on the server
			try {
				URL linkUrl = new URL(hrefAttValue); // converted href value to url format
				HttpURLConnection conLinkUrl = (HttpURLConnection) linkUrl.openConnection(); // open connection to the
																								// server
				conLinkUrl.connect(); // connect to the server and sent request to server

				if (conLinkUrl.getResponseCode() >= 400) {
					System.out.println(hrefAttValue + " ======> Broken Link");
					noOfBrokenLinks++;
				} else {
					System.out.println(hrefAttValue + " ======> Not a Broken Link");
					noOfNonBrokenLinks++;
				}
			} catch (Exception e)

			{
			}
		}
		System.out.println("Number of Broken Links:" + noOfBrokenLinks);
		System.out.println("Number of Non Broken Links:" + noOfNonBrokenLinks);
	}

}