package DataProvider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

	WebDriver driver;

	@BeforeMethod
	void setup() {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(dataProvider = "dp")
	void login(String email, String pwd) {

		driver.get("https://support.orangehrm.com/portal/en/signin");
		driver.manage().window().maximize();

		driver.findElement(By.name("username")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@value='Sign In']")).click();
	}

	@DataProvider(name = "dp", indices = { 1 }) // indices - which sets of data should be used for test methods
	Object[][] testData() {

		Object data[][] = { { "abc@gmail.com", "123456" }, { "abc1@gmail.com", "123456" } };
		return data;

	}

}
