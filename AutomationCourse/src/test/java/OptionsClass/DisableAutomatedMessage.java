package OptionsClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DisableAutomatedMessage {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		// disable automation message from webpage
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://automationexercise.com/");
		driver.manage().window().maximize();
		driver.quit();
	}

}