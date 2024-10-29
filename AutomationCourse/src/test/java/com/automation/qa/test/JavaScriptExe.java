package com.automation.qa.test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExe {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://automationexercise.com/");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// ● Change zoom size
		js.executeScript("document.body.style.zoom='50%'");

		// ● Change background color
		js.executeScript("document.body.style.backgroundColor = 'lightblue'");
		Thread.sleep(2000);

		// ● Change font size
		js.executeScript("document.body.style.fontSize = '20px'");
		Thread.sleep(2000);

		// ● Set padding
		js.executeScript("document.body.style.padding = '50px'");
		Thread.sleep(2000);

		// ● Change text color
		js.executeScript("document.body.style.color = 'green'");
		Thread.sleep(2000);

		// ● Hide the body (display none)
		js.executeScript("document.body.style.display = 'none'");
		Thread.sleep(2000);

		// ● Adjust margin
		js.executeScript("document.body.style.margin = '0'");
		Thread.sleep(2000);

		// ● Add a box shadow
		js.executeScript("document.body.style.boxShadow = '10px 10px 20px gray'");
		Thread.sleep(2000);

		// ● Set opacity
		js.executeScript("document.body.style.opacity = '0.5'");
		Thread.sleep(2000);

		// ● Rotate body content
		js.executeScript("document.body.style.transform = 'rotate(10deg)'");
		Thread.sleep(2000);

		// ● Change cursor style
		js.executeScript("document.body.style.cursor = 'pointer'");
		Thread.sleep(2000);

		// ● Add a background image
		js.executeScript("document.body.style.backgroundImage = 'url(https://example.com/image.jpg)'");
		Thread.sleep(2000);

		// ● Add a gradient background
		js.executeScript("document.body.style.background = 'linear-gradient(to right, red, yellow)'");
		Thread.sleep(2000);

		// ● Increase line height
		js.executeScript("document.body.style.lineHeight = '1.8'");
		Thread.sleep(2000);

	}

}
