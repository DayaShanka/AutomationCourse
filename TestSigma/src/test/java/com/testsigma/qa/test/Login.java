package com.testsigma.qa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testsigma.qa.base.Base;

public class Login extends Base {

	public Login() {
		super();
	}

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = initilizeBrowser(prop.getProperty("browserName"));
		driver.manage().window().maximize();
		driver.get("https://travel.testsigma.com/login");

	}

	@Test
	public void signUpWithValidDetails() {
		driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("dev");
		driver.findElement(By.xpath("//input[@id='icon_telephone']")).sendKeys("123456");
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[2]/form[1]/div[4]/button[1]")).click();

	}

//	@AfterMethod
//	public void tearDown() {
//		if (driver != null) {
//			driver.quit();
//		}
//	}

}
