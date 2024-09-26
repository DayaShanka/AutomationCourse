package com.testsigma.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageWebelement {

	WebDriver driver;
	@FindBy(id = "logo-img")
	WebElement logo;
	@FindBy(xpath = "//div[contains(text(),'One way Flying')]")
	WebElement radioButton;
	@FindBy(xpath = "//div[contains(@class, 'gws-flights-form__location-text')]")
	WebElement fromCity;
	@FindBy()
	WebElement toCity;

	public HomePageWebelement(WebDriver driver) {

		driver = this.driver;
		PageFactory pf = new PageFactory();
		pf.initElements(driver, this);
	}

	public boolean logiVisibility() {
		return logo.isDisplayed();
	}

	public boolean radioButtonSelected() {

		return radioButton.isEnabled();
	}

	public void fromCity() {
		fromCity.click();
	}

	public void toCity() {
		toCity.click();
	}
}
