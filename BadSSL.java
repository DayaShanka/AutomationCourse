package optionsClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BadSSL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		ChromeOptions options = new ChromeOptions();
		//acccept ssl certificates of the webpage
		options.setAcceptInsecureCerts(true);
		WebDriver driver  = new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");
		driver.manage().window().maximize();
		
	}

}
