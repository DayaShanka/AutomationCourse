package com.automation.qa.base;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshort {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.shl.com/shldirect/en/practice-tests/");
		driver.manage().window().maximize();
		// full page screenshort
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		File fileLocation = new File(System.getProperty("user.dir") + "//Screenshorts//fullpage1.png");
		sourceFile.renameTo(fileLocation);

		// screenshort of web element
		WebElement ele = driver.findElement(By
				.xpath("//a[@href=\"https://talentcentral.eu.shl.com/player/link/88d727e1400e429b86804dcdee84a24c\"]"));
		File sourceFile2 = ele.getScreenshotAs(OutputType.FILE);
		File fileLocation2 = new File(System.getProperty("user.dir") + "//Screenshorts//left-sidebar.png");
		sourceFile2.renameTo(fileLocation2);
	}

}
