package com.automation.qa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptTop10 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://automationexercise.com/");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// • Scroll By Pixel
		// js.executeScript("window.scrollBy(0, 500)"); // Scroll down by 500 pixels

		// • Scroll to Specific Element
		WebElement element = driver.findElement(
				By.xpath("//div[@class='productinfo text-center']//p[text()='Green Side Placket Detail T-Shirt']"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(2000);

		// • Get Page Title Using JavaScript
		String title = (String) js.executeScript("return document.title;");
		System.out.println("Page Title: " + title);

		// • Get Inner Text of Entire Page
		String pageText = (String) js.executeScript("return document.documentElement.innerText;");
		System.out.println("Page Text: " + pageText);

		// • Change Element Style (e.g., Background Color)
		WebElement colorElement = driver.findElement(
				By.xpath("//div[@class='productinfo text-center']//p[text()='Green Side Placket Detail T-Shirt']"));
		js.executeScript("arguments[0].style.backgroundColor = 'yellow';", colorElement);
		Thread.sleep(2000);

		// • Click on a Hidden or Disabled Element
		WebElement hiddenElement = driver.findElement(By.id("hiddenElement"));
		js.executeScript("arguments[0].click();", hiddenElement);

		// • Set Value of an Input Field
		WebElement inputField = driver.findElement(By.id("username"));
		js.executeScript("arguments[0].value='new value';", inputField);

		// • Zoom In and Zoom Out the Page
		js.executeScript("document.body.style.zoom = '90%'"); // Zoom in to 90%
		js.executeScript("document.body.style.zoom = '110%'"); // Zoom out to 110%

		// • Refresh the Page
		js.executeScript("history.go(0)");

		// • Simulate Hover Over an Element
		WebElement hoverElement = driver.findElement(By.id("hoverElement"));
		String mouseOverScript = "var event = new MouseEvent('mouseover', {bubbles: true}); arguments[0].dispatchEvent(event);";
		js.executeScript(mouseOverScript, hoverElement);

	}

}
