package optionsClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MyChromeOptions {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		//without see any UI we can run the script
		options.addArguments("--headless=new");
		options.setAcceptInsecureCerts(true);
		WebDriver driver  = new ChromeDriver(options);
		driver.get("https://automationexercise.com/");
		driver.manage().window().maximize();
		System.out.println("Headless testing completed");
	}

}
