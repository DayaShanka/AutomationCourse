package DatePickers;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DatePickerFromDropdown {

	public static void main(String[] args) {

		WebDriver driver;
		driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//input[@id='txtDate']")).click();

		// expected dates
		String date = "20";
		String month = "Apr";
		String year = "2025";

		// select month from dropdown
		WebElement monthDropdown = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		Select selectMonth = new Select(monthDropdown);
		selectMonth.selectByVisibleText(month);

		// select year from dropdown
		WebElement yearDropdown = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select selectYear = new Select(yearDropdown);
		selectYear.selectByVisibleText(year);

		// select the date from table
		List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td//a"));

		for (WebElement dt : allDates) {
			if (dt.getText().equals(date)) {
				dt.click();
			}

		}

	}

}
