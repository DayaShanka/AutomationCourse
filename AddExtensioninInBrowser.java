package optionsClass;
import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AddExtensioninInBrowser {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		//Add extenstions in browser
		File file = new File("C:\\CRX\\selectorhub.crx");
		options.addExtensions(file);
		WebDriver driver  = new ChromeDriver(options);
		driver.get("https://automationexercise.com/");
		driver.manage().window().maximize();
	}

}
