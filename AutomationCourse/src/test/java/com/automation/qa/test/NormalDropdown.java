package com.automation.qa.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class NormalDropdown {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		WebElement option = driver.findElement(By.xpath("//select[@id='country']"));
		Thread.sleep(3000);
		option.click();
		Select select = new Select(option); // select support tag
		select.selectByIndex(1);
		select.selectByValue("india");
		select.selectByVisibleText("Japan");
		System.out.println(select.isMultiple());
		List<WebElement> allOptions = select.getOptions(); // store all dropdown options in getOptions
		System.out.println("Size of all Options: " + allOptions.size());

		for (WebElement options : allOptions) {
			System.out.println(options.getText());
		}

		WebElement colorOption = driver.findElement(By.id("colors"));
		Select select1 = new Select(colorOption);
		select1.selectByValue("blue");
		select1.selectByValue("green");
//		Actions action = new Actions(driver);
//		action.keyDown(Keys.CONTROL).build().perform();

	}

}
