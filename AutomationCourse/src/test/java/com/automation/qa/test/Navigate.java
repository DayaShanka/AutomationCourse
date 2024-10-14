package com.automation.qa.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigate {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://automationexercise.com/"); // easy to use
		URL myurl = null;
		try {
			myurl = new URL("https://automationexercise.com/"); // another approach
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(myurl);
		driver.navigate().to("https://google.com/"); // we can write like this also
		driver.navigate().back(); // go to back page
		driver.navigate().forward(); // go to next page
		driver.navigate().refresh(); // reload the page

	}

}
