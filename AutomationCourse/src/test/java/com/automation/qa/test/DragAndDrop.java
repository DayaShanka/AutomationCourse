package com.automation.qa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Static.html");

		WebElement source = driver
				.findElement(By.xpath("//div[@class=\"col-xs-10 col-xs-offset-2\"]//img[@src=\"original.png\"]"));
		WebElement destination = driver.findElement(By.xpath("//div[@id='droparea']"));

		Actions action = new Actions(driver);
		action.dragAndDrop(source, destination).perform();

	}

}
