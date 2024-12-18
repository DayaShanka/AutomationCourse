package Dropdowns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SuggestedDropdown2 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")).sendKeys("Java");
		driver.findElement(By.xpath("//input[@class='wikipedia-search-button']")).click();
		Thread.sleep(5000);

		// Locating all search results
		List<WebElement> list = driver.findElements(By.xpath("//div[@id='Wikipedia1_wikipedia-search-results']//a"));
		System.out.println("Number of search results: " + list.size());

		// Loop through all the results
		for (int i = 0; i < list.size(); i++) {
			String options = list.get(i).getText(); // Get the text of each result
			System.out.println(options);

			// Click the result if it matches the desired text
			if (options.equals("Java")) { // Adjust this to match any text you're looking for
				list.get(i).click();
				break; // Exit the loop once the desired option is clicked
			}
		}
	}
}
