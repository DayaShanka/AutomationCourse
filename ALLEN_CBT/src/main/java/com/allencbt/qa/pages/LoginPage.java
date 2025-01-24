package com.allencbt.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.allencbt.qa.actiondriver.ActionDriver;

public class LoginPage extends ActionDriver {

	ActionDriver action;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	private By emailField = By.name("loginId");
	private By passwordField = By.name("password");
	private By loginButton = By.name("loginSubmit");

	@Test
	public void login(String email, String password) {
		action.enterValue(emailField, "abc@gmail.com");
		action.enterValue(passwordField, "123456");
		action.click(loginButton);
	}

}
