package com.automation.qa.test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddToCart {
	// Method to retrieve the required username
	static String retrieveUserName(WebDriver driver) {
		WebElement loginCredentialsDiv = driver.findElement(By.id("login_credentials"));
		String allText = loginCredentialsDiv.getText();

		String[] usernames = allText.split("\n");
		System.out.println("Available userNames:");

		for (int i = 1; i < usernames.length; i++) {
			String trimmedUsernames = usernames[i].trim();
			System.out.println(trimmedUsernames);
			if (trimmedUsernames.equals("standard_user")) {
				return trimmedUsernames;
			}
		}
		return null;
	}

	// Method to retrieve the required password
	static String retrievePassword(WebDriver driver) {
		WebElement getPassword = driver.findElement(By.xpath("//div[text()='secret_sauce']"));
		String[] password = getPassword.getText().split("\n");
		String trimmedPassword = password.length > 1 ? password[1].trim() : "";

		System.out.println("Available Password: " + trimmedPassword);
		return trimmedPassword;
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		String uName = retrieveUserName(driver);
		WebElement userNameTextBox = driver.findElement(By.xpath("//input[@id='user-name']"));
		userNameTextBox.sendKeys(uName);

		String uPassword = retrievePassword(driver);
		WebElement passwordTextBox = driver.findElement(By.xpath("//input[@id='password']"));
		passwordTextBox.sendKeys(uPassword);

		WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
		loginButton.click();

		// Explicit wait to ensure items are loaded
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='inventory_item_label']//a")));

		// Get list of product names and corresponding "Add to Cart" buttons
		List<WebElement> itemNames = driver.findElements(By.xpath("//div[@class='inventory_item_label']//a"));
		List<WebElement> addToCartButtons = driver
				.findElements(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory ']"));

		// Debugging: Print sizes of both lists
		System.out.println("Total Items Found: " + itemNames.size());
		System.out.println("Total Add to Cart Buttons Found: " + addToCartButtons.size());

		// Check if both lists have the same size
		if (itemNames.size() != addToCartButtons.size()) {
			System.out.println("Mismatch in list sizes. Exiting.");
			driver.quit();
			return;
		}

		// Loop to find the "Sauce Labs Onesie" and click its "Add to Cart" button
		for (int i = 0; i < itemNames.size(); i++) {
			String itemName = itemNames.get(i).getText();
			System.out.println("Item Name: " + itemName);

			if (itemName.equals("Sauce Labs Onesie") || itemName.equals("Sauce Labs Bike Light")) {
				addToCartButtons.get(i).click();
				System.out.println("Clicked Add to Cart for: " + itemName);
				Thread.sleep(3000);

				File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				String screenshotPath = System.getProperty("user.dir") + "/screenshots/" + itemName + ".png";
				FileUtils.copyFile(srcFile, new File(screenshotPath));
				System.out.println("Screenshot taken for: " + itemName);

			}
		}

		WebElement eleItem = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='inventory_item'][5]")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", eleItem);

		// taking screenshort after click on selected item
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = eleItem.getScreenshotAs(OutputType.FILE);
		File location = new File(System.getProperty("user.dir") + "//Screenshorts//item.png");
		source.renameTo(location);

		// get the count of added item in the cart
		WebElement addedItemCountInCart = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='shopping_cart_badge']")));
		System.out.println("Added Item count in the cart: " + addedItemCountInCart.getText());

		// clicking on "Cart" icon
		WebElement clickOnCartIcon = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
		clickOnCartIcon.click();

		WebElement checkoutButton = driver.findElement(By.xpath("//button[@id='checkout']"));
		checkoutButton.click();
		driver.findElement(By.id("first-name")).sendKeys("Dev");
		driver.findElement(By.id("last-name")).sendKeys("Pandey");
		driver.findElement(By.id("postal-code")).sendKeys("802125");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("finish")).click();
		WebElement completeOrder = driver.findElement(By.xpath("//h2[text()='Thank you for your order!']"));
		System.out.println(completeOrder.getText());
		Assert.assertEquals(completeOrder.getText(), "Thank you for your order!");

// click on continue without fill the form
//		driver.findElement(By.id("continue")).click();
//		WebElement errorMessage = driver
//				.findElement(By.xpath("//h3[@data-test=\"error\" and text()='Error: First Name is required']"));
//		Assert.assertEquals(errorMessage.getText(), "Error: First Name is required]");
//		if (errorMessage.getText().equals("Error: First Name is required")) {
//			System.out.println("All fields are required.");
//		}

		driver.quit();
	}
}
