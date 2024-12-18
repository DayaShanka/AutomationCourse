package OptionsClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BadSSLCertification {

	public static void main(String[] args) {

		ChromeOptions option = new ChromeOptions();
		option.setAcceptInsecureCerts(true); // to handle "connection is not private" on the web page
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://expired.badssl.com/");
		driver.manage().window().maximize();

	}

}
