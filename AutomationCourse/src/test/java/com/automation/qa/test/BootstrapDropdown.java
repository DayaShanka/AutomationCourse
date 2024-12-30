package com.automation.qa.test;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootstrapDropdown {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_1");
		driver.findElement(By.xpath("//span[@class='multiselect-selected-text']")).click();
		List<WebElement> drp = driver
				.findElements(By.xpath("//ul[@class='multiselect-container dropdown-menu']//li//label"));

		// Create an ArrayList to hold the options to select
		List<String> optionsToSelect = new ArrayList<>();
		optionsToSelect.add("HTML");
		optionsToSelect.add("jQuery tutorial");
		 System.out.println(optionsToSelect);

		for (WebElement dropdown : drp) {
			String option = dropdown.getText();

			if (optionsToSelect.contains(option)) {
				dropdown.click();
				System.out.println("Clicked on selected checkbox: " + option);
			}
		}
	}

}
