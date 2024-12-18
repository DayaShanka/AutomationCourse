package OptionsClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DisableNotification {

	public static void main(String[] args) {

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications"); // to hide the page notification popup
		WebDriver driver = new ChromeDriver(option);
		driver.get("http://wordpressdemo.webkul.com/wordpress-latest-tweets/");
		driver.manage().window().maximize();

	}

}
