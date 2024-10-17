package com.automation.qa.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableHandle {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		List<WebElement> rows = driver.findElements(By.xpath("//table[@name=\"BookTable\"]//tr"));
		System.out.println("Total rows of table: " + rows.size());

		List<WebElement> cols = driver.findElements(By.xpath("//table[@name=\"BookTable\"]//th"));
		System.out.println("Total colum of table: " + cols.size());
		System.out.println(
				"------------------------------------------------------------------------------------------------");

		for (WebElement data : rows) {
			String allRowsAndCols = data.getText();
			System.out.println(allRowsAndCols + "\t");
		}

		// get the individual data value from table
		String gettabletext1 = driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr[2]//td[1]")).getText();
		System.out.println("getting indivudual rows as: " + gettabletext1);
		System.out.println(
				"------------------------------------------------------------------------------------------------");

		// get the all data value from table
		System.out.println("BookName" + "\t" + "Author" + "\t" + "Subject" + "\t" + "Price" + "\t");
		for (int r = 2; r <= rows.size(); r++) {

			for (int c = 1; c <= cols.size(); c++) {

				String gettabletext = driver
						.findElement(By.xpath("//table[@name=\"BookTable\"]//tr[" + r + "]//td[" + c + "]")).getText();
				System.out.print(gettabletext + "\t");
			}
			System.out.println("");
		}

	}

}
