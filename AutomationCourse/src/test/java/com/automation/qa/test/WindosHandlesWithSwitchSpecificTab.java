package com.automation.qa.test;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindosHandlesWithSwitchSpecificTab {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		File file = new File(
				"C:\\Users\\admin\\OneDrive\\Documents\\AdBlock-—-block-ads-across-the-web-Chrome-Web-Store.crx");
		options.addExtensions(file);

		WebDriver driver = new ChromeDriver(options);
		driver.get("https://practice.expandtesting.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"/inputs\"]"))).click();
		String currentUrl = driver.getCurrentUrl();
		Set<String> windowIds = driver.getWindowHandles();

		List<String> windows = new ArrayList<>(windowIds);
		// driver.switchTo().window(windows.get(1)); using by indexing
		for (String window : windows) {
			driver.switchTo().window(window);
			Thread.sleep(2000);

			if (currentUrl.contains(currentUrl)) {
				driver.close();
			}
		}

//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"/login\"]"))).click();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"/register\"]"))).click();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"/forgot-password\"]"))).click();

	}

}
