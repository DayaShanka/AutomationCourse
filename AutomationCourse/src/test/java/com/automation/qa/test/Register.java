package com.automation.qa.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.qa.base.Base;

public class Register extends Base {

	WebDriver driver;

	public Register() {
		super();
	}

	@BeforeMethod
	public void setup() {
		driver = launchBrowser("chrome");
		driver.get("http://automationexercise.com");
	}

	@Test
	public void registerUser() {

		WebElement clickOnSignup = driver.findElement(By.xpath("//a[contains(@href,\"/login\")]"));
		clickOnSignup.click();
		WebElement visibiltyOfText = driver.findElement(By.xpath("//h2[contains(text(),'New User Signup!')]"));
		String getTextOfSignUpPage = visibiltyOfText.getText();
		visibiltyOfText.isDisplayed();
		Assert.assertEquals(getTextOfSignUpPage, "New User Signup!");
		System.out.println("Text should be visble :-" + visibiltyOfText.getText());
		WebElement enterUserName = driver.findElement(By.xpath("//input[contains(@data-qa,\"signup-name\")]"));
		enterUserName.sendKeys("DSC1111");
		WebElement enterEmail = driver.findElement(By.xpath("//input[contains(@data-qa,\"signup-email\")]"));
		enterEmail.sendKeys("daya.choubey.111@gmail.com");
		WebElement clickOnSignupButton = driver.findElement(By.xpath("//button[contains(@data-qa,\"signup-button\")]"));
		clickOnSignupButton.click();
		WebElement visibilityOfTextAfterSignup = driver
				.findElement(By.xpath("//b[contains(text(),'Enter Account Information')]"));
		visibilityOfTextAfterSignup.isDisplayed();
		System.out.println("Text is visible: " + visibilityOfTextAfterSignup.getText());
		driver.findElement(By.id("id_gender1")).click();
		driver.findElement(By.id("password")).sendKeys("123456");
		WebElement daySelect = driver.findElement(By.name("days"));
		Select dselect = new Select(daySelect);
		dselect.selectByValue("4");
		WebElement monthSleect = driver.findElement(By.name("months"));
		Select mselect = new Select(monthSleect);
		mselect.selectByIndex(1);
		WebElement yearSelect = driver.findElement(By.name("years"));
		Select yselect = new Select(yearSelect);
		yselect.selectByVisibleText("2021");
		List<WebElement> selectCheckbox = driver.findElements(By.xpath("//input[contains(@type,\"checkbox\")]"));
		for (WebElement selectCheckboxs : selectCheckbox) {
			if (!selectCheckboxs.isSelected()) { // selection of list of checkboxes
				selectCheckboxs.click();
			}

//			if (selectCheckbox.size() > 0) { //single selection of checkbox
//				WebElement checkboxToSelect = selectCheckbox.get(0);
//				
//				checkboxToSelect.click();
//				if (!checkboxToSelect.isSelected()) {
//					checkboxToSelect.click(); 
//				}
//			}
		}

		WebElement fName = driver.findElement(By.id("first_name"));
		fName.sendKeys("daya");
		WebElement lName = driver.findElement(By.id("last_name"));
		lName.sendKeys("choubey");
		WebElement cName = driver.findElement(By.id("company"));
		cName.sendKeys("Think");
		WebElement address1 = driver.findElement(By.id("address1"));
		address1.sendKeys("A48");
		WebElement address2 = driver.findElement(By.id("address2"));
		address2.sendKeys("Sec58");
		WebElement country = driver.findElement(By.id("country"));
		Select selectCountry = new Select(country);
		selectCountry.selectByVisibleText("India");
		WebElement state = driver.findElement(By.id("state"));
		state.sendKeys("UP");
		WebElement city = driver.findElement(By.id("city"));
		city.sendKeys("Noida");
		WebElement zipcode = driver.findElement(By.id("zipcode"));
		zipcode.sendKeys("201301");
		WebElement mobileNumber = driver.findElement(By.id("mobile_number"));
		mobileNumber.sendKeys("0987654321");
		WebElement createButton = driver.findElement(By.xpath("//button[text()='Create Account']"));
		createButton.click();
		WebElement visibilityofSuccessMessage = driver.findElement(By.xpath("//b[text()='Account Created!']"));
		if (visibilityofSuccessMessage.isDisplayed() == true) {
		}
		System.out.println("Success Message:- " + driver
				.findElement(By.xpath("//p[text()='Congratulations! Your new account has been successfully created!']"))
				.getText());
		driver.findElement(By.xpath("//a[text()='Continue']")).click();
//		WebElement loggedInAsUserName = driver
//				.findElement(By.xpath("//a/text()[normalize-space() and contains(., 'Logged in as')] | //a/b/text()"));
		WebElement loggedInAsUserName = driver.findElement(By.xpath("//b[text()='DSC1111']"));
		System.out.println("Expected Name of USER:- " + loggedInAsUserName.getText());
		// WebElement deleteAccount =
		// driver.findElement(By.xpath("//a[contains(@href,\"/delete_account\")]"));
		// deleteAccount.click();
		boolean deletedMessage = driver.findElement(By.xpath("//b[text()='Account Deleted!']")).isDisplayed();
		if (deletedMessage == true) {
			System.out.println("Account Deleted!");
			driver.findElement(By.xpath("//a[text()='Continue']")).click();
		}

	}

}