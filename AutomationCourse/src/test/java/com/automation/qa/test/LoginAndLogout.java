package com.automation.qa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.qa.base.Base;

public class LoginAndLogout extends Base {

	WebDriver driver;

	@BeforeMethod
	public void setup() {

		driver = launchBrowser("chrome");
		driver.get("http://automationexercise.com");
	}

	@Test(priority = 1)
	public void loginUserWithCorrectEmailandPassword() { // make sure below given credential is register correctly.

		WebElement clickOnSignupAndLogin = driver.findElement(By.xpath("//a[contains(@href,\"/login\")]"));
		clickOnSignupAndLogin.click();
		WebElement visibilityOfMsg = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
		visibilityOfMsg.isDisplayed();
		WebElement enterEmail = driver
				.findElement(By.xpath("//form[contains(@action,\"/login\")]//input[@name='email']"));
		enterEmail.sendKeys("daya.choubey.111@gmail.com");
		driver.findElement(By.xpath("//form[contains(@action,\"/login\")]//input[@name='password']"))
				.sendKeys("123456");
		WebElement clickOnLoginButton = driver
				.findElement(By.xpath("//form[contains(@action,\"/login\")]//button['Login']"));
		clickOnLoginButton.click();
		WebElement loggedInAsUserName = driver.findElement(By.xpath("//b[text()='DSC111']"));
		loggedInAsUserName.isDisplayed();
		System.out.println("Expected Name of USER:- " + loggedInAsUserName.getText());
		WebElement deleteAccount = driver.findElement(By.xpath("//a[contains(@href,\"/delete_account\")]"));
		deleteAccount.click();
		boolean deletedMessage = driver.findElement(By.xpath("//b[text()='Account Deleted!']")).isDisplayed();
		if (deletedMessage == true) {
			System.out.println("Account Deleted!");
			driver.findElement(By.xpath("//a[text()='Continue']")).click();
		}
	}

	@Test(priority = 2)
	public void loginUserWithIncorrectEmailandPassword() {

		WebElement clickOnSignupAndLogin = driver.findElement(By.xpath("//a[contains(@href,\"/login\")]"));
		clickOnSignupAndLogin.click();
		WebElement visibilityOfMsg = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
		visibilityOfMsg.isDisplayed();
		WebElement enterEmail = driver
				.findElement(By.xpath("//form[contains(@action,\"/login\")]//input[@name='email']"));
		enterEmail.sendKeys("daya.choubey.111@gmail.com");
		driver.findElement(By.xpath("//form[contains(@action,\"/login\")]//input[@name='password']")).sendKeys("2345");
		WebElement clickOnLoginButton = driver
				.findElement(By.xpath("//form[contains(@action,\"/login\")]//button['Login']"));
		clickOnLoginButton.click();
		WebElement visibilityOfTextAfterFillWrongEmail = driver.findElement(
				By.xpath("//form[contains(@action,\"/login\")]//p['Your email or password is incorrect!']"));
		visibilityOfTextAfterFillWrongEmail.isDisplayed();
		if (visibilityOfTextAfterFillWrongEmail.isDisplayed() == true) {

			System.out.println("Getting Error: -" + visibilityOfTextAfterFillWrongEmail.getText());
		}
	}

	@Test(priority = 3)
	public void loggout() { // make sure below given credential is register correctly.

		WebElement clickOnSignupAndLogin = driver.findElement(By.xpath("//a[contains(@href,\"/login\")]"));
		clickOnSignupAndLogin.click();
		WebElement visibilityOfMsg = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
		visibilityOfMsg.isDisplayed();
		WebElement enterEmail = driver
				.findElement(By.xpath("//form[contains(@action,\"/login\")]//input[@name='email']"));
		enterEmail.sendKeys("daya.choubey.1111@gmail.com");
		driver.findElement(By.xpath("//form[contains(@action,\"/login\")]//input[@name='password']"))
				.sendKeys("123456");
		WebElement clickOnLoginButton = driver
				.findElement(By.xpath("//form[contains(@action,\"/login\")]//button['Login']"));
		clickOnLoginButton.click();
		WebElement clickOnLogout = driver.findElement(By.xpath("//a[contains(@href,\"/logout\")]"));
		clickOnLogout.click();
	}

}
