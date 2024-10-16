package com.automation.qa.test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dropdowns {

	public static void main(String[] args) throws InterruptedException {

		// we have 3 types of dropdown

		WebDriver driver = new ChromeDriver();
//		1. normal select dropdown
//		2. Boostrap Dropdown
//		3. hide element dropdown

//		1. normal select dropdown
		/*
		 * driver.get("https://testautomationpractice.blogspot.com/");
		 * driver.manage().window().maximize(); WebElement option =
		 * driver.findElement(By.xpath("//select[@id='country']")); Thread.sleep(3000);
		 * option.click(); Select select = new Select(option); // select support tag
		 * select.selectByIndex(1); select.selectByValue("india");
		 * select.selectByVisibleText("Japan"); List<WebElement> allOptions =
		 * select.getOptions(); // store all dropdown options in getOptions
		 * System.out.println("Size of all Options: " + allOptions.size());
		 * 
		 * for (WebElement options : allOptions) {
		 * System.out.println(options.getText()); }
		 */

//2. Boostrap Dropdown
//		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_1");
//		driver.findElement(By.xpath("//span[@class='multiselect-selected-text']")).click();
//		List<WebElement> drp = driver
//				.findElements(By.xpath("//ul[@class='multiselect-container dropdown-menu']//li//label"));
//
//		// Create an ArrayList to hold the options to select
//		List<String> optionsToSelect = new ArrayList<>();
//		optionsToSelect.add("HTML");
//		optionsToSelect.add("jQuery tutorial");
//
//		for (WebElement dropdown : drp) {
//			String option = dropdown.getText();
//
//			if (optionsToSelect.contains(option)) {
//				dropdown.click();
//				System.out.println("Clicked on selected checkbox: " + option);
//			}
//		}

		// 3. Hide Dropdown

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(4));
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='PIM']")).click();
		driver.findElement(By.xpath(
				"//body/div[@id='app']/div[@class='oxd-layout orangehrm-upgrade-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-background-container']/div[@class='oxd-table-filter']/div[@class='oxd-table-filter-area']/form[@class='oxd-form']/div[@class='oxd-form-row']/div[@class='oxd-grid-4 orangehrm-full-width-grid']/div[3]/div[1]/div[2]/div[1]/div[1]"))
				.click();

		List<WebElement> dropdown = driver.findElements(By.xpath("//div[@role='listbox']//div//span"));
		System.out.println("Size of all dropdown: " + dropdown.size());

		for (WebElement options : dropdown) {
			String alloptions = options.getText();

			if (alloptions.equals("Full-Time Probation")) {
				options.click();
			}

		}
	}

}
