package com.automation.qa.test;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AmazonSearch {

	WebDriver driver;

	void emailAndPassword() {

	}

	@BeforeMethod
	void setup() {
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	void searchProduct() throws InterruptedException {
		// Locate the search box and search for "shoes"
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.clear(); // Clear existing text
		searchBox.sendKeys("shoes");

		// Use explicit wait for search suggestions to appear
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> suggestions = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(
				"//div[@class='s-suggestion-container']//div[@class='s-suggestion s-suggestion-ellipsis-direction']")));
		Thread.sleep(2000);
		System.out.println("Search Suggestions:");
		for (WebElement suggestion : suggestions) {
			try {
				System.out.println(suggestion.getText());

				if (suggestion.getText().equals("shoes sneakers")) {
					suggestion.click();

				}
			} catch (org.openqa.selenium.StaleElementReferenceException e) {
				System.out.println("Stale element encountered. Skipping...");
			}
		}

		// Locate product results
		List<WebElement> productLinks = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(
				"//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']")));

		System.out.println("\nProduct Results:");
		for (WebElement product : productLinks) {
			try {
				System.out.println(product.getText());

				// Scroll to the product element if necessary
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(true);", product);

				if (product.getText().equals(
						"Men's Energy Afterburn Disruptor for Multiple Sports,Fashion, Party & Fun Shoes/Sneakers")) {
					product.click();
				}

			} catch (org.openqa.selenium.StaleElementReferenceException e) {
				System.out.println("Stale element encountered. Refetching...");
				productLinks = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(
						"//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']")));
			}
		}
		// window handle to switch child
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow);
		WebElement buyButton = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//span[@class='a-button a-button-oneclick a-button-icon onml-buy-now-button']")));
		buyButton.click();
	}

	@AfterMethod
	void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
