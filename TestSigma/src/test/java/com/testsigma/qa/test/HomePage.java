package com.testsigma.qa.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testsigma.qa.base.Base;
import com.testsigma.qa.pages.HomePageWebelement;

public class HomePage extends Base {

	public HomePage() {

		super();
	}

	WebDriver driver;

	@BeforeMethod
	public void setup() {

		driver = initilizeBrowser(prop.getProperty("browserName"));
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void fillingTripDetailsToSearchFlight() {

		HomePageWebelement hp = new HomePageWebelement(driver);

		Assert.assertTrue(hp.logiVisibility());
		Assert.assertTrue(hp.radioButtonSelected());
		hp.fromCity();
		List<WebElement> cities = driver
				.findElements(By.cssSelector(".dropdown-menu.fixed_dropdown.right.show .dropdown-item"));
		for (WebElement city : cities) {
			String cityName = city.getText();
			System.out.println(cityName);

			if (cityName.equals("New York City")) {
				city.click();
				break;
			}
		}

		driver.findElement(By.xpath("//input[@id='departure']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'15')]")).click();
		driver.findElement(By.cssSelector(
				"div.clearfix.d-flex.hide1:nth-child(2) div.col-12.p-0.col-xl-12.col-lg-12.col-md-12.col-sm-12.ng-scope div.p-2.bg-dark.position-relative.w-100.ng-scope div.container.d-flex.p-0.my-0.align-center.flex-sm-column.flex-column.flex-xl-row.flex-lg-row.flex-md-row:nth-child(2) div.py-1.px-2.bg-secondary.d-flex.flex-column.position-relative.mr-xl-1.mr-lg-1.mr-md-1.mt-2.mt-sm-2.mt-xl-0.mt-lg-0.mt-md-0.rounded:nth-child(4) div.modal.datepicker-modal.open div.modal-content.datepicker-container div.datepicker-calendar-container div.datepicker-footer div.confirmation-btns > button.btn-flat.datepicker-done.waves-effect:nth-child(2)"))
				.click();
		driver.findElement(By.xpath("//span[contains(text(),'Adult, Economy')]")).click();
		driver.findElement(
				By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[5]/div[2]/div[1]/div[2]/div[1]/ul[1]/li[2]"))
				.click();
		driver.findElement(By.xpath("//button[contains(text(),'DONE')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Search flights')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Book Now')]")).click();

	}

}
