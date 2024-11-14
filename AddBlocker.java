package optionsClass;
import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AddBlocker {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		//Add extenstions in browser
		File file = new File("C:\\CRX\\addblocker.crx");
		options.addExtensions(file);
		WebDriver driver  = new ChromeDriver(options);
		driver.get("https://text-compare.com/");
		driver.manage().window().maximize();

	}

}		

