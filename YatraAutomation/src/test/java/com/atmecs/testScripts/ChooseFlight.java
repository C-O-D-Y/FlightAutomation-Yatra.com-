package com.atmecs.testScripts;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.atmecs.constants.YatraFlightBookingLocators;
import com.atmecs.dataProvider.CityDataProvider;
import com.atmecs.logReports.LogReport;
import com.atmecs.pages.HomePage;
import com.atmecs.testBase.TestBase;
import com.atmecs.testflow.HomePageFlow;

public class ChooseFlight extends TestBase {
	LogReport log = new LogReport();
	YatraFlightBookingLocators locators = new YatraFlightBookingLocators();
	HomePage home = new HomePage();

	@Test(priority = 1)
	public void homePageRedirection() {
		log.info("Starting Redirection validation");
		home.isRedirectionCorrect(driver);
		log.info("Redirection is on the correct page");
		log.info("Starting the homepage testing");
	}

	@Test(priority = 2, dataProvider = "cityinput", dataProviderClass = CityDataProvider.class)
	public void homePageCityInput(String fromCity, String toCity) throws InterruptedException {
		HomePageFlow.cityInput(driver, fromCity, toCity);
		home.isButtonDisplayed(driver);
		log.info("Round button is working properly");
	}

	@Test(priority = 3)
	public void isHomeDataCorrect() {
		List<String> data = home.changesInElement(driver);
		Assert.assertEquals(data.get(0), "BLR");
		Assert.assertEquals(data.get(1), "BOM");
		log.info("All the details of homepage are correct");
		HomePageFlow.dateInput(driver);
		driver.close();
	}
}