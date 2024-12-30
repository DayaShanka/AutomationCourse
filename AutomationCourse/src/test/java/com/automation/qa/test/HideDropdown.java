package Dropdowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HideDropdown {

	public static void main(String[] args) throws InterruptedException {

		// we have 3 types of dropdown

		WebDriver driver = new ChromeDriver();
//		1. normal select dropdown
//		2. Boostrap Dropdown
//		3. hide element dropdown

		// 3. Hide Dropdown

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(4));
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='PIM']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//body/div[@id='app']/div[@class='oxd-layout orangehrm-upgrade-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-background-container']/div[@class='oxd-table-filter']/div[@class='oxd-table-filter-area']/form[@class='oxd-form']/div[@class='oxd-form-row']/div[@class='oxd-grid-4 orangehrm-full-width-grid']/div[3]/div[1]/div[2]/div[1]/div[1]"))
				.click();

		try {
			List<WebElement> dropdown = driver.findElements(By.xpath("//div[@role='listbox']//div//span"));
			System.out.println("Size of all dropdown: " + dropdown.size());

			for (WebElement options : dropdown) {
				String alloptions = options.getText();

				if (alloptions.equals("Full-Time Probation")) {
					options.click();
					driver.findElements(By.xpath("//div[@role='listbox']//div//span"));
				}

			}
		} catch (StaleElementReferenceException e) {
			System.out.println("getting exception: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("exception: " + e.getMessage());
		}

	}

}
