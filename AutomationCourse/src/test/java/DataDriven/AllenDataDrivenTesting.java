package DataDriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AllenDataDrivenTesting {

	public static void main(String[] args) throws IOException, InterruptedException {

		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\config.properties");
		Properties prop = new Properties();
		prop.load(fis);

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(option);
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String excelFilePath = System.getProperty("user.dir") + "\\testdatafile\\Allen_login_data.xlsx";

		int rowCount = ExcelUtills.getRowCount(excelFilePath, "Sheet1");
		System.out.println("No. of rows count :- " + rowCount);

		int columnCount = ExcelUtills.getCellCount(excelFilePath, "Sheet1", rowCount);
		System.out.println("No. of column count :- " + columnCount);

		for (int r = 1; r <= rowCount; r++) {
			String enrollment_no = ExcelUtills.getCellData(excelFilePath, "Sheet1", r, 0);
			String password = ExcelUtills.getCellData(excelFilePath, "Sheet1", r, 1);
			String captcha = ExcelUtills.getCellData(excelFilePath, "Sheet1", r, 2);
			String expected_result = ExcelUtills.getCellData(excelFilePath, "Sheet1", r, 3);

			driver.findElement(By.name("user")).sendKeys(enrollment_no);
			driver.findElement(By.name("pass")).sendKeys(password);
			driver.findElement(By.name("reg-code")).sendKeys(captcha);
			driver.findElement(By.id("submit")).click();
			Thread.sleep(3000);
			String actual_result = driver
					.findElement(By.xpath("//span[@class='main-title ng-star-inserted' and text()='Schedule ']"))
					.getText();
			Thread.sleep(2000);

			if (expected_result.equalsIgnoreCase(actual_result)) {
				System.out.println(enrollment_no + "-->" + "Login successfully and landed on " + actual_result);
				ExcelUtills.setCellData(excelFilePath, "Sheet1", r, 4, "Logged In");
				ExcelUtills.fillGreenColor(excelFilePath, "Sheet1", r, 4);

			} else {
				System.out.println(enrollment_no + "-->" + "Login Failed");
				ExcelUtills.setCellData(excelFilePath, "Sheet1", r, 4, "Failed");
				ExcelUtills.fillRedColor(excelFilePath, "Sheet1", r, 4);
			}
			// logout the data with each loop
			driver.findElement(By.xpath("//div[@class='profile-drop session_drop']")).click();
			WebElement logout = driver.findElement(
					By.xpath("//a[@class='dropdown-item d-flex align-items-center' and text()=' Logout']"));
			logout.click();
		}
		driver.quit();

	}

}
