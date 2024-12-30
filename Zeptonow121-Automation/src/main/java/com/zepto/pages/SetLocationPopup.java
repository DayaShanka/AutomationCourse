package com.zepto.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SetLocationPopup extends BasePage {

	public SetLocationPopup(WebDriver driver) {
		super(driver); // Call the parent constructor to initialize elements
	}

	@FindBy(xpath = "//div[@class='mt-4 flex']//div//p")
	private List<WebElement> buttonsTexts;

	@FindBy(xpath = "//body/div[@id='react-portal-wrapper']/div[2]/div[1]/div[1]/div[2]/div[1]/button")
	private List<WebElement> locationButtons;

	@FindBy(xpath = "//img[@src=\"https://cdn.zeptonow.com/web-static-assets-prod/artifacts/12.24.0/images/header/primary-logo.svg\"]")
	private WebElement logo;

	// Method to click a button based on its text
	public void clickButtonByText(String buttonTextToMatch) {
		for (WebElement button : locationButtons) {
			if (button.getText().equals(buttonTextToMatch)) {
				button.click();
				System.out.println("Clicked button with text: " + buttonTextToMatch);
				return; // Exit the loop after clicking
			}
		}
		// System.out.println("No button found with text: " + buttonTextToMatch);
	}

	// Fetch text from all buttons
	public List<String> getAllButtonTexts() {
		return buttonsTexts.stream().map(WebElement::getText) // Extract text from each button
				.toList();
	}

	public boolean logoVisibility() {
		return logo.isDisplayed();
	}
}
