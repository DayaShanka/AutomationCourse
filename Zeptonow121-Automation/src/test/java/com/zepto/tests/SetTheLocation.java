package com.zepto.tests;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.zepto.base.TestBase;
import com.zepto.pages.SetLocationPopup;

public class SetTheLocation extends TestBase {

	public SetTheLocation() throws IOException {
		super();
	}

	@Test
	@Parameters({ "browser" })
	public void testGetLocationButtonText() throws InterruptedException {

		SetLocationPopup locationPopup = new SetLocationPopup(driver);
		String expectedString = "Use Current Location";
		locationPopup.clickButtonByText(expectedString);
		Thread.sleep(3000);
		// System.out.println(locationPopup.getAllButtonTexts());
		if (locationPopup.logoVisibility() == true) {
			System.out.println("Zepto logo visble");
		}
//		assertEquals(driver.getCurrentUrl().contains("400"), true); // we can check broken url
//		Assert.assertEquals(driver.getPageSource().contains("400") || driver.getTitle().contains("404"), false);

	}

}
