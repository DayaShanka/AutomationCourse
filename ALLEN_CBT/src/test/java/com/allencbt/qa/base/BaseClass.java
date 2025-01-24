package com.allencbt.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {

	protected WebDriver driver;
	public static Properties prop;
	public File file;
	public FileInputStream fis;
	public static WebDriverWait wait;

	@BeforeSuite
	public void loadConfig() throws IOException {

		prop = new Properties();
		file = new File(System.getProperty("user.dir") + "/src/main/resources/config.properties");
		fis = new FileInputStream(file);
		prop.load(fis);
	}

	@BeforeMethod
	protected void setup() throws Exception {
		System.out.println("Setting up WebDriver for: " + this.getClass().getSimpleName());
		this.driver = getDriver();
		setDriver(driver);
		launchBrowser();
		configureBrowser();
		setUpExplicitWait();
		// staticWait(2);
		System.out.println("Setup method executed.");
	}

	public static String getPropertyFromConfig(String key) {
		return prop.getProperty(key);

	}

	public void launchBrowser() {

		String browser = getPropertyFromConfig("browser");
		if (browser == null || browser.isEmpty()) {
			System.out.println("Browser is Null");
			return;
		}

		switch (browser.toLowerCase()) {

		case "chrome":
			ChromeOptions options = new ChromeOptions();
			driver = new ChromeDriver(options);
			break;
		case "firefox":
			FirefoxOptions opt = new FirefoxOptions();
			driver = new FirefoxDriver(opt);
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Browser not found");

		}

	}

	// getter
	public WebDriver getDriver() {
		return driver;
	}

	// setter
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void setUpExplicitWait() throws Exception {
		if (driver == null) {
			throw new NullPointerException("WebDriver can't be null");
		}
		int waitSecond = Integer.parseInt(getPropertyFromConfig("ExplicitWait"));
		if (waitSecond <= 0) {
			throw new IllegalArgumentException("seconds must be higher than 0");
		}
		wait = new WebDriverWait(driver, Duration.ofSeconds(waitSecond));
	}

	public void switchTabs(int tabIndexToSwitchTo, int waitForNumberOfTabsToBe) {
		wait.until(ExpectedConditions.numberOfWindowsToBe(waitForNumberOfTabsToBe));
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tabIndexToSwitchTo));
	}

	public void threadsleep() throws InterruptedException {
		long secondsleep = Integer.parseInt(getPropertyFromConfig("threadSleepInSec"));
		Thread.sleep(secondsleep);
	}

	public void configureBrowser() {
		driver.get(getPropertyFromConfig("cbtUrl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
	}

	// static wait for second
	public void staticWait(int seconds) {
		LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(seconds));
	}

	@AfterMethod
	protected void tearDown() {
		driver.quit();
	}

}
