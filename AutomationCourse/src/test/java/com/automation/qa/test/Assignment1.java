package com.automation.qa.test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
Assignment 1
Use Selenium (or similar frameworks like Nightwatch) and Chrome to Automate the following:

Login to Gmail
Compose an email Subject - "Test Mail" and Body "Test Email Body"
Label email as "Social"
Send the email to the same account which was used to login (from and to addresses would be the same)
Wait for the email to arrive in the Inbox
Mark email as starred
Open the received email
Verify email came under proper Label i.e. "Social"
Verify the subject and body of the received email
*/
public class Assignment1 {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	String email = "daya.shankar@thinkexam.com";
	String password = "daya@4193";

	@BeforeMethod
	void setup() {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		options.addArguments("-disable--notifications");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		js = (JavascriptExecutor) driver;
	}

	@Test
	void loginGmail() throws InterruptedException {

		driver.get("https://mail.google.com/");
		driver.findElement(By.id("identifierId")).sendKeys(email);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Next']"))).click();
		driver.findElement(By.name("Passwd")).sendKeys(password);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Next']"))).click();

		WebElement mail = driver.findElement(By.xpath("//div[@class=\"V6 CL W9\"]"));
		WebElement composeMail = driver.findElement(By.xpath("//div[@class=\"T-I T-I-KE L3\"]"));
		Actions action = new Actions(driver);
		action.moveToElement(mail).click(composeMail).build().perform();
		Thread.sleep(2000);
		WebElement recipients = driver.findElement(By.xpath("//input[@class='agP aFw']"));
		js.executeScript("arguments[0].value= '" + email + "';", recipients);
		// driver.findElement(By.xpath("//div[@class='aoD hl']")).sendKeys(email);
		driver.findElement(By.name("subjectbox")).sendKeys("Test Mail");
		driver.findElement(By.xpath("//div[@class='Am aiL Al editable LW-avf tS-tW']")).sendKeys("Test Email Body");
		driver.findElement(By.xpath("//button[@title=\"Close\"]")).click();
		driver.findElement(By.xpath("//div[@data-tooltip=\"More options\"]")).click();
		WebElement label = driver.findElement(By.xpath("//div[@id=':49y']"));
		WebElement social = driver
				.findElement(By.xpath("//div[@class='J-LC-Jz']//div//following::text()[. = 'Social']"));
		action.moveToElement(label).click(social).build().perform();
		WebElement clickOnSent = driver.findElement(By.xpath("//div[@id=':3gb']"));
		clickOnSent.click();
		WebElement SocialTab = driver.findElement(By.xpath("//div[@id=':2e']"));
		SocialTab.click();
		// Step 5: Verify Subject and Body

		String subject = driver.findElement(By.xpath("//span[text()='Test Mail']")).getText();
		List<WebElement> body = driver.findElements(By.xpath("//span[@class='Zt']//following::text()"));

		for (WebElement bodyText : body) {
			bodyText.getText();
			if (bodyText.getText().contains("Test Email Body")) {
				driver.findElement(By.xpath("//td[@class='apU xY']//span[@data-tooltip=\"Not starred\"]")).click();
			}
		}

		// Assertions
		System.out.println("Subject: " + subject);
		System.out.println("Body: " + body);

		if (subject.equals("Test Mail") && body.contains("Test Email Body")) {
			System.out.println("Email verified successfully!");
		} else {
			System.out.println("Verification failed.");
		}
	}

}
