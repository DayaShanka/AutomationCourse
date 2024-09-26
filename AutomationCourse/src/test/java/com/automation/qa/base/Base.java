package com.automation.qa.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	WebDriver driver;

//	public Base() {
//
//	}

	public WebDriver launchBrowser(String browserName) {

		if (browserName == null) {
			throw new NullPointerException("browser name can't be null");
		}
		switch (browserName.toLowerCase()) {
		case "chrome":
			ChromeOptions options = new ChromeOptions();
			// options.setPageLoadStrategy(PageLoadStrategy.EAGER);
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;

		default:
			driver = new ChromeDriver();
			System.out.println("Chrome was selected as a browser by default");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30L, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(3L, TimeUnit.SECONDS);

		return driver;
	}

}
