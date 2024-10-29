package com.automation.qa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorScroll {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.softwaretestingmaterial.com/test-cases-for-amazon-shopping-cart/");
		driver.manage().window().maximize();

		// Cast WebDriver to JavascriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// 1. scroll the window by set the pixel(vertical scroll bar)
		js.executeScript("window.scrollBy(0,500)");
		// current vertical offset position of the window
		// System.out.println(js.executeScript("return window.pageYOffset;"));

		// 2. scroll the page till element is visible
		WebElement ele = driver
				.findElement(By.xpath("//strong[text()='Usability test cases for Amazon Shopping Cart']"));
		System.out.println("visible element: " + ele.getText());
		js.executeScript("arguments[0].scrollIntoView();", ele);
		System.out.println(js.executeScript("return window.pageYOffset;"));

		// 3. scroll page till the end
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset;"));
	}
}
