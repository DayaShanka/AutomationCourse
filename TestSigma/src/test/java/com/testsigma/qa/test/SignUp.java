package com.testsigma.qa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testsigma.qa.base.Base;

public class SignUp extends Base {

	public SignUp() {
		super();
	}

	WebDriver driver;

	@BeforeMethod
	public void setup() {

		driver = initilizeBrowser("Chrome");
		driver.manage().window().maximize();
		driver.get("https://travel.testsigma.com/login");
		driver.findElement(By.xpath("//a[contains(@href,\"signup\") and @class='float-right']")).click();

	}

	@Test
	public void signUpWithValidDetails() {
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("dev");
		driver.findElement(By.cssSelector("#emailid")).sendKeys("dev@gmail.com");
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("8800192257");
		driver.findElement(By.xpath("//input[@id='address']")).sendKeys("sec 62 noida");
		driver.findElement(By.xpath("//span[contains(text(),'26 to 55')]")).click();
		driver.findElement(By.xpath("//label[contains(text(),'Male')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'movies')]")).click();
		driver.findElement(By.xpath("//label[contains(text(),'Job')]")).click();
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@id='cpass']")).sendKeys("123456");
		driver.findElement(By.xpath("//button[contains(text(),'Register')]")).click();

	}

	@Test
	public void loginAndLogOut() {
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("dev");
		driver.findElement(By.cssSelector("#emailid")).sendKeys("dev@gmail.com");
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("8800192257");
		driver.findElement(By.xpath("//input[@id='address']")).sendKeys("sec 62 noida");
		driver.findElement(By.xpath("//span[contains(text(),'26 to 55')]")).click();
		driver.findElement(By.xpath("//label[contains(text(),'Male')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'movies')]")).click();
		driver.findElement(By.xpath("//label[contains(text(),'Job')]")).click();
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@id='cpass']")).sendKeys("123456");
		driver.findElement(By.xpath("//button[contains(text(),'Register')]")).click();
		driver.findElement(By.cssSelector(".material-icons.acc_icon")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
	}

	@Test
	public void loginAfterSignUp() {
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("dev");
		driver.findElement(By.cssSelector("#emailid")).sendKeys("dev@gmail.com");
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("8800192257");
		driver.findElement(By.xpath("//input[@id='address']")).sendKeys("sec 62 noida");
		driver.findElement(By.xpath("//span[contains(text(),'26 to 55')]")).click();
		driver.findElement(By.xpath("//label[contains(text(),'Male')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'movies')]")).click();
		driver.findElement(By.xpath("//label[contains(text(),'Job')]")).click();
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@id='cpass']")).sendKeys("123456");
		driver.findElement(By.xpath("//button[contains(text(),'Register')]")).click();
		driver.findElement(By.cssSelector(".material-icons.acc_icon")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		driver.findElement(By.xpath("//a[@href=\"login\"]")).click();
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
