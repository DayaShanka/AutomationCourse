package com.automation.qa.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.postman.com/company/contact-sales/");
		// driver.get("https://google.com/");
//		String windowid = driver.getWindowHandle(); // for single window id- 8098ED2B04660DB1ED6641E13B2019B4
//		System.out.println(windowid);
		driver.findElement(By.xpath("//a[text()='Postman Support Center']")).click(); // open another window
		Set<String> multiwindowids = driver.getWindowHandles();
		System.out.println("All window IDS " + multiwindowids); // printing ids of both window
		List<String> windowIds = new ArrayList<>(multiwindowids); // convert into ArrayList
		String parentwinid = windowIds.get(0); // storing with the help of index
		String childwinid = windowIds.get(1);
		System.out.println(parentwinid + " ," + childwinid);
		driver.switchTo().window(childwinid); // stand on child window
		System.out.println(driver.findElement(By.xpath("//h1[text()='Postman support center']")).getText());
		System.out.println(driver.getCurrentUrl());
		driver.switchTo().window(parentwinid);
		System.out.println(driver.getCurrentUrl());

		for (String eid : windowIds) {
			String title = driver.switchTo().window(childwinid).getTitle();
			System.out.println(title);

			if (title.equals("Postman")) {
				driver.close();
				break;

			}

		}
	}

}
