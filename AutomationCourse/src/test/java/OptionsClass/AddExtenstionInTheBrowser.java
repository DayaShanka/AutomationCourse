package OptionsClass;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AddExtenstionInTheBrowser {

	public static void main(String[] args) {

		ChromeOptions option = new ChromeOptions();
		// location of downloaded CRX extenstion
		File file = new File(
				"C:\\Users\\admin\\OneDrive\\Documents\\AdBlock-—-block-ads-across-the-web-Chrome-Web-Store.crx");
		File file2 = new File("C:\\Users\\admin\\Downloads\\SelectorsHub-XPath-Helper-Chrome-Web-Store.crx");
		option.addExtensions(file); // to add the extenstion in the browser page
		option.addExtensions(file2);
		option.addArguments("--disable-plugins");
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://letcode.in/test");
		driver.manage().window().maximize();

	}

}
