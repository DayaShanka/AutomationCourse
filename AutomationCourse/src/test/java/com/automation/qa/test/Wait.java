package com.automation.qa.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://sso.teachable.com/secure/9521/identity/login/password");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(5)); // explicity Declaration
		WebElement waitElement = mywait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='Rahul Shetty Academy']")));
		System.out.println(waitElement.isDisplayed());
		// System.out.println(driver.findElement(By.xpath("//img[@alt='Rahul Shetty
		// Academy']")).isDisplayed());
	}

}
