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
		System.out.println("Total number of rows: " + rows.size());

		List<WebElement> cols = driver.findElements(By.xpath("//table[@name=\"BookTable\"]//th"));
		System.out.println("Total number of colums: " + cols.size());
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

		// Sum of All the price List from the table
		int total = 0;
		List<WebElement> price = driver.findElements(By.xpath("//table[@name=\"BookTable\"]//td[4]"));
		for (WebElement totalPrice : price) {
			String allpriceFromTable = totalPrice.getText();
			total = total + Integer.parseInt(allpriceFromTable); // converting string to int

		}
		System.out.println("Sum of All the price List: " + total); // printing outside the loop so we can get the total
																	// sum of price

		// get the book name where author name ="Mukesh"

		List<WebElement> AuthorName = driver.findElements(By.xpath("//table[@name=\"BookTable\"]//td[2]"));
		for (WebElement AllAuthorName : AuthorName) {
			String getTheAuthor = AllAuthorName.getText();
			System.out.println("Authors name is: " + getTheAuthor);

			if (getTheAuthor.contains("Mukesh")) {

				List<WebElement> BookName = driver.findElements(By.xpath("//table[@name=\"BookTable\"]//td[1]"));
				for (int row = 2; row < BookName.size(); row++) {
					String dd = BookName.get(row).getText();
					System.out.println(dd);

				}
			}
		}
	}

}
