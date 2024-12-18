package DataDriven;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DataGet {

	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://cleartax.in/s/simple-compound-interest-calculator");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String excelPath = System.getProperty("user.dir") + "//testdatafile\\FDdata.xlsx";
		int row = ExcelUtills.getRowCount(excelPath, "Sheet1"); // store the rowcount
		System.out.println("Count of Rows: " + row);

		int Column = ExcelUtills.getCellCount(excelPath, "Sheet1", row);
		System.out.println("Count of Columns: " + Column);

		// reading the data
		driver.findElement(By.xpath("//input[@id='principleAmount']")).clear();
		driver.findElement(By.xpath("//input[@id='annualrate']")).clear();
		driver.findElement(By.xpath("//input[@id='periodInDigit']")).clear();
		Thread.sleep(2000);

		for (int r = 1; r <= row; r++) {

			String principalAmount = ExcelUtills.getCellData(excelPath, "Sheet1", r, 0);
			String annualRate = ExcelUtills.getCellData(excelPath, "Sheet1", r, 1);
			String periodUnit = ExcelUtills.getCellData(excelPath, "Sheet1", r, 2);
			String periodValue = ExcelUtills.getCellData(excelPath, "Sheet1", r, 3);
			String expExcelValue = ExcelUtills.getCellData(excelPath, "Sheet1", r, 4);

			// sending above data in the application

			// driver.findElement(By.xpath("//input[@id='input_investmentOption_0']")).click();
			driver.findElement(By.xpath("//input[@id='principleAmount']")).sendKeys(principalAmount);
			driver.findElement(By.xpath("//input[@id='annualrate']")).sendKeys(annualRate);
			Select select = new Select(driver.findElement(By.xpath("//select[@id='periodUnit']")));
			select.selectByVisibleText(periodUnit);
			driver.findElement(By.xpath("//input[@id='periodInDigit']")).sendKeys(periodValue);
			String expValue = driver
					.findElement(By.xpath("(//div[@class='flex justify-between items-center gap-2 p-3'])[3]//span[2]"))
					.getText();
			Thread.sleep(2000);
			// validation

			if (Double.parseDouble(expValue.replace(",", "")) == Double.parseDouble(expExcelValue.replace(",", ""))) {
				System.out.println("Test Passed");
				ExcelUtills.setCellData(excelPath, "Sheet1", r, 5, "Passed");
				ExcelUtills.fillGreenColor(excelPath, "Sheet1", r, 5);
			} else {
				System.out.println("Test Failed");
				ExcelUtills.setCellData(excelPath, "Sheet1", r, 5, "Failed");
				ExcelUtills.fillRedColor(excelPath, "Sheet1", r, 5);
			}

			driver.findElement(By.xpath("//input[@id='principleAmount']")).clear();
			driver.findElement(By.xpath("//input[@id='annualrate']")).clear();
			driver.findElement(By.xpath("//input[@id='periodInDigit']")).clear();
			Thread.sleep(2000);

		}
		driver.quit();

	}

}
