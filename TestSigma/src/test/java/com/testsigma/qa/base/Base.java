package com.testsigma.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	WebDriver driver;
	public static WebDriverWait wait;
	public Properties prop;

	public Base() {

		prop = new Properties();
		File file = new File(
				System.getProperty("user.dir") + "//src//main//java//com//testsigma//qa//config//config.properties");

		try {
			FileInputStream fis = new FileInputStream(file);
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public WebDriver initilizeBrowser(String browserName) {
		String browser = System.getProperty("browserName") != null ? prop.getProperty("browserName")
				: prop.getProperty("browserName");

		if (browser == null) {
			throw new NullPointerException("browser name can't be null");
		}

		switch (browser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			driver = new ChromeDriver();
			System.out.println(
					"Chrome was selected as a browser by default, if you want to select Edge, send 'edge' as an argument for method setUpDriver()");
		}
		driver.manage().window().maximize();
		// driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		return driver;

	}

	public void setUpWait(WebDriver driver, int seconds) throws Exception {
		if (driver == null) {
			throw new NullPointerException("WebDriver can't be null");
		}

		if (seconds <= 0) {
			throw new IllegalArgumentException("seconds must be higher than 0");
		}

		wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
	}

	public void switchTabs(int tabIndexToSwitchTo, int waitForNumberOfTabsToBe) {
		wait.until(ExpectedConditions.numberOfWindowsToBe(waitForNumberOfTabsToBe));
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tabIndexToSwitchTo));
	}

}