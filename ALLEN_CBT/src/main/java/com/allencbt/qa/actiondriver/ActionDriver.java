package com.allencbt.qa.actiondriver;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionDriver {

	private WebDriver driver;
	private WebDriverWait wait;
	Properties prop;

	public ActionDriver(WebDriver driver) {

		this.driver = driver;

		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}

	public void waitForElementToBeClickable(By by) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(by));
		} catch (Exception e) {
			System.out.println("element is not clickable " + e.getMessage());

		}
	}

	public void waitForElementToBeVisible(By by) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		} catch (Exception e) {
			System.out.println("element is not visible " + e.getMessage());
		}
	}

	public void click(By by) {
		try {
			waitForElementToBeClickable(by);
			driver.findElement(by).click();
		} catch (Exception e) {
			System.out.println("Unable to click element: " + e.getMessage());
		}
	}

	public void enterValue(By by, String value) {
		try {
			waitForElementToBeVisible(by);
			driver.findElement(by).sendKeys(value);
		} catch (Exception e) {
			System.out.println("Unable to enter the value: " + e.getMessage());
		}
	}

	public String getText(By by) {
		waitForElementToBeVisible(by);
		try {
			return driver.findElement(by).getText();
		} catch (Exception e) {
			System.out.println("Unable to get the text: " + e.getMessage());
			return "";
		}
	}

	public boolean isDisplayed(By by) {
		try {
			waitForElementToBeVisible(by);
			return driver.findElement(by).isDisplayed();
		} catch (Exception e) {
			System.out.println("Unable to see the element: " + e.getMessage());
		}
		return false;

	}

	public void compareValue(By by, String expected) {
		try {
			waitForElementToBeVisible(by);
			String actual = driver.findElement(by).getText();
			if (expected.equals(actual)) {
				System.out.println("Test are matching: " + " actual- " + actual + " expected- " + expected);
			}
		} catch (Exception e) {
			System.out.println("Test are matching: " + expected);
		}
	}

}
