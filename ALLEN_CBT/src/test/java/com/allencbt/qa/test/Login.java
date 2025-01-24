package com.allencbt.qa.test;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.allencbt.qa.actiondriver.ActionDriver;
import com.allencbt.qa.base.BaseClass;

public class Login extends BaseClass {

	@Test
	public void login1() throws Exception {
		ActionDriver ac = new ActionDriver(driver);
		String title = driver.getTitle();
		System.out.println(title);
		ac.enterValue(By.id("loginId"), "alle.ac.in");
		ac.click(By.name("loginSubmit"));
		staticWait(2);
		System.out.println("gettext" + ac.getText(By.id("loginId")));

	}

}
