package com.automation.qa.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver;
		driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/selenium/web/alerts.html#");
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		 * driver.findElement(By.xpath("//a[@onclick=\"alert('cheese');\"]")).click();
		 * Alert acceptAlert = driver.switchTo().alert(); acceptAlert.accept(); // to
		 * accept the alert/popup Alert myalert =
		 * wait.until(ExpectedConditions.alertIsPresent()); // another way to accept the
		 * popup myalert.accept();
		 */

		// 2. prompt alert

		/*
		 * driver.findElement(By.xpath("//a[@onclick=\"displayPrompt();\"]")).click();
		 * Alert promptAlert = driver.switchTo().alert();
		 * promptAlert.sendKeys("Entered"); Thread.sleep(5); // promptAlert.accept();
		 * promptAlert.dismiss();
		 */

		// 3. open new window with alert

		driver.findElement(By.xpath("//a[@href=\"pageWithOnLoad.html\" and contains(text(),'open new pa')]")).click();
		Thread.sleep(5);
		Alert openWindowAlert = driver.switchTo().alert();
		Thread.sleep(5);
		openWindowAlert.accept();

	}

}
