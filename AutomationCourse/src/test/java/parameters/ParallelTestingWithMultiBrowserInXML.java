package parameters;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelTestingWithMultiBrowserInXML {

	WebDriver driver;

	@Parameters(value = { "browser", "url" })
	@BeforeMethod
	void setup(String br, String url) { // inputed the parameters so that can access value from XML

		switch (br.toLowerCase()) {

		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Not found");
			return;
		}

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(priority = 1)
	void testLogo() {

		boolean logoVisibility = driver.findElement(By.xpath("//img[@src=\"/static/image/send-online-logo.png?v5\"]"))
				.isDisplayed();
		Assert.assertEquals(logoVisibility, true);
		System.out.println("Logo is visible on the page..");
	}

	@Test(priority = 2)
	void testTitle() {

		System.out.println("Title of the Page: " + driver.getTitle());
	}

	@Test(priority = 3)
	void testURL() {

		System.out.println("Current URL of the Page: " + driver.getCurrentUrl());
	}

	@AfterMethod
	void tearDown() {

		driver.quit();
	}

}
