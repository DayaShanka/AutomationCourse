package OptionsClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RunScriptWithoutUI {

	public static void main(String[] args) {

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--headless"); // run a script using Selenium without a UI
		WebDriver driver = new ChromeDriver(option);
		driver.get("http://wordpressdemo.webkul.com/wordpress-latest-tweets/");
		driver.manage().window().maximize();
		System.out.println("Test Completed");

	}

}
