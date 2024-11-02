package optionsClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class IncoginitoMode {

	public static void main(String[] args) {


		ChromeOptions options = new ChromeOptions();
		//run the same script in incognito mode
		options.addArguments("--incognito");
		WebDriver driver  = new ChromeDriver(options);
		driver.get("https://automationexercise.com/");
		driver.manage().window().maximize();
	}

}
