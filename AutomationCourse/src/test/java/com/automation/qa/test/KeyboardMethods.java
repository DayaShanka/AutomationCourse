package com.automation.qa.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardMethods {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://text-compare.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("inputText1")).sendKeys("Keyboard Actions");

		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform(); // select all
		action.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform(); // copy the text
		action.keyDown(Keys.TAB).keyUp(Keys.TAB).perform(); // using TAB
		action.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform(); // paste the copied text
		Thread.sleep(2000);
		driver.findElement(By.className("compareButtonText")).click();
		Thread.sleep(2000);
		String textValue = driver.findElement(By.xpath("//span[@class='messageForUser']")).getText();
		System.out.println(textValue);
		System.out.println("Action completed..");

		driver.quit();

	}

}
